package com.upc.festisolutions.dtos;

import com.upc.festisolutions.entities.Gananciaevento;
import com.upc.festisolutions.entities.Proveedor;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReporteProveedorDTO {
    private Integer id;
    private Proveedor proveedor;
    @NotBlank(message = "La descripción del reporte del proveedor no puede ser nulo.")
    private String descripcion;
    private Gananciaevento gananciaevento;
}
