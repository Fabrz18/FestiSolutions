package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.entities.Distrito;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.entities.Tipoevento;
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

    @Override
    public EventoDTO registrarEvento(EventoDTO eventoDTO) {
        if (eventoDTO.getId() == null){
            Evento evento = modelMapper.map(eventoDTO, Evento.class);
            if (evento.getFechafin().isBefore(evento.getFechainicio())){
                throw new RuntimeException("La fecha fin no puede ser inferior a la fecha inicial");
            }
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
            Double valoracion = eventoDTO.getValoracion();
            String estado = eventoDTO.getEstado();
            Evento evento = modelMapper.map(eventoDTO, Evento.class);
            if (evento.getFechafin().isBefore(evento.getFechainicio())){
                throw new RuntimeException("La fecha fin no puede ser inferior a la fecha inicial");
            }
            evento.setValoracion(valoracion);
            evento.setEstado(estado);
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
    public List<FiltradoEventoDTO> listarEventoFiltroAvanzado(Integer distritoId, Integer tipoEventoId, LocalDate fechaInicio, LocalDate fechaFin, Integer aforo, Double presupuesto) {
        if (fechaInicio.isAfter(fechaFin)) {
            return null;
        }
        Distrito distrito = distritoRepository.findById(distritoId).orElse(null);
        Tipoevento tipoevento = tipoEventoRepository.findById(tipoEventoId).orElse(null);

        return eventoRepository.listarPorFiltros(distrito, tipoevento, fechaInicio, fechaFin, aforo, presupuesto);
    }

    @Override
    public List<EventoDTO> listarEventoFiltroBasico(Integer idDistrito, Integer aforo, LocalDate fechainicio) {
        List<Evento> eventos = eventoRepository.findByDistrito_IdAndAforoGreaterThanEqualAndFechainicioGreaterThanEqualAndEstado(idDistrito, aforo, fechainicio, "Disponible");
        return eventos.stream().map(evento -> modelMapper.map(evento, EventoDTO.class)).collect(Collectors.toList());
    }
}
