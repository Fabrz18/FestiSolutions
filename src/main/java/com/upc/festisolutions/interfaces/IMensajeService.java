package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.MensajeDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IMensajeService {
    public MensajeDTO enviarMensaje(MensajeDTO mensajeDTO, Integer idChat, Authentication authentication);
    public List<MensajeDTO> listarMensajes(Integer idChat, Authentication authentication);
    public MensajeDTO eliminarMensaje(Integer idMensaje,  Authentication authentication);
    public MensajeDTO editarMensaje(MensajeDTO mensajeDTO, Integer idChat, Authentication authentication);
}
