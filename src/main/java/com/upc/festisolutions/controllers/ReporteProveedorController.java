package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.DistritoDTO;
import com.upc.festisolutions.dto.GananciaProveedorDTO;
import com.upc.festisolutions.dto.ProveedorDTO;
import com.upc.festisolutions.dto.ReporteProveedorDTO;
import com.upc.festisolutions.interfaces.IReporteProveedorService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ReporteProveedorController {
    @Autowired
    private IReporteProveedorService ireporteProveedorService;
    @PostMapping("/reporteproveedor")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public ReporteProveedorDTO registrarReporte(@Valid @RequestBody ReporteProveedorDTO reporteProveedorDTO){
        return ireporteProveedorService.registrarReporte(reporteProveedorDTO);
    }
    @DeleteMapping("/reporteproveedor/{id}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public void eliminarReporte(@PathVariable Integer id){
        ireporteProveedorService.eliminarReporte(id);
    }
    @PutMapping("/reporteproveedor")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public ReporteProveedorDTO actualizarReporte(@Valid @RequestBody ReporteProveedorDTO reporteProveedorDTO){
        return ireporteProveedorService.actualizarReporte(reporteProveedorDTO);
    }
    @GetMapping("/reporteproveedores")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<ReporteProveedorDTO> listarReporte(){
        return ireporteProveedorService.listarReporte();
    }
    @GetMapping("/reporteproveedor/alolargodeltiempo/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<GananciaProveedorDTO> reporteUltimoAnio(@PathVariable Integer idProveedor){
        return ireporteProveedorService.reporteUltimoAnio(idProveedor);
    }
    @GetMapping("/reporteproveedor/ultimomes/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<GananciaProveedorDTO> reporteUltimoMes(@PathVariable Integer idProveedor){
        return ireporteProveedorService.reporteUltimoMes(idProveedor);
    }
    @GetMapping("/reporteproveedor/enlosultimos3meses/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<GananciaProveedorDTO> reporteUltimoTresMeses(@PathVariable Integer idProveedor){
        return ireporteProveedorService.reporteUltimoTresMeses(idProveedor);
    }
    @GetMapping("/reporteproveedor/enlosultimos6meses/{idProveedor}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public List<GananciaProveedorDTO> reporteUltimoSeisMeses(@PathVariable Integer idProveedor){
        return ireporteProveedorService.reporteUltimoSeisMeses(idProveedor);
    }
}
