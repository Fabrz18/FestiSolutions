package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.ChatDTO;
import com.upc.festisolutions.entities.Chat;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IChatService {
    public List<ChatDTO> listarChats();
    public List<ChatDTO> listarChatsSegunAnfitrion(Integer idAnfitrion);
    public List<ChatDTO> listarChatsSegunProveedor(Integer idProveedor);
}
