package com.tutofinder.app.dto.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInformeDto {
    private String descripcionInforme;
    private Long tutoriaId;
    private Long alumnoId;
}
