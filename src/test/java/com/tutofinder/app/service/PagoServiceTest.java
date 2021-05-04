package com.tutofinder.app.service;

import com.tutofinder.app.dto.create.CreatePagoDto;
import com.tutofinder.app.entity.Padre;
import com.tutofinder.app.entity.Pago;
import com.tutofinder.app.entity.Reserva;
import com.tutofinder.app.entity.Tarjeta;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.repository.PadreRepository;
import com.tutofinder.app.repository.PagoRepository;
import com.tutofinder.app.repository.ReservaRepository;
import com.tutofinder.app.repository.TarjetaRepository;
import com.tutofinder.app.services.impl.PagoServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PagoServiceTest {
    private static Long PAGO_ID = 1L;
    private static Long PADRE_ID = 1L;
    private static Long RESERVA_ID = 1L;
    private static Long TARJETA_ID = 1L;
    private static String DESCRIPCION_PAGO = "descripcion";
    private static double COSTO_PAGO = 6.9d;

    private static CreatePagoDto CREATE_PAGO_DTO = new CreatePagoDto();
    private static Pago PAGO = new Pago();
    private static Padre PADRE = new Padre();
    private static Reserva RESERVA = new Reserva();
    private static Tarjeta TARJETA = new Tarjeta();

    @InjectMocks
    PagoServiceImpl pagoServiceImpl;

    @Mock
    PagoRepository pagoRepository;

    @Mock
    TarjetaRepository tarjetaRepository;

    @Mock
    PadreRepository padreRepository;

    @Mock
    ReservaRepository reservaRepository;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        CREATE_PAGO_DTO.setDescripcionPago(DESCRIPCION_PAGO);
        CREATE_PAGO_DTO.setCostoPago(COSTO_PAGO);
        CREATE_PAGO_DTO.setPadreId(PADRE_ID);
        CREATE_PAGO_DTO.setTarjetaId(TARJETA_ID);
        CREATE_PAGO_DTO.setReservaId(RESERVA_ID);

        PAGO.setId(PAGO_ID);
        PAGO.setDescripcionPago(DESCRIPCION_PAGO);
        PAGO.setCostoPago(COSTO_PAGO);
        PAGO.setPadre(PADRE);
        PAGO.setReserva(RESERVA);
        PAGO.setTarjeta(TARJETA);
    }

    @Test
    public void getPagoByIdTest() throws BookingException {

    }

    public void getPagosTest() throws BookingException {

    }

    public void createPagoTest() throws BookingException {

    }

    public void updatePagoTest() throws BookingException {

    }

    public void deletePagoTest() throws BookingException {

    }
}
