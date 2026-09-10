package com.upc.festisolutions.controller;
import com.upc.festisolutions.dto.AnfitrionDTO;
import com.upc.festisolutions.dto.ValoracionEventoDTO;
import com.upc.festisolutions.interfaces.IValoracionEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization")
@RequestMapping("/api")
public class ValoracionEventoController {
    @Autowired
    private IValoracionEventoService ivaloracionEventoService;
    @PostMapping("/alternarfavorito/{idAnfitrion}/{idEvento}")
    @PreAuthorize("hasRole('ANFITRION')")
    public ValoracionEventoDTO alternarFavorito(@PathVariable Integer idAnfitrion, @PathVariable Integer idEvento){
        return ivaloracionEventoService.alternarFavorito(idAnfitrion, idEvento);
    }
    @GetMapping("/valoracioneventos/{idAnfitrion}")
    @PreAuthorize("hasRole('ANFITRION')")
    public List<ValoracionEventoDTO> listarValoracionEventoPorAnfitrion(@PathVariable Integer idAnfitrion){
        return ivaloracionEventoService.listarValoracionEventoPorAnfitrion(idAnfitrion);
    }
    @PostMapping("/alternarfavorito/contrato/{idAnfitrion}/{idContratoEvento}")
    @PreAuthorize("hasRole('ANFITRION')")
    public ValoracionEventoDTO alternarFavoritoContrato(@PathVariable Integer idAnfitrion, @PathVariable Integer idContratoEvento){
        return ivaloracionEventoService.alternarFavoritoContrato(idAnfitrion, idContratoEvento);
    }
}
