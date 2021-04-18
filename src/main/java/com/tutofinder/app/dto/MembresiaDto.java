package com.tutofinder.app.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MembresiaDto {
    private Long id;
    private Long docenteId;
    private Long tarjetaId;
    private Date fechaExpiracion;
    private String descripcionMembresia;
    private double costoMembresia;
}
