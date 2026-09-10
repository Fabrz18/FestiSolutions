package com.upc.festisolutions.services;
import com.upc.festisolutions.dto.ValoracionEventoDTO;
import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Contratoevento;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.entities.Valoracionevento;
import com.upc.festisolutions.interfaces.IValoracionEventoService;
import com.upc.festisolutions.repository.AnfitrionRepository;
import com.upc.festisolutions.repository.ContratoEventoRepository;
import com.upc.festisolutions.repository.EventoRepository;
import com.upc.festisolutions.repository.ValoracionEventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class ValoracionEventoService implements IValoracionEventoService {
    @Autowired
    private ValoracionEventoRepository valoracionEventoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AnfitrionRepository anfitrionRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ContratoEventoRepository contratoEventoRepository;
    @Override
    public ValoracionEventoDTO alternarFavorito(Integer idAnfitrion, Integer idEvento) {
        Valoracionevento existente = valoracionEventoRepository
                .findByAnfitrion_IdAndEvento_Id(idAnfitrion, idEvento);
        Valoracionevento valoracion;
        if (existente != null) {
            Evento evento = existente.getEvento();
            if (evento.getEstado().equals("Eliminado")) {
                throw new RuntimeException("No se puede marcar como favorito un evento eliminado.");
            }
            existente.setFavorito(!existente.getFavorito());
            valoracion = valoracionEventoRepository.save(existente);
        } else {
            Evento evento = eventoRepository.findById(idEvento)
                    .orElseThrow(() -> new RuntimeException("Evento no encontrado."));
            if (evento.getEstado().equals("Eliminado")) {
                throw new RuntimeException("No se puede marcar como favorito un evento eliminado.");
            }
            Anfitrion anfitrion = anfitrionRepository.findById(idAnfitrion)
                    .orElseThrow(() -> new RuntimeException("Anfitrión no encontrado."));
            valoracion = new Valoracionevento();
            valoracion.setFavorito(true);
            valoracion.setAnfitrion(anfitrion);
            valoracion.setEvento(evento);
            valoracion = valoracionEventoRepository.save(valoracion);
        }
        return modelMapper.map(valoracion, ValoracionEventoDTO.class);
    }
    @Override
    public ValoracionEventoDTO alternarFavoritoContrato(Integer idAnfitrion, Integer idContratoEvento) {
        Contratoevento contrato = contratoEventoRepository.findById(idContratoEvento)
                .orElseThrow(() -> new RuntimeException("Contrato de evento no encontrado."));

        Evento evento = contrato.getEvento();
        return alternarFavorito(idAnfitrion, evento.getId());
    }
    @Override
    public List<ValoracionEventoDTO> listarValoracionEventoPorAnfitrion(Integer idAnfitrion) {
        List<Valoracionevento> valoraciones = valoracionEventoRepository.findAllByAnfitrion_IdAndFavoritoTrue(idAnfitrion);
        return valoraciones.stream()
                .filter(valoracion -> valoracion.getEvento() != null &&
                        !valoracion.getEvento().getEstado().equals("Eliminado"))
                .map(valoracion -> modelMapper.map(valoracion, ValoracionEventoDTO.class))
                .toList();
    }
}
