package com.tutofinder.app.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InformeDto {
    private Long id;
    private String descripcionInforme;
    private TutoriaDto tutoria;
    private AlumnoDto alumnoDto;
}
