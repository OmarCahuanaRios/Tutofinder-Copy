package com.tutofinder.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TutoriaDto {
    private Long id;
    private int cantidadHoras;
    private String descripcionTutoria;
    private Long cursoId;
    private List<AlumnoDto> alumno;
    private List<PagoDto> pago;
    private Long docenteId;
    private List<InformeDto> informe;
}
