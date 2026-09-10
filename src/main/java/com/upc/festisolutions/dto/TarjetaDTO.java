package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Banco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tarjeta")
public class TarjetaDTO {
    private Integer id;
    @NotBlank(message = "El número de cuenta no puede ser nulo.")
    @Min(value = 1, message = "El valor del número de cuenta no puede ser negativo.")
    private String numerocuenta;
    @NotBlank(message = "La fecha de caducidad no puede ser nulo.")
    private String fechacaducidad;
    @NotBlank(message = "El CV no puede ser nulo.")
    private String cv;
    @NotNull(message = "El campo banco no puede ser nulo.")
    private Banco banco;
    @NotNull(message = "El campo anfitrion no puede ser nulo.")
    private Anfitrion anfitrion;
}
