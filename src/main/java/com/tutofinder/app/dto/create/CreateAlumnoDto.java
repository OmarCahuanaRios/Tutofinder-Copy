package com.tutofinder.app.dto.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAlumnoDto {
    private String nombre;
    private String apellido;
    private String gradoEstudio;
    private Long padreId;
    private String dni;
    private String correo;
    private byte[] foto;
}
