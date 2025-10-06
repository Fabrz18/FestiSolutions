package com.upc.festisolutions.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GananciaProveedorDTO {
    private Integer anio;
    private Integer mes;
    private Double ganancia;
}
