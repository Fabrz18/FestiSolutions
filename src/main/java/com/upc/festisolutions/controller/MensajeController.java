package com.upc.festisolutions.controller;
import com.upc.festisolutions.dto.MensajeDTO;
import com.upc.festisolutions.interfaces.IMensajeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api")
public class MensajeController {
    @Autowired
    private IMensajeService iMensajeService;
    @PostMapping("/mensaje/{idChat}")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public MensajeDTO enviarMensaje(@Valid @RequestBody MensajeDTO mensajeDTO, @PathVariable Integer idChat, Authentication authentication){
        return iMensajeService.enviarMensaje(mensajeDTO, idChat, authentication);
    }
    @GetMapping("/mensaje/{idChat}")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public List<MensajeDTO> listarMensajes(@PathVariable Integer idChat, Authentication authentication) {
        return iMensajeService.listarMensajes(idChat, authentication);
    }
    @DeleteMapping("/mensaje/{idMensaje}")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public MensajeDTO eliminarMensaje(@PathVariable Integer idMensaje,  Authentication authentication){
        return iMensajeService.eliminarMensaje(idMensaje, authentication);
    }
    @PutMapping("/mensaje/{idChat}")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public MensajeDTO editarMensaje(@Valid @RequestBody MensajeDTO mensajeDTO, @PathVariable Integer idChat, Authentication authentication){
        return iMensajeService.editarMensaje(mensajeDTO, idChat, authentication);
    }
}
