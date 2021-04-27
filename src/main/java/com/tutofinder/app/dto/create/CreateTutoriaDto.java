package com.tutofinder.app.dto.create;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateTutoriaDto {
    private int cantidadHoras;
    private String descripcionTutoria;
    private Long cursoId;
    private Long docenteId;
}
