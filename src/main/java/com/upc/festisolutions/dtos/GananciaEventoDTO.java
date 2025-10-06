package com.upc.festisolutions.dtos;

import com.upc.festisolutions.entities.Evento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GananciaEventoDTO {
    private Integer id;
    private Double ganancia;
    private LocalDate fechaobtencion;
    private Evento evento;
}
