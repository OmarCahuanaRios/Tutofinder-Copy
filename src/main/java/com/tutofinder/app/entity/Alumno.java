package com.tutofinder.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "alumnos")
@AllArgsConstructor
@Builder
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre del alumno no debe estar vacio")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "El apellido del alumno no debe estar vacio")
    @Column(nullable = false)
    private String apellido;

    @NotEmpty(message = "El grado de estudio del alumno no debe estar vacio")
    @Column(name = "grado_estudio",nullable = false)
    private String gradoEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value= {"handler", "hibernateLazyInitializer"})
    @JoinColumn(name = "padre_id")
    @NotNull(message = "Debe de haber un padre")
    private Padre padre;

    @NotEmpty(message = "El dni no debe estar vacio")
    @Column(unique = true,nullable = false,length = 8)
    private String dni;

    @NotEmpty(message = "El correo no debe estar vacio")
    @Email(message = "Debe tener @")
    @Column(unique = true,nullable = false)
    private String correo;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"alumno"}, allowSetters = true)
    private List<Tutoria> tutorias;


    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    public Alumno(){
        this.tutorias =  new ArrayList<>();
    }

    @PrePersist
    public void PrePersist() {
        this.createAt = new Date();
    }

    public void setTutorias(List<Tutoria> tutorias) {
        this.tutorias.clear();
        tutorias.forEach(this::addTutoria);
    }

    public void addTutoria(Tutoria tutoria) {
        this.tutorias.add(tutoria);
        tutoria.setAlumno(this);
    }
    public void removeTutoria(Tutoria tutoria) {
        this.tutorias.remove(tutoria);
        tutoria.setAlumno(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Alumno)) {
            return false;
        }
        Alumno p = (Alumno) obj;
        return this.id != null && this.id.equals(p.getId());
    }
}
