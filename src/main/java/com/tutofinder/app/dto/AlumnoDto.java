package com.tutofinder.app.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AlumnoDto {
    private String nombre;
    private String apellido;
    private String gradoEstudio;
    private PadreDto padre;
    private String dni;
    private String correo;
    private List<TutoriaDto> tutorias;
    private Date createAt;
}
