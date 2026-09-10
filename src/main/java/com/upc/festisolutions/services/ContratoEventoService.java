package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.entities.*;
import com.upc.festisolutions.interfaces.IContratoEventoService;
import com.upc.festisolutions.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private ChatRepository chatRepository;
    @Autowired
    private ValoracionEventoRepository valoracionEventoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorFechaMasAntigua(Integer idAnfitrion) {
        List<Contratoevento> contratos = contratoEventoRepository.historialEventosPrimerFiltro(idAnfitrion);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }
    @Override
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorFechaMasReciente(Integer idAnfitrion) {
        List<Contratoevento> contratos = contratoEventoRepository.historialEventosSegundoFiltro(idAnfitrion);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }
    @Override
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorMayorPresupuesto(Integer idAnfitrion) {
        List<Contratoevento> contratos = contratoEventoRepository.historialEventosTercerFiltro(idAnfitrion);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }
    @Override
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorMenorPresupuesto(Integer idAnfitrion) {
        List<Contratoevento> contratos = contratoEventoRepository.historialEventosCuartoFiltro(idAnfitrion);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }
    @Override
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorMejorValoracion(Integer idAnfitrion) {
        List<Contratoevento> contratos = contratoEventoRepository.historialEventosQuintoFiltro(idAnfitrion);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }
    @Override
    public List<ContratoEventoDTO> historialEventoSegunAnfitrionPorPeorValoracion(Integer idAnfitrion) {
        List<Contratoevento> contratos = contratoEventoRepository.historialEventosSextoFiltro(idAnfitrion);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }
    @Override
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorFechaMasReciente(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        List<Contratoevento> contratos = contratoEventoRepository.historialContratosPrimerFiltro(idProveedor);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorFechaMasAntigua(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        List<Contratoevento> contratos = contratoEventoRepository.historialContratosSegundoFiltro(idProveedor);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorMayorPresupuesto(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        List<Contratoevento> contratos = contratoEventoRepository.historialContratosTercerFiltro(idProveedor);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorMenorPresupuesto(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        List<Contratoevento> contratos = contratoEventoRepository.historialContratosCuartoFiltro(idProveedor);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorMejorValoracion(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        List<Contratoevento> contratos = contratoEventoRepository.historialContratosQuintoFiltro(idProveedor);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContratoEventoDTO> historialContratosSegunProveedorPorPeorValoracion(Integer idEvento) {
        Evento evento = eventoRepository.findById(idEvento).orElse(null);
        if (evento.getProveedor() == null) {
            throw new RuntimeException("El evento no tiene proveedor asignado");
        }
        Integer idProveedor = evento.getProveedor().getId();
        List<Contratoevento> contratos = contratoEventoRepository.historialContratosSextoFiltro(idProveedor);
        return contratos.stream().map(contrato -> modelMapper.map(contrato, ContratoEventoDTO.class)).collect(Collectors.toList());
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
            Chat chat = new Chat();
            chat.setFechacreacion(LocalDateTime.now());
            chat.setFechaultimomensaje(null);
            chat.setEstado("ABIERTO");
            chat.setProveedor(proveedor);
            chat.setAnfitrion(anfitrion);
            chat.setTitulo(evento.getTitulo());
            chatRepository.save(chat);
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
            Evento evento = contratoevento.getEvento();
            evento.setEstado("Disponible");
            eventoRepository.save(evento);
            contratoEventoRepository.save(contratoevento);
            Integer idAnfitrion = contratoevento.getAnfitrion().getId();
            Integer idProveedor = evento.getProveedor().getId();
            List<Chat> chats = chatRepository.findAllByAnfitrion_IdAndProveedor_Id(idAnfitrion, idProveedor);
            for (Chat chat : chats) {
                chat.setEstado("Finalizado");
                chatRepository.save(chat);
            }
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
