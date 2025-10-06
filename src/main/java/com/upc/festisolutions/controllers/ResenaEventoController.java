package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.ResenaEventoDTO;
import com.upc.festisolutions.dto.TipoEventoDTO;
import com.upc.festisolutions.interfaces.IResenaEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResenaEventoController {

    @Autowired
    private IResenaEventoService iResenaEventoService;

    @PostMapping("/reseñaevento")
    @PreAuthorize("hasRole('ANFITRION')")
    public ResenaEventoDTO registrarResenaEvento(@Valid @RequestBody ResenaEventoDTO resenaEventoDTO) {
        return iResenaEventoService.registrarResenaEvento(resenaEventoDTO);
    }
    @PutMapping("/reseñaevento")
    @PreAuthorize("hasRole('ANFITRION')")
    public ResenaEventoDTO actualizarResenaEvento(@Valid @RequestBody ResenaEventoDTO resenaEventoDTO) {
        return iResenaEventoService.actualizarResenaEvento(resenaEventoDTO);
    }
    @DeleteMapping("/reseñaevento/{idResenaEvento}")
    @PreAuthorize("hasRole('ANFITRION')")
    public void eliminarResenaEvento(@PathVariable Integer idResenaEvento) {
        iResenaEventoService.eliminarResenaEvento(idResenaEvento);
    }
    @GetMapping("/reseñaeventos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ResenaEventoDTO> listarResenaEventos() {
        return iResenaEventoService.listarResenaEvento();
    }
    @GetMapping("/reseñaeventos/idevento/{idEvento}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<ResenaEventoDTO> listarResenaEventoSegunEvento(@PathVariable Integer idEvento){
        return iResenaEventoService.listarResenaEventoSegunEvento(idEvento);
    }
}

