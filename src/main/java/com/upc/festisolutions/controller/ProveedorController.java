package com.upc.festisolutions.controller;
import com.upc.festisolutions.dto.ProveedorDTO;
import com.upc.festisolutions.interfaces.IProveedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    private IProveedorService iProveedorService;
    @PostMapping("/proveedor")
    public ProveedorDTO registrarProveedor(@Valid @RequestBody ProveedorDTO proveedorDTO){
        return iProveedorService.registrarProveedor(proveedorDTO);
    }
    @DeleteMapping("/proveedor/{id}")
    public void eliminarProveedor(@PathVariable Integer id){
        iProveedorService.eliminarProveedor(id);
    }
    @PutMapping("/proveedor")
    public ProveedorDTO actualizarProveedor(@Valid @RequestBody ProveedorDTO proveedorDTO){
        return iProveedorService.actualizarProveedor(proveedorDTO);
    }
    @GetMapping("/proveedores")
    public List<ProveedorDTO> listarProveedor(){
        return iProveedorService.listarProveedor();
    }
    @GetMapping("/proveedor/id/{id}")
    public ProveedorDTO buscarProveedorPorId(@PathVariable Integer id){
        return iProveedorService.buscarProveedorPorId(id);
    }
    @GetMapping("/proveedor/correo/{correo}")
    public ProveedorDTO buscarProveedorPorCorreo(@PathVariable String correo){
        return iProveedorService.buscarProveedorPorCorreo(correo);
    }
    @GetMapping("/proveedor/cantidad/{id}")
    public Integer calcularCantidadResenasPorProveedor(@PathVariable Integer id){
        return iProveedorService.calcularCantidadResenasPorProveedor(id);
    }
}