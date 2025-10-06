package com.upc.festisolutions.interfaces.dto;


import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table (name = "Especializacion")
public class EspecializacionDTO {
    private Integer id;
    @NotBlank(message = "El nombre de la especialización no puede ser nulo.")
    private String nombre;
}
