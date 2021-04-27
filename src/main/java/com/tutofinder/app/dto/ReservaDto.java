package com.tutofinder.app.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservaDto {
    private Long id;
    private Long alumnoId;
    private Long tutoriaId;
    private Date createAt;
}
