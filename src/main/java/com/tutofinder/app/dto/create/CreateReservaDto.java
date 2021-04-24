package com.tutofinder.app.dto.create;

import com.tutofinder.app.dto.AlumnoDto;
import com.tutofinder.app.dto.TutoriaDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReservaDto {
    private Long alumnoId;
    private Long tutoriaId;
}
