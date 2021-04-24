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
    private List<ReservaDto> reservas;
    private Long docenteId;
    private List<InformeDto> informes;
}
