package com.upc.festisolutions.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
