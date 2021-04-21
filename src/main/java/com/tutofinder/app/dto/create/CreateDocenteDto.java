package com.tutofinder.app.dto.create;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateDocenteDto {
    private String nombre;
    private String apellido;
    private double costoHora;
    private String dni;
    private String domicilio;
    private String correo;
    private String numeroCuenta;
    private byte[] foto;
}
