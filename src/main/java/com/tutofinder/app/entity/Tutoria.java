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

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pago_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Pago pago;


    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Informe informe;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tutoria)) {
            return false;
        }
        Tutoria p = (Tutoria) obj;
        return this.id != null && this.id.equals(p.getId());
    }
}
