package com.tutofinder.app.dto.create;

import com.tutofinder.app.dto.AlumnoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateTutoriaDto {
    private int cantidadHoras;
    private String descripcionTutoria;
    private Long cursoId;
    private Long docenteId;
}
