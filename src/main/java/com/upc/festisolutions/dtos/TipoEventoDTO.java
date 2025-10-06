package com.upc.festisolutions.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoEventoDTO {
    private Integer id;
    @NotBlank(message = "El nombre del tipo de evento no puede ser nulo.")
    private String nombre;
}
