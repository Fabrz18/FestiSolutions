package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.*;
import com.upc.festisolutions.interfaces.IContratoEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ContratoEventoController {
    @Autowired
    private IContratoEventoService iContratoEventoService;
    @GetMapping("/evento/anfitrion/fecha/antigua/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorFechaMasAntigua(@PathVariable Integer idAnfitrion){
        return iContratoEventoService.historialEventoSegunAnfitrionPorFechaMasAntigua(idAnfitrion);
    }
    @GetMapping("/evento/anfitrion/fecha/reciente/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorFechaMasReciente(@PathVariable Integer idAnfitrion){
        return iContratoEventoService.historialEventoSegunAnfitrionPorFechaMasReciente(idAnfitrion);
    }
    @GetMapping("/evento/anfitrion/presupuesto/mayor/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMayorPresupuesto(@PathVariable Integer idAnfitrion){
        return iContratoEventoService.historialEventoSegunAnfitrionPorMayorPresupuesto(idAnfitrion);
    }
    @GetMapping("/evento/anfitrion/presupuesto/menor/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMenorPresupuesto(@PathVariable Integer idAnfitrion){
        return iContratoEventoService.historialEventoSegunAnfitrionPorMenorPresupuesto(idAnfitrion);
    }
    @GetMapping("/evento/anfitrion/valoracion/mayor/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorMejorValoracion(@PathVariable Integer idAnfitrion) {
        return iContratoEventoService.historialEventoSegunAnfitrionPorMejorValoracion(idAnfitrion);
    }
    @GetMapping("/evento/anfitrion/valoracion/menor/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<HistorialEventoDTO> historialEventoSegunAnfitrionPorPeorValoracion(@PathVariable Integer idAnfitrion){
        return iContratoEventoService.historialEventoSegunAnfitrionPorPeorValoracion(idAnfitrion);
    }
    @GetMapping("/contrato/proveedor/fecha/reciente/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorFechaMasReciente(@PathVariable Integer idProveedor){
        return iContratoEventoService.historialContratosSegunProveedorPorFechaMasReciente(idProveedor);
    }
    @GetMapping("/contrato/proveedor/fecha/antigua/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorFechaMasAntigua(@PathVariable Integer idProveedor){
        return iContratoEventoService.historialContratosSegunProveedorPorFechaMasAntigua(idProveedor);
    }
    @GetMapping("/contrato/proveedor/presupuesto/mayor/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMayorPresupuesto(@PathVariable Integer idProveedor){
        return iContratoEventoService.historialContratosSegunProveedorPorMayorPresupuesto(idProveedor);
    }
    @GetMapping("/contrato/proveedor/presupuesto/menor/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMenorPresupuesto(@PathVariable Integer idProveedor){
        return iContratoEventoService.historialContratosSegunProveedorPorMenorPresupuesto(idProveedor);
    }
    @GetMapping("/contrato/proveedor/valoracion/mayor/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorMejorValoracion(@PathVariable Integer idProveedor){
        return iContratoEventoService.historialContratosSegunProveedorPorMejorValoracion(idProveedor);
    }
    @GetMapping("/contrato/proveedor/valoracion/menor/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<HistorialContratoDTO> historialContratosSegunProveedorPorPeorValoracion(@PathVariable Integer idProveedor){
        return iContratoEventoService.historialContratosSegunProveedorPorPeorValoracion(idProveedor);
    }
    @PostMapping("/evento/contratado")
    @PreAuthorize("hasRole('ANFITRION')")
    public ContratoEventoDTO eventoContratado(@Valid @RequestBody ContratoEventoDTO contratoEventoDTO){
        return iContratoEventoService.eventoContratado(contratoEventoDTO);
    }
    @PutMapping("/evento/finalizado")
    @PreAuthorize("hasRole('ANFITRION')")
    public ContratoEventoDTO eventoFinalizado(@Valid @RequestBody ContratoEventoDTO contratoEventoDTO){
        return iContratoEventoService.eventoFinalizado(contratoEventoDTO);
    }
    @GetMapping("/eventos/actuales/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<ContratoEventoDTO> verEventosContratados(@PathVariable Integer idAnfitrion){
        return iContratoEventoService.verEventosContratados(idAnfitrion);
    }
    @GetMapping("/contrato/actuales/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<ContratoEventoDTO> verContratosContrarados(@PathVariable Integer idProveedor){
        return  iContratoEventoService.verContratosContrarados(idProveedor);
    }
}
