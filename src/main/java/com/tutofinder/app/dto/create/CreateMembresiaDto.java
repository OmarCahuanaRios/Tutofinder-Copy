package com.tutofinder.app.dto.create;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateMembresiaDto {
    private Long docenteId;
    private Long tarjetaId;
    private Date fechaExpiracion;
    private String descripcionMembresia;
    private double costoMembresia;
}
