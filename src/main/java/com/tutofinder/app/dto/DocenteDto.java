package com.tutofinder.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DocenteDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String domicilio;
    private String correo;
    private String numeroCuenta;
    private Boolean membresia;
    private Date createAt;
}
