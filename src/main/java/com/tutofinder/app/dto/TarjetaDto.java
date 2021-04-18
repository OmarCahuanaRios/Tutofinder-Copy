package com.tutofinder.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarjetaDto {
    private Long id;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String nombrePoseedor;
}
