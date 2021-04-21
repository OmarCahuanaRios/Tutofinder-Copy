package com.tutofinder.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutoriaDto {
    private Long id;
    private int cantidadHoras;
    private String descripcionTutoria;
    private Long cursoId;
    private Long alumnoId;
    private Long pagoId;
    private Long docenteId;
    private Long informeId;
}
