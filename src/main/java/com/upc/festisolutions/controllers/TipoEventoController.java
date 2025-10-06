package com.upc.festisolutions.controller;


import com.upc.festisolutions.dto.TipoEventoDTO;
import com.upc.festisolutions.interfaces.ITipoEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoEventoController {
    @Autowired
    private ITipoEventoService tipoEventoService;

    @GetMapping("/tipoeventos")
    @PreAuthorize("hasRole('ADMIN')")
    public List<TipoEventoDTO> listarTipoEvento() {
        return tipoEventoService.listarTipoEvento();
    }

    @PostMapping("/tipoevento")
    @PreAuthorize("hasRole('ADMIN')")
    public TipoEventoDTO registrarTipoEvento(@Valid @RequestBody TipoEventoDTO tipoevento) {
        return tipoEventoService.registrarTipoEvento(tipoevento);
    }

    @PutMapping("/tipoevento")
    @PreAuthorize("hasRole('ADMIN')")
    public TipoEventoDTO actualizarTipoEvento(@Valid @RequestBody TipoEventoDTO tipoevento) {
        return tipoEventoService.actualizarTipoEvento(tipoevento);
    }

    @DeleteMapping("/tipoevento/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarTipoEvento(@PathVariable Integer id) {
        tipoEventoService.eliminarTipoEvento(id);
    }
}
