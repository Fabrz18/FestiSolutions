package com.upc.festisolutions.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoEventoDTO {
    private Integer id;
    @NotBlank(message = "El nombre del tipo de evento no puede ser nulo.")
    private String nombre;
}
