package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idevento", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Size(max = 300)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idtipo", nullable = false)
    private Tipoevento tipoevento;

    @NotNull
    @Column(name = "fechainicio", nullable = false)
    private LocalDate fechainicio;

    @NotNull
    @Column(name = "fechafin", nullable = false)
    private LocalDate fechafin;

    @NotNull
    @Column(name = "presupuesto", nullable = false)
    private Double presupuesto;

    @NotNull
    @Column(name = "valoracion")
    private Double valoracion;

    @Column(name = "estado")
    private String estado;

    @NotNull
    @Column(name = "aforo", nullable = false)
    private Integer aforo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private Distrito distrito;
}