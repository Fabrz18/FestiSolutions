package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.GananciaEventoDTO;
import com.upc.festisolutions.interfaces.IGananciaEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GananciaController {
    @Autowired
    private IGananciaEventoService igananciaEventoService;
    @PostMapping("/gananciaevento")
    @PreAuthorize("hasRole('ADMIN')")
    public GananciaEventoDTO registrarGananciaEvento(@Valid @RequestBody GananciaEventoDTO gananciaEventoDTO){
        return igananciaEventoService.registrarGananciaEvento(gananciaEventoDTO);
    }

}
