package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.ProveedorDTO;
import com.upc.festisolutions.interfaces.IProveedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    private IProveedorService iProveedorService;
    @PostMapping("/proveedor")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public ProveedorDTO registrarProveedor(@Valid @RequestBody ProveedorDTO proveedorDTO){
        return iProveedorService.registrarProveedor(proveedorDTO);
    }
    @DeleteMapping("/proveedor/{id}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public void eliminarProveedor(@PathVariable Integer id){
        iProveedorService.eliminarProveedor(id);
    }
    @PutMapping("/proveedor")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public ProveedorDTO actualizarProveedor(@Valid @RequestBody ProveedorDTO proveedorDTO){
        return iProveedorService.actualizarProveedor(proveedorDTO);
    }
    @GetMapping("/proveedores")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ProveedorDTO> listarProveedor(){
        return iProveedorService.listarProveedor();
    }
    @GetMapping("/proveedor/id/{id}")
    @PreAuthorize("hasRole('PROVEEDOR')")
    public ProveedorDTO buscarProveedorPorId(@PathVariable Integer id){
        return iProveedorService.buscarProveedorPorId(id);
    }
}