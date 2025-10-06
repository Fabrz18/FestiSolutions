package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.TarjetaDTO;
import com.upc.festisolutions.interfaces.ITarjetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TarjetaController {
    @Autowired
    private ITarjetaService iTarjetaService;
    @PostMapping("/tarjeta")
    @PreAuthorize("hasRole('ADMIN')")
    public TarjetaDTO registrarTarjeta(@Valid @RequestBody TarjetaDTO tarjetaDTO){
        return iTarjetaService.registrarTarjeta(tarjetaDTO);
    }
    @PutMapping("/tarjeta")
    @PreAuthorize("hasRole('ADMIN')")
    public TarjetaDTO actualizarTarjeta(@Valid @RequestBody TarjetaDTO tarjetaDTO){
        return iTarjetaService.actualizarTarjeta(tarjetaDTO);
    }
    @DeleteMapping("/tarjeta/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarTarjeta(@PathVariable Integer id){
        iTarjetaService.eliminarTarjeta(id);
    }
    @GetMapping("/tarjetas")
    @PreAuthorize("hasRole('ADMIN')")
    public List<TarjetaDTO> listarTarjeta(){
        return iTarjetaService.listarTarjeta();
    }
}
