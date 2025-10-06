package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Proveedor;
import com.upc.festisolutions.interfaces.IEventoService;
import com.upc.festisolutions.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
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
    @GetMapping("/eventosfiltrados/{idDistrito}/{idTipoevento}/{fechainicio}/{fechafin}/{aforo}/{presupuesto}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<FiltradoEventoDTO> listarEventoFiltroAvanzado(@PathVariable Integer idDistrito, @PathVariable Integer idTipoevento, @PathVariable LocalDate fechainicio, @PathVariable LocalDate fechafin, @PathVariable Integer aforo, @PathVariable Double presupuesto)
    {
        return ieventoService.listarEventoFiltroAvanzado(idDistrito, idTipoevento, fechainicio, fechafin, aforo, presupuesto);
    }
    @GetMapping("/eventosfiltrado/{idDistrito}/{aforo}/{fechainicio}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<EventoDTO> listarEventoFiltroBasico(@PathVariable Integer idDistrito, @PathVariable Integer aforo, @PathVariable LocalDate fechainicio){
        return ieventoService.listarEventoFiltroBasico(idDistrito, aforo, fechainicio);
    }

    @GetMapping("/evento/{idevento}")
    @PreAuthorize("hasRole('ANFITRION')")
    public EventoDTO buscarEventoPorId(@PathVariable Integer idevento){
        return ieventoService.buscarEventoPorId(idevento);
    }
    @GetMapping("/eventos/aleatorios")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<EventoDTO> listarEventosAleatorios(){
        return ieventoService.listarEventosAleatorios();
    }
}
