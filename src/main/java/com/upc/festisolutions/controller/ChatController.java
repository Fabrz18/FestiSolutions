package com.upc.festisolutions.controller;
import com.upc.festisolutions.dto.ChatDTO;
import com.upc.festisolutions.interfaces.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api")
public class ChatController {
    @Autowired
    private IChatService ichatService;
    @GetMapping("/chats")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ChatDTO> listarChats(){
        return ichatService.listarChats();
    }
    @GetMapping("/chats/anfitrion/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<ChatDTO> listarChatsSegunAnfitrion(@PathVariable Integer idAnfitrion){
        return ichatService.listarChatsSegunAnfitrion(idAnfitrion);
    }
    @GetMapping("/chats/proveedor/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<ChatDTO> listarChatsSegunProveedor(@PathVariable Integer idProveedor){
        return ichatService.listarChatsSegunProveedor(idProveedor);
    }
}
