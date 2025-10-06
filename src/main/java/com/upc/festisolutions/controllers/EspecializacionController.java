package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.EspecializacionDTO;
import com.upc.festisolutions.interfaces.IEspecializacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 @RestController
 @RequestMapping("/api")
public class EspecializacionController {
     @Autowired
     private IEspecializacionService iEspecializacionService;

     @GetMapping("/especializacion")
     @PreAuthorize("hasRole('ADMIN')")
     public List<EspecializacionDTO> listarEspecializaciones(){
         return iEspecializacionService.listarEspecializacion();
     }
     @DeleteMapping("/especializacion/{id}")
     @PreAuthorize("hasRole('ADMIN')")
     public void eliminarEspecializacion(@PathVariable Integer id){
         iEspecializacionService.eliminarEspecializacion(id);
     }
     @PutMapping("/especializacion")
     @PreAuthorize("hasRole('ADMIN')")
     public EspecializacionDTO actualizarEspecializacion(@Valid @RequestBody EspecializacionDTO especializacionDTO){
         return iEspecializacionService.actualizarEspecializacion(especializacionDTO);
     }
     @PostMapping("/especializacion")
     @PreAuthorize("hasRole('ADMIN')")
     public EspecializacionDTO registrarEspecializacion(@Valid @RequestBody EspecializacionDTO especializacionDTO){
         return iEspecializacionService.registrarEspecializacion(especializacionDTO);
     }

     @GetMapping("/especializaciones/{id}")
     @PreAuthorize("hasRole('ADMIN')")
     public EspecializacionDTO buscarEspecializacion(@PathVariable Integer id){
         return iEspecializacionService.buscarEspecializacion(id);
     }
}
