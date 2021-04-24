package com.tutofinder.app.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagoDto {
    private Long id;
    private String descripcionPago;
    private Long padreId;
    private Long tarjetaId;
    private Long tutoriaId;
    private double costoPago;
    private ReservaDto reserva;
}
