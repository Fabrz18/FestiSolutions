package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.entities.*;
import com.upc.festisolutions.interfaces.IContratoEventoService;
import com.upc.festisolutions.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoEventoService implements IContratoEventoService {
    @Autowired
    private ContratoEventoRepository contratoEventoRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private AnfitrionRepository anfitrionRepository;
    @Autowired
    private GananciaEventoRepository gananciaEventoRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorFechaMasAntigua(Integer idAnfitrion) {
        return contratoEventoRepository.historialEventosPrimerFiltro(idAnfitrion);
    }
    @Override
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorFechaMasReciente(Integer idAnfitrion) {
        return contratoEventoRepository.historialEventosSegundoFiltro(idAnfitrion);
    }
    @Override
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMayorPresupuesto(Integer idAnfitrion) {
        return contratoEventoRepository.historialEventosTercerFiltro(idAnfitrion);
    }
    @Override
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMenorPresupuesto(Integer idAnfitrion) {
        return contratoEventoRepository.historialEventosCuartoFiltro(idAnfitrion);
    }

    @Override
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMejorValoracion(Integer idAnfitrion) {
        return contratoEventoRepository.historialEventosQuintoFiltro(idAnfitrion);
    }

    @Override
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorPeorValoracion(Integer idAnfitrion) {
        return contratoEventoRepository.historialEventosSextoFiltro(idAnfitrion);
    }

    @Override
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorFechaMasReciente(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        return contratoEventoRepository.historialContratosPrimerFiltro(idProveedor);
    }

    @Override
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorFechaMasAntigua(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        return contratoEventoRepository.historialContratosSegundoFiltro(idProveedor);
    }

    @Override
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMayorPresupuesto(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        return contratoEventoRepository.historialContratosTercerFiltro(idProveedor);
    }

    @Override
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMenorPresupuesto(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        return contratoEventoRepository.historialContratosCuartoFiltro(idProveedor);
    }

    @Override
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMejorValoracion(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        return contratoEventoRepository.historialContratosQuintoFiltro(idProveedor);
    }

    @Override
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorPeorValoracion(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        return contratoEventoRepository.historialContratosSextoFiltro(idProveedor);
    }

    @Override
    public ContratoEventoDTO eventoContratado(ContratoEventoDTO contratoEventoDTO) {
        if (contratoEventoDTO.getId() == null){
            Evento evento = eventoRepository.findById(contratoEventoDTO.getEvento().getId())
                    .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
            Anfitrion anfitrion = anfitrionRepository.findById(contratoEventoDTO.getAnfitrion().getId())
                    .orElseThrow(() -> new RuntimeException("Anfitrión no encontrado"));
            Contratoevento contratoevento = modelMapper.map(contratoEventoDTO, Contratoevento.class);
            contratoevento.setEvento(evento);
            contratoevento.setAnfitrion(anfitrion);
            contratoevento.setFechacontrato(evento.getFechainicio());
            contratoevento.setFechafinalizacion(evento.getFechafin());
            contratoevento.setEstado("En curso");
            evento.setEstado("En curso");
            Proveedor proveedor = evento.getProveedor();
            Double gananciaActual = proveedor.getGanancia();
            if (proveedor.getGanancia() == null){
                gananciaActual = 0.0;
            }
            proveedor.setGanancia(gananciaActual + evento.getPresupuesto());
            Gananciaevento gananciaEvento = new Gananciaevento();
            gananciaEvento.setEvento(evento);
            gananciaEvento.setGanancia(evento.getPresupuesto());
            gananciaEvento.setFechaobtencion(evento.getFechainicio());
            gananciaEventoRepository.save(gananciaEvento);
            proveedorRepository.save(proveedor);
            contratoEventoRepository.save(contratoevento);
            eventoRepository.save(evento);
            return modelMapper.map(contratoevento, ContratoEventoDTO.class);
        }
        return null;
    }

    @Override
    public ContratoEventoDTO eventoFinalizado(ContratoEventoDTO contratoEventoDTO) {
        if (contratoEventoDTO.getId() != null){
            Contratoevento contratoevento = contratoEventoRepository.findById(contratoEventoDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
            contratoevento.setEstado("Finalizado");
            contratoevento.setFechafinalizacion(LocalDate.now());
            Evento evento = contratoevento.getEvento();
            evento.setEstado("Disponible");
            eventoRepository.save(evento);
            contratoEventoRepository.save(contratoevento);
            return modelMapper.map(contratoevento, ContratoEventoDTO.class);
        }
        return null;
    }

    @Override
    public List<ContratoEventoDTO> verEventosContratados(Integer idAnfitrion) {
        List<Contratoevento> contratoEvento = contratoEventoRepository.findAllByAnfitrion_IdAndEstado(idAnfitrion, "En curso");
        return contratoEvento.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContratoEventoDTO> verContratosContrarados(Integer idProveedor) {
        List<Contratoevento> contratoEvento = contratoEventoRepository.contratosActuales(idProveedor,"En curso");
        return contratoEvento.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }
}
