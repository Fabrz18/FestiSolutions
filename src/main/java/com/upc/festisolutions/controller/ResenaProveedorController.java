package com.upc.festisolutions.controller;
import com.upc.festisolutions.dto.ResenaEventoDTO;
import com.upc.festisolutions.dto.ResenaProveedorDTO;
import com.upc.festisolutions.interfaces.IResenaProveedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
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

    @GetMapping("/reseñaproveedores/idproveedor/{idProveedor}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<ResenaProveedorDTO> listarResenaProveedorSegunProveedor (@PathVariable Integer idProveedor){
        return iResenaProveedorService.listarResenaProveedorSegunProveedor(idProveedor);
    }
    @GetMapping("/reseñaproveedores/idanfitrion/idproveedor/{idAnfitrion}/{idProveedor}")
    @PreAuthorize("hasRole('ANFITRION')")
    List<ResenaProveedorDTO> listarResenaProveedorSegunAnfitrionYProveedor (@PathVariable Integer idAnfitrion, @PathVariable Integer idProveedor){
        return iResenaProveedorService.listarResenaProveedorSegunAnfitrionYProveedor(idAnfitrion, idProveedor);
    }
}
