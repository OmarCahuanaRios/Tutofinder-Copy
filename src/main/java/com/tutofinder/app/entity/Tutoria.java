package com.tutofinder.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Data
@Table(name="tutorias")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tutoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "La cantidad de minutos debe ser mayor que cero")
    @Column(name = "cantidad_minutos", nullable = false)
    private int cantidadMinutos;

    @Column(name = "descripcion_tutoria")
    private String descripcionTutoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id",nullable = false)
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id",nullable = false)
    private Alumno alumno;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pago_id",nullable = false)
    private Pago pago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id",nullable = false)
    private Docente docente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id")
    private Informe informe;

}
