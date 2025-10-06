package com.upc.festisolutions.interfaces.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Proveedor;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table (name = "Mensaje")
public class MensajeDTO {
    private Integer id;
    @NotBlank(message = "El contenido de un mensaje no puede ser nulo.")
    private String contenido;
    private LocalDateTime fechaenvio;
    private Anfitrion anfitrion;
    private Proveedor proveedor;
}
