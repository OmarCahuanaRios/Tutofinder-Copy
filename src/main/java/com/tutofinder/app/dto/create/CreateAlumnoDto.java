package com.tutofinder.app.dto.create;

import com.tutofinder.app.dto.PadreDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAlumnoDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String gradoEstudio;
    private PadreDto padre;
    private String dni;
    private String correo;
}
