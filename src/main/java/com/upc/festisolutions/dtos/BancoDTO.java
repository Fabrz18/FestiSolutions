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
@Table(name = "banco")
public class BancoDTO {
    private Integer id;
    @NotBlank(message = "El nombre del banco no puede ser nulo.")
    private String nombrebanco;
}
