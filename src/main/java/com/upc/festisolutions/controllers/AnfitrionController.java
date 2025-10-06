package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.AnfitrionDTO;
import com.upc.festisolutions.interfaces.IAnfitrionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnfitrionController {
    @Autowired
    private IAnfitrionService ianfitrionService;
    @PostMapping("/anfitrion")
    @PreAuthorize("hasRole('ANFITRION')")
    public AnfitrionDTO registrarAnfitrion(@Valid @RequestBody AnfitrionDTO anfitrionDTO){
        return ianfitrionService.registrarAnfitrion(anfitrionDTO);
    }
    @DeleteMapping("/anfitrion/{id}")
    @PreAuthorize("hasRole('ANFITRION')")
    public void eliminarAnfitrion(@PathVariable Integer id){
        ianfitrionService.eliminarAnfitrion(id);
    }
    @PutMapping("/anfitrion")
    @PreAuthorize("hasRole('ANFITRION')")
    public AnfitrionDTO actualizarAnfitrion(@Valid @RequestBody AnfitrionDTO anfitrionDTO){
        return ianfitrionService.actualizarAnfitrion(anfitrionDTO);
    }
    @GetMapping("/anfitriones")
    @PreAuthorize("hasRole('ADMIN')")
    public List<AnfitrionDTO> listarAnfitrion(){
        return ianfitrionService.listarAnfitrion();
    }
    @GetMapping("/anfitrion/id/{id}")
    @PreAuthorize("hasRole('ANFITRION')")
    public AnfitrionDTO buscarAnfitrionPorId(@PathVariable Integer id) {
        return ianfitrionService.buscarAnfitrionPorId(id);
    }
}
