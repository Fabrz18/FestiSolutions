package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.ChatDTO;
import com.upc.festisolutions.entities.Chat;
import com.upc.festisolutions.interfaces.IChatService;
import com.upc.festisolutions.repository.ChatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService implements IChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ChatDTO> listarChats() {
        List<Chat> chats = chatRepository.findAll();
        return chats.stream().map(chat -> modelMapper.map(chat, ChatDTO.class)).toList();
    }

    @Override
    public List<ChatDTO> listarChatsSegunAnfitrion(Integer idAnfitrion) {
        List<Chat> chats = chatRepository.findAllByAnfitrion_IdAndEstado(idAnfitrion, "ABIERTO");
        return chats.stream().map(chat -> modelMapper.map(chat, ChatDTO.class)).toList();
    }

    @Override
    public List<ChatDTO> listarChatsSegunProveedor(Integer idProveedor) {
        List<Chat> chats = chatRepository.findAllByProveedor_IdAndEstado(idProveedor, "ABIERTO");
        return chats.stream().map(chat -> modelMapper.map(chat, ChatDTO.class)).toList();
    }
}
