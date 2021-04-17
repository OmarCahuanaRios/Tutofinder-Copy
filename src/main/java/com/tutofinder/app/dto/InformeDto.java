package com.tutofinder.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class InformeDto {

    private Long id;

    @Column(name = "descripcion_informe")
    private String descripcionInforme;
}
