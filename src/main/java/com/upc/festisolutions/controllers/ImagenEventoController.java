package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.ImagenEventoDTO;
import com.upc.festisolutions.interfaces.IImagenEventoService;
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
public class ImagenEventoController {
    @Autowired
    private IImagenEventoService imagenEventoService;

    @PostMapping("/imagenevento")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public ImagenEventoDTO registrar(@Valid @RequestBody ImagenEventoDTO imageneventoDTO) {
        return imagenEventoService.registrar(imageneventoDTO);
    }
    @DeleteMapping("/imagenevento/{id}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public void eliminar(@PathVariable Integer id){
        imagenEventoService.eliminar(id);
    }
    @GetMapping("/imagenesevento")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<ImagenEventoDTO> buscar(){
        return imagenEventoService.listar();
    }
    @PutMapping("/imagenevento")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public ImagenEventoDTO actualizar(@Valid @RequestBody ImagenEventoDTO imageneventoDTO){
        return  imagenEventoService.actualizar(imageneventoDTO);
    }
}
