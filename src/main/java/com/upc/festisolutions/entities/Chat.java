package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "fechacreacion", nullable = false, length = 1000)
    private LocalDateTime fechacreacion;
    @Column(name = "fechaultimomensaje", length = 1000, nullable = true)
    private LocalDateTime fechaultimomensaje;
    @NotNull
    @Column(name = "estado", length = 1000)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "idAnfitrion")
    private Anfitrion anfitrion;
    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;
    private String titulo;
}
