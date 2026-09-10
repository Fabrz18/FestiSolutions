package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.entities.*;
import com.upc.festisolutions.interfaces.IEventoService;
import com.upc.festisolutions.repository.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventoService implements IEventoService {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DistritoRepository distritoRepository;
    @Autowired
    private TipoEventoRepository tipoEventoRepository;
    @Autowired
    private ResenaEventoService resenaEventoService;

    @Override
    public EventoDTO registrarEvento(EventoDTO eventoDTO) {
        if (eventoDTO.getId() == null){
            Evento evento = modelMapper.map(eventoDTO, Evento.class);
            evento.setEstado("Disponible");
            evento.setValoracion(0.0);
            eventoRepository.save(evento);
            return modelMapper.map(evento, EventoDTO.class);
        }
        return null;
    }
    @Override
    public void eliminarEvento(Integer id){
        Evento evento = eventoRepository.findById(id).orElse(null);
        if (evento != null){
            evento.setEstado("Eliminado");
            eventoRepository.save(evento);
        }
    }
    @Override
    public EventoDTO actualizarEvento(EventoDTO eventoDTO) {
        if (eventoDTO.getId() != null){
            Evento evento = eventoRepository.findById(eventoDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
            evento.setTitulo(eventoDTO.getTitulo());
            evento.setDescripcion(eventoDTO.getDescripcion());
            evento.setFechainicio(eventoDTO.getFechainicio());
            evento.setFechafin(eventoDTO.getFechafin());
            evento.setDistrito(eventoDTO.getDistrito());
            evento.setPresupuesto(eventoDTO.getPresupuesto());
            evento.setValoracion(eventoDTO.getValoracion());
            evento.setEstado(eventoDTO.getEstado());
            evento.setAforo(eventoDTO.getAforo());
            eventoRepository.save(evento);
            return modelMapper.map(evento, EventoDTO.class);
        }
        return null;
    }
    @Override
    public List<EventoDTO> listarEvento(){
        List<Evento> eventos = eventoRepository.findAllByEstadoEquals("Disponible");
        return eventos.stream().map(evento  -> modelMapper.map(evento, EventoDTO.class)).toList();
    }
    @Override
    public EventoDTO buscarEventoPorId(Integer id){
        Evento evento = eventoRepository.findById(id).orElse(null);
        return modelMapper.map(evento, EventoDTO.class);
    }
    @Override
    public List<EventoDTO> listarEventosAleatorios() {
        List<Evento> eventos = eventoRepository.findAllByEstadoEquals("Disponible");
        if (eventos.isEmpty()) {
            return Collections.emptyList();
        }
        Collections.shuffle(eventos);
        return eventos.stream().map(evento -> modelMapper.map(evento, EventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> listarEventoFiltroAvanzado(Integer distritoId, Integer tipoEventoId, LocalDate fechaInicio, LocalDate fechaFin, Integer aforoMin, Integer aforoMax, Double presupuestoMin, Double presupuestoMax) {
        if (fechaInicio.isAfter(fechaFin)) {
            return null;
        }
        Distrito distrito = distritoRepository.findById(distritoId).orElse(null);
        Tipoevento tipoevento = tipoEventoRepository.findById(tipoEventoId).orElse(null);
        List<Evento> eventos = eventoRepository.listarPorFiltros(distrito, tipoevento, fechaInicio, fechaFin, aforoMin, aforoMax, presupuestoMin, presupuestoMax);

        return eventos.stream().map(evento -> modelMapper.map(evento, EventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> listarEventoFiltroBasico(Integer idDistrito, Integer aforo, LocalDate fechainicio) {
        List<Evento> eventos = eventoRepository.findByDistrito_IdAndAforoGreaterThanEqualAndFechainicioGreaterThanEqualAndEstado(idDistrito, aforo, fechainicio, "Disponible");
        return eventos.stream().map(evento -> modelMapper.map(evento, EventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> listarEventoPorProveedor(Integer idProveedor) {
        List<Evento> eventos = eventoRepository.findAllByProveedor_IdAndEstadoNot(idProveedor, "Eliminado");
        return eventos.stream().map(evento -> modelMapper.map(evento, EventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Integer calcularCantidadResenasPorEvento(Integer id) {
        List<ResenaEventoDTO> resenas = resenaEventoService.listarResenaEventoSegunEvento(id);
        return resenas.size();
    }
}
