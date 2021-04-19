package com.tutofinder.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PadreDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private byte[] foto;
    private Date createAt;
    private List<AlumnoDto> alumnos;
}
