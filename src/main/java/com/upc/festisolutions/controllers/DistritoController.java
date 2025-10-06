package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.DistritoDTO;
import com.upc.festisolutions.interfaces.IDistritoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DistritoController {
    @Autowired
    private IDistritoService idistritoService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("/distrito")
    @PreAuthorize("hasRole('ADMIN')")
    public DistritoDTO registrarDistrito(@Valid @RequestBody DistritoDTO distritoDTO){
        return idistritoService.registrarDistrito(distritoDTO);
    }
    @GetMapping("/distritos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<DistritoDTO> listarDistritos(){
        return idistritoService.listarDistritos();
    }
    @DeleteMapping("/distrito/{idDistrito}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarDistrito(@PathVariable Integer idDistrito){
        idistritoService.eliminarDistrito(idDistrito);
    }
    @PutMapping("/distrito")
    @PreAuthorize("hasRole('ADMIN')")
    public DistritoDTO actualizarDistrito(@Valid @RequestBody DistritoDTO distritoDTO){
        return idistritoService.actualizarDistrito(distritoDTO);
    }
}
