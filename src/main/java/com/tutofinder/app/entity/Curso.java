package com.tutofinder.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="cursos")
@AllArgsConstructor
@Builder
public class Curso {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @JsonIgnoreProperties(value= {"hijos", "handler", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso padre;

    @JsonIgnoreProperties(value = {"padre", "handler", "hibernateLazyInitializer"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "padre",cascade = CascadeType.ALL)
    private List<Curso> hijos;

    public Curso (){
        this.hijos = new ArrayList<>();
    }

    public void setHijos(List<Curso> hijos) {
        this.hijos.clear();
        hijos.forEach(this::addCurso);
    }

    public void addCurso(Curso hijo) {
        this.hijos.add(hijo);
        hijo.setPadre(this);
    }
    public void removeCurso(Curso hijo) {
        this.hijos.remove(hijo);
        hijo.setPadre(null);
    }
}