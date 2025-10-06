package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.ReporteProveedorDTO;
import com.upc.festisolutions.dto.ResenaProveedorDTO;
import com.upc.festisolutions.interfaces.IResenaProveedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ResenaProveedorController {
    @Autowired
    private IResenaProveedorService iResenaProveedorService;

    @PostMapping("/reseñaproveedor")
    @PreAuthorize("hasRole('ANFITRION')")
    public ResenaProveedorDTO registrarResenaProveedor(@Valid @RequestBody ResenaProveedorDTO resenaProveedorDTO) {
        return iResenaProveedorService.registrarResenaProveedor(resenaProveedorDTO);
    }

    @PutMapping("/reseñaproveedor")
    @PreAuthorize("hasRole('ANFITRION')")
    public ResenaProveedorDTO actualizarResenaProveedor(@Valid @RequestBody ResenaProveedorDTO resenaProveedorDTO) {
        return iResenaProveedorService.actualizarResenaProveedor(resenaProveedorDTO);
    }

    @DeleteMapping("/reseñaproveedor/{id}")
    @PreAuthorize("hasRole('ANFITRION')")
    public void eliminarResenaProveedor(@PathVariable Integer id) {
        iResenaProveedorService.eliminarResenaProveedor(id);
    }

    @GetMapping("/reseñaproveedores")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<ResenaProveedorDTO> listarResenasProveedor() {
        return iResenaProveedorService.listarResenaProveedor();
    }

}
