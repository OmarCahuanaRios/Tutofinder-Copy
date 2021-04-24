package com.tutofinder.app.dto.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePagoDto {
    private String descripcionPago;
    private Long padreId;
    private Long tarjetaId;
    private Long tutoriaId;
    private double costoPago;
    private Long reservaId;
}
