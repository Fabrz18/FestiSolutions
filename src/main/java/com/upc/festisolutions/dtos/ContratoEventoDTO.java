package com.upc.festisolutions.dtos;

import com.upc.festisolutions.entities.Anfitrion;
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
public class ContratoEventoDTO {
    private Integer id;
    private Anfitrion anfitrion;
    private Evento evento;
    private LocalDate fechacontrato;
    private LocalDate fechafinalizacion;
    private String estado;
}
