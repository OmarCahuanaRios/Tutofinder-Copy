package com.tutofinder.app.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MembresiaDto {
    private Long id;
    private DocenteDto docente;
    private TarjetaDto tarjeta;
    private Date fechaExpiracion;
    private String descripcionMembresia;
    private double costoMembresia;
}
