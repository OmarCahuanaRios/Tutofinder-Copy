package com.tutofinder.app.dto.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTarjetaDto {
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String nombrePoseedor;
}
