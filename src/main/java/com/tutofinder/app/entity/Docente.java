package com.tutofinder.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "docentes")
@AllArgsConstructor
@Builder
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre del docente no puede estar vacio")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "El apellido del docente no puede estar vacio")
    @Column(nullable = false)
    private String apellido;

    @NotEmpty(message = "El DNI del docente no puede estar vacio")
    @Column(unique = true,nullable = false)
    private String dni;

    @Column(nullable = false)
    private String domicilio;

    @Email(message = "El correo no puede ser vacio")
    @Column(unique = true,nullable = false)
    private String correo;

    @Column(unique = true,nullable = false,name = "numero_cuenta")
    private String numeroCuenta;

    private Boolean membresia;

    @OneToMany(mappedBy = "docente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"docente"}, allowSetters = true)
    private List<Tutoria> tutorias;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    public Docente(){
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
        tutoria.setDocente(this);
    }
    public void removeTutoria(Tutoria tutoria) {
        this.tutorias.remove(tutoria);
        tutoria.setDocente(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Docente)) {
            return false;
        }
        Docente a = (Docente) obj;
        return this.id != null && this.id.equals(a.getId());
    }


}
