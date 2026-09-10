package com.upc.festisolutions.controller;
import com.upc.festisolutions.dto.CiudadDTO;
import com.upc.festisolutions.interfaces.ICiudadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api")
public class CiudadController {
    @Autowired
    private ICiudadService iciudadService;
    @PostMapping("/ciudad")
    @PreAuthorize("hasRole('ADMIN')")
    public CiudadDTO registrarCiudad(@Valid @RequestBody CiudadDTO ciudadDTO){
        return iciudadService.registrarCiudad(ciudadDTO);
    }
    @GetMapping("/ciudades")
    public List<CiudadDTO> listarCiudad(){
        return iciudadService.listarCiudad();
    }
    @DeleteMapping("/ciudad/{idCiudad}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarCiudad(@PathVariable Integer idCiudad){
        iciudadService.eliminarCiudad(idCiudad);
    }
    @PutMapping("/ciudad")
    @PreAuthorize("hasRole('ADMIN')")
    public CiudadDTO actualizarCiudad(@Valid @RequestBody CiudadDTO ciudadDTO){
        return iciudadService.actualizarCiudad(ciudadDTO);
    }
    @GetMapping("/ciudades/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CiudadDTO buscarCiudad(@PathVariable Integer id){
        return iciudadService.buscarCiudad(id);
    }
}
