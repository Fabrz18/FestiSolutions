package com.upc.festisolutions.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistorialContratoDTO {
    private Integer id;
    private String tituloEvento;
    private String tipoEvento;
    private String descripcionEvento;
    private Double presupuesto;
    private Integer aforo;
    private LocalDate fechaContrato;
    private LocalDate fechaFinalizacion;
    private String nombreAnfitrion;
    private Double valoracion;
    private String estado;
}
