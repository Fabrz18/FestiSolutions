package com.upc.festisolutions.dto;

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
@Table(name = "banco")
public class BancoDTO {
    private Integer id;
    @NotBlank(message = "El nombre del banco no puede ser nulo.")
    private String nombrebanco;
}
