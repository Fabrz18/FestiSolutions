package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.AnfitrionDTO;
import com.upc.festisolutions.dto.ValoracionEventoDTO;
import com.upc.festisolutions.interfaces.IValoracionEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ValoracionEventoController {
    @Autowired
    private IValoracionEventoService ivaloracionEventoService;
    @PostMapping("/valoracionevento")
    @PreAuthorize("hasRole('ANFITRION')")
    public ValoracionEventoDTO agregarValoracionEvento(@Valid @RequestBody ValoracionEventoDTO valoracioneventoDTO){
        return ivaloracionEventoService.agregarValoracionEvento(valoracioneventoDTO);
    }
    @DeleteMapping("/valoracionevento/{id}")
    @PreAuthorize("hasRole('ANFITRION')")
    public void eliminarValoracionEvento(@PathVariable Integer id){
        ivaloracionEventoService.eliminarValoracionEvento(id);
    }
    @PutMapping("/valoracionevento")
    @PreAuthorize("hasRole('ANFITRION')")
    public ValoracionEventoDTO actualizarValoracionEvento(@Valid @RequestBody ValoracionEventoDTO valoracioneventoDTO){
        return ivaloracionEventoService.actualizarValoracionEvento(valoracioneventoDTO);
    }
    @GetMapping("/valoracioneventos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ValoracionEventoDTO> listarValoracionEvento(){
        return ivaloracionEventoService.listarValoracionEvento();
    }

}
