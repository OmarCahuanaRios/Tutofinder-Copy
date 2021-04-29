package com.tutofinder.app.controller;

import com.tutofinder.app.dto.AlumnoDto;
import com.tutofinder.app.dto.PagoDto;
import com.tutofinder.app.dto.create.CreatePagoDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.PagoService;
import io.cucumber.java.sl.In;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PagoControllerTest {
    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";
    private static final String PAGO_DELETED = "PAGO_DELETED";

    private static final Long PAGO_ID = 1L;
    private static final String DESCRIPCION_PAGO = "Descripcion base";
    private static final Long PADRE_ID_PAGO = 1L;
    private static final Long TARJETA_ID_PAGO = 1L;
    private static final Long TUTORIA_ID_PAGO = 1L;
    private static final Long RESERVA_ID_PAGO = 1L;
    private static final double COSTO_PAGO = 300.0;
    private static final PagoDto PAGO_DTO = new PagoDto();

    CreatePagoDto CREATE_PAGO_DTO = new CreatePagoDto();
    public static final List<PagoDto> PAGO_DTO_LIST = new ArrayList<>();

    @Mock
    PagoService pagoService;

    @InjectMocks
    PagoController pagoController;

    @Before
    public void init() throws BookingException, IOException {
        MockitoAnnotations.initMocks(this);
        CREATE_PAGO_DTO.setDescripcionPago(DESCRIPCION_PAGO);
        CREATE_PAGO_DTO.setPadreId(PADRE_ID_PAGO);
        CREATE_PAGO_DTO.setTarjetaId(TARJETA_ID_PAGO);
        CREATE_PAGO_DTO.setTutoriaId(TUTORIA_ID_PAGO);
        CREATE_PAGO_DTO.setReservaId(RESERVA_ID_PAGO);
        CREATE_PAGO_DTO.setCostoPago(COSTO_PAGO);

        Mockito.when(pagoService.getPagoById(PAGO_ID)).thenReturn(PAGO_DTO);
        Mockito.when(pagoService.createPago(CREATE_PAGO_DTO)).thenReturn(PAGO_DTO);
        Mockito.when(pagoService.deletePago(PAGO_ID)).thenReturn(PAGO_DELETED);
    }

    @Test
    public void createPagoTest() throws BookingException {
        BookingResponse<PagoDto> response = pagoController.createPago(CREATE_PAGO_DTO);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), PAGO_DTO);
    }

    @Test
    public void getPagoByIdTest() throws BookingException {
        final BookingResponse<PagoDto> response = pagoController.getPagoById(PAGO_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), PAGO_DTO);
    }

    @Test
    public void getPagosTest() throws BookingException {
        final BookingResponse<List<PagoDto>> response = pagoController.getPagos();
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), PAGO_DTO_LIST);
    }

    @Test
    public void deletePagoTest() throws BookingException{
        final BookingResponse<String> response = pagoController.deletePago(PAGO_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), PAGO_DELETED);
    }

}
