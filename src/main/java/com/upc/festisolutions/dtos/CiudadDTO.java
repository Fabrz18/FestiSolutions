package com.upc.festisolutions.dtos;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ciudad")
public class CiudadDTO {
    private Integer id;
    @NotBlank(message = "El nombre de la ciudad no puede ser nulo.")
    private String nombre;
}
