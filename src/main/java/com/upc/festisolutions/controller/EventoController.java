package com.upc.festisolutions.controller;
import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.interfaces.IEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api")
public class EventoController {
    @Autowired
    private IEventoService ieventoService;
    @PostMapping("/evento")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public EventoDTO registrarEvento(@Valid @RequestBody EventoDTO eventoDTO){
        return ieventoService.registrarEvento(eventoDTO);
    }
    @DeleteMapping("/evento/{id}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public void eliminarEvento(@PathVariable Integer id){
        ieventoService.eliminarEvento(id);
    }
    @PutMapping("/evento")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public EventoDTO actualizarEvento(@Valid @RequestBody EventoDTO eventoDTO){
        return ieventoService.actualizarEvento(eventoDTO);
    }
    @GetMapping("/eventos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<EventoDTO> listarEvento(){
        return ieventoService.listarEvento();
    }
    @GetMapping("/eventosfiltrados/{idDistrito}/{idTipoevento}/{fechainicio}/{fechafin}/{aforoMin}/{aforoMax}/{presupuestoMin}/{presupuestoMax}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<EventoDTO> listarEventoFiltroAvanzado(@PathVariable Integer idDistrito, @PathVariable Integer idTipoevento, @PathVariable LocalDate fechainicio, @PathVariable LocalDate fechafin, @PathVariable Integer aforoMin, @PathVariable Integer aforoMax, @PathVariable Double presupuestoMin, @PathVariable Double presupuestoMax)
    {
        return ieventoService.listarEventoFiltroAvanzado(idDistrito, idTipoevento, fechainicio, fechafin, aforoMin, aforoMax, presupuestoMin, presupuestoMax);
    }
    @GetMapping("/eventosfiltrado/{idDistrito}/{aforo}/{fechainicio}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<EventoDTO> listarEventoFiltroBasico(@PathVariable Integer idDistrito, @PathVariable Integer aforo, @PathVariable LocalDate fechainicio){
        return ieventoService.listarEventoFiltroBasico(idDistrito, aforo, fechainicio);
    }
    @GetMapping("/evento/{idevento}")
    @PreAuthorize("hasAnyRole('PROVEEDOR', 'ANFITRION')")
    public EventoDTO buscarEventoPorId(@PathVariable Integer idevento){
        return ieventoService.buscarEventoPorId(idevento);
    }
    @GetMapping("/eventos/aleatorios")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<EventoDTO> listarEventosAleatorios(){
        return ieventoService.listarEventosAleatorios();
    }
    @GetMapping("/evento/proveedor/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<EventoDTO> listarEventosPorProveedor(@PathVariable Integer idProveedor){
        return ieventoService.listarEventoPorProveedor(idProveedor);
    }
    @GetMapping("/evento/cantidad/{id}")
    public Integer calcularCantidadResenasPorEvento(@PathVariable Integer id){
        return ieventoService.calcularCantidadResenasPorEvento(id);
    }
}
