package com.tutofinder.app.dto.create;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CreateInformeDto {
    @Column(name = "descripcion_informe")
    private String descripcionInforme;
}
