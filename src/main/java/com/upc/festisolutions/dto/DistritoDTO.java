package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Ciudad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "distrito")
public class DistritoDTO {
    private Integer id;
    @NotNull(message = "El campo ciudad no puede ser nulo.")
    private Ciudad ciudad;
    @NotBlank(message = "El nombre del distrito no puede ser nulo.")
    private String nombre;
}
