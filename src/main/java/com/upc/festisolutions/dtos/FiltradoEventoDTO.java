package com.upc.festisolutions.dtos;

import com.upc.festisolutions.entities.Distrito;
import com.upc.festisolutions.entities.Tipoevento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FiltradoEventoDTO {
    private Distrito distrito;
    private Tipoevento tipoevento;
    private LocalDate fechainicio;
    private LocalDate fechafin;
    private Integer aforo;
    private Double presupuesto;
}
