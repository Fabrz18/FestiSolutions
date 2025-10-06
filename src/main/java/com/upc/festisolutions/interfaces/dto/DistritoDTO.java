package com.upc.festisolutions.interfaces.dto;

import com.upc.festisolutions.entities.Ciudad;
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
@Table(name = "distrito")
public class DistritoDTO {
    private Integer id;
    private Ciudad ciudad;
    @NotBlank(message = "El nombre del distrito no puede ser nulo.")
    private String nombre;
}
