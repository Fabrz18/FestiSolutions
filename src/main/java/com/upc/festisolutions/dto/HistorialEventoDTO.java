package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.entities.Tipoevento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEventoDTO {
    private Integer id;
    private String tituloEvento;
    private String tipoEvento;
    private String descripcionEvento;
    private Double presupuesto;
    private Integer aforo;
    private LocalDate fechaContrato;
    private LocalDate fechaFinalizacion;
    private Double valoracion;
    private String estado;
}
