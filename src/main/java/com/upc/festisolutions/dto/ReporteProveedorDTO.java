package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Gananciaevento;
import com.upc.festisolutions.entities.Proveedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReporteProveedorDTO {
    private Integer id;
    @NotNull(message = "El campo proveedor no puede ser nulo.")
    private Proveedor proveedor;
    @NotBlank(message = "La descripción del reporte del proveedor no puede ser nulo.")
    private String descripcion;
    @NotNull(message = "El campo gananciaevento no puede ser nulo.")
    private Gananciaevento gananciaevento;
}
