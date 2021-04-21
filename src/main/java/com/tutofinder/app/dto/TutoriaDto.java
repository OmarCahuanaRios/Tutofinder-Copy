package com.tutofinder.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutoriaDto {
    private Long id;
    private int cantidadHoras;
    private String descripcionTutoria;
    private CursoDto curso;
    private AlumnoDto alumno;
    private PagoDto pago;
    private DocenteDto docente;
    private InformeDto informe;
}
