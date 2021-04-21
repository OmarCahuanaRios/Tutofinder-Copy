package com.tutofinder.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="informes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Informe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "informe_id")
    private Long id;

    @Column(name = "descripcion_informe",nullable = false)
    private String descripcionInforme;

}
