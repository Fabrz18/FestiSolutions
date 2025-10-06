package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.MensajeDTO;
import com.upc.festisolutions.interfaces.IMensajeService;
import com.upc.festisolutions.interfaces.ITipoEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MensajeController {
    @Autowired
    private IMensajeService iMensajeService;
    @PostMapping("/mensaje")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public MensajeDTO registrar(@Valid @RequestBody MensajeDTO mensajeDTO) {
        return iMensajeService.registrar(mensajeDTO);
    }
    @DeleteMapping("/mensaje/{id}")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public void eliminar(@PathVariable Integer id) {
        iMensajeService.eliminar(id);
    }
    @PutMapping("/mensaje")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public MensajeDTO actualizar(@Valid @RequestBody MensajeDTO mensajeDTO) {
        return iMensajeService.actualizar(mensajeDTO);
    }
    @GetMapping("/mensajes")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public List<MensajeDTO> listar() {
        return iMensajeService.listarmensajes();
    }
    @GetMapping("/mensajes/id/{id}")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public MensajeDTO buscar(@PathVariable Integer id) {
        return iMensajeService.buscar(id);
    }
    @PostMapping("/mensaje/proveedor")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public MensajeDTO enviarMensajeProveedor(@Valid @RequestBody MensajeDTO mensajeDTO) {
        return iMensajeService.enviarMensajeProveedor(mensajeDTO);
    }
}
