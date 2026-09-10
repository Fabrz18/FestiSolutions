package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Proveedor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatDTO {
    private Integer id;
    private LocalDateTime fechacreacion;
    private LocalDateTime fechaultimomensaje;
    private String estado;
    private Anfitrion anfitrion;
    private Proveedor proveedor;
    private String titulo;
}
