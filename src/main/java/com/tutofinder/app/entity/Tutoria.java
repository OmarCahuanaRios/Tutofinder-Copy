package com.tutofinder.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tutofinder.app.dto.AlumnoDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.List;

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
    @Column(name = "cantidad_horas", nullable = false)
    private int cantidadHoras;

    @Column(name = "descripcion_tutoria",nullable = false)
    private String descripcionTutoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id",nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "tutoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"tutoria"}, allowSetters = true)
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "tutoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"tutoria"}, allowSetters = true)
    private List<Informe> informes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id",nullable = false)
    private Docente docente;


}
