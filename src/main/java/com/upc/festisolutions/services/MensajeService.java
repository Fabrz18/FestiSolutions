package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.MensajeDTO;
import com.upc.festisolutions.entities.Chat;
import com.upc.festisolutions.entities.Mensaje;
import com.upc.festisolutions.interfaces.IMensajeService;
import com.upc.festisolutions.repository.ChatRepository;
import com.upc.festisolutions.repository.MensajeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MensajeService implements IMensajeService {
    @Autowired
    private MensajeRepository mensajeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ChatRepository chatRepository;
    @Override
    public MensajeDTO enviarMensaje(MensajeDTO mensajeDTO, Integer idChat, Authentication authentication) {
        if (mensajeDTO.getId() == null) {
            Mensaje mensaje = modelMapper.map(mensajeDTO, Mensaje.class);
            Chat chat = chatRepository.findById(idChat).orElseThrow(() -> new RuntimeException("Chat no encontrado."));
            if (!chat.getEstado().equalsIgnoreCase("ABIERTO")) {
                throw new RuntimeException("No se pueden enviar mensajes de un chat que ya se encuentra finalizado.");
            }
            String tipoEmisor = authentication.getAuthorities().stream()
                    .map(a -> a.getAuthority())
                    .filter(rol -> rol.equals("ROLE_PROVEEDOR") || rol.equals("ROLE_ANFITRION"))
                    .findFirst().orElseThrow(() -> new RuntimeException("Rol no encontrado."));
            mensaje.setChat(chat);
            mensaje.setTipoemisor(tipoEmisor);
            mensaje.setFechaenvio(LocalDateTime.now());
            mensajeRepository.save(mensaje);
            chat.setFechaultimomensaje(LocalDateTime.now());
            chatRepository.save(chat);
            return modelMapper.map(mensaje, MensajeDTO.class);
        }
        return null;
    }

    @Override
    public List<MensajeDTO> listarMensajes(Integer idChat, Authentication authentication) {
        Chat chat = chatRepository.findById(idChat)
                .orElseThrow(() -> new RuntimeException("Chat no encontrado."));
        List<Mensaje> mensajes = mensajeRepository.findByChat(chat);
        if (!chat.getEstado().equalsIgnoreCase("ABIERTO")) {
            throw new RuntimeException("No se pueden visualizar los mensajes de un chat que ya se encuentra finalizado.");
        }
        String tipoEmisorActual = authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .filter(rol -> rol.equals("ROLE_PROVEEDOR") || rol.equals("ROLE_ANFITRION"))
                .findFirst().orElse(null);
        return mensajes.stream().map(m -> {MensajeDTO mensajeDTO = modelMapper.map(m, MensajeDTO.class);
            mensajeDTO.setEsPropio(m.getTipoemisor().equals(tipoEmisorActual));
        return mensajeDTO;}).toList();
    }

    @Override
    public MensajeDTO eliminarMensaje(Integer idMensaje, Authentication authentication) {
        Mensaje mensaje = mensajeRepository.findById(idMensaje)
                .orElseThrow(() -> new RuntimeException("Mensaje no encontrado."));
        Chat chat = mensaje.getChat();
        if (!chat.getEstado().equalsIgnoreCase("ABIERTO")) {
            throw new RuntimeException("No se puede eliminar mensajes de un chat finalizado.");
        }
        String tipoEmisorActual = authentication.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .filter(rol -> rol.equals("ROLE_PROVEEDOR") || rol.equals("ROLE_ANFITRION"))
                .findFirst()
                .orElse(null);
        if (!mensaje.getTipoemisor().equals(tipoEmisorActual)) {
            throw new RuntimeException("No puedes eliminar un mensaje que no te pertenece.");
        }
        mensajeRepository.delete(mensaje);
        return modelMapper.map(mensaje, MensajeDTO.class);
    }

    @Override
    public MensajeDTO editarMensaje(MensajeDTO mensajeDTO, Integer idChat, Authentication authentication) {
        if (mensajeDTO.getId() != null) {
            Mensaje mensajeExistente = mensajeRepository.findById(mensajeDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Mensaje no encontrado."));
            if (!mensajeExistente.getChat().getId().equals(idChat)) {
                throw new RuntimeException("El mensaje no pertenece a este chat.");
            }
            Chat chat = chatRepository.findById(idChat)
                    .orElseThrow(() -> new RuntimeException("Chat no encontrado."));
            if (!chat.getEstado().equalsIgnoreCase("ABIERTO")) {
                throw new RuntimeException("No se pueden editar mensajes de un chat finalizado.");
            }
            String tipoEmisor = authentication.getAuthorities().stream()
                    .map(a -> a.getAuthority())
                    .filter(rol -> rol.equals("ROLE_PROVEEDOR") || rol.equals("ROLE_ANFITRION"))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado."));
            if (!mensajeExistente.getTipoemisor().equalsIgnoreCase(tipoEmisor)) {
                throw new RuntimeException("No puedes editar mensajes enviados por otro usuario.");
            }
            mensajeExistente.setContenido(mensajeDTO.getContenido());
            mensajeExistente.setFechaenvio(LocalDateTime.now());
            chat.setFechaultimomensaje(LocalDateTime.now());
            chatRepository.save(chat);
            mensajeRepository.save(mensajeExistente);
            return modelMapper.map(mensajeExistente, MensajeDTO.class);
        }
        return null;
    }
}
