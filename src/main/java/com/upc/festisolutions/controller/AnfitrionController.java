package com.upc.festisolutions.controller;
import com.upc.festisolutions.dto.AnfitrionDTO;
import com.upc.festisolutions.interfaces.IAnfitrionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api")
public class AnfitrionController {
    @Autowired
    private IAnfitrionService ianfitrionService;
    @PostMapping("/anfitrion")
    public AnfitrionDTO registrarAnfitrion(@Valid @RequestBody AnfitrionDTO anfitrionDTO){
        return ianfitrionService.registrarAnfitrion(anfitrionDTO);
    }
    @DeleteMapping("/anfitrion/{id}")
    public void eliminarAnfitrion(@PathVariable Integer id){
        ianfitrionService.eliminarAnfitrion(id);
    }
    @PutMapping("/anfitrion")
    public AnfitrionDTO actualizarAnfitrion(@Valid @RequestBody AnfitrionDTO anfitrionDTO){
        return ianfitrionService.actualizarAnfitrion(anfitrionDTO);
    }
    @GetMapping("/anfitriones")
    public List<AnfitrionDTO> listarAnfitrion(){
        return ianfitrionService.listarAnfitrion();
    }
    @GetMapping("/anfitrion/id/{id}")
    public AnfitrionDTO buscarAnfitrionPorId(@PathVariable Integer id) {
        return ianfitrionService.buscarAnfitrionPorId(id);
    }
    @GetMapping("/anfitrion/correo/{correo}")
    public AnfitrionDTO buscarAnfitrionPorCorreo(@PathVariable String correo){
        return ianfitrionService.buscarAnfitrionPorCorreo(correo);
    }
}
