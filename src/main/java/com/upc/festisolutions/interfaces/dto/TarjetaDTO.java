package com.upc.festisolutions.interfaces.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Banco;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    private Banco banco;
    private Anfitrion anfitrion;
}
