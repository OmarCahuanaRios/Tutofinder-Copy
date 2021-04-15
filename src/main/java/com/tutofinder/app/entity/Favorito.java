package com.tutofinder.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "favoritos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "padre_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull(message = "Debe haber un padre al que asignar el docente como favorito")
    private Padre padre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull(message = "Debe haber un docente que añadir a favoritos")
    private Docente docente;
}
