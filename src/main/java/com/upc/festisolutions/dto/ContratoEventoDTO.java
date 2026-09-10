package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Evento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "El campo anfitrion no puede ser nulo.")
    private Anfitrion anfitrion;
    @NotNull(message = "El campo evento no puede ser nulo.")
    private Evento evento;
    private LocalDate fechacontrato;
    private LocalDate fechafinalizacion;
    private String estado;
}
