package com.tutofinder.app.controller;

import com.tutofinder.app.dto.TarjetaDto;
import com.tutofinder.app.dto.create.CreateTarjetaDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.TarjetaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TarjetaControllerTest {

    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";

    private static final Long TARJETA_ID = 2L;
    private static final String NUMERO_TARJETA = "1234123412341234";
    private static final String FECHA_EXPIRACION = "05/22";
    private static final String NOMBRE_POSEEDOR = "Walter Molina";

    CreateTarjetaDto CREATE_TARJETA_DTO = new CreateTarjetaDto();
    private static final String TARJETA_DELETED = "TARJETA_DELETED";
    private static final TarjetaDto TARJETA_DTO = new TarjetaDto();
    public static final List<TarjetaDto> TARJETA_DTO_LIST = new ArrayList<>();

    @Mock
    TarjetaService tarjetaService;

    @InjectMocks
    TarjetaController tarjetaController;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        CREATE_TARJETA_DTO.setNumeroTarjeta(NUMERO_TARJETA);
        CREATE_TARJETA_DTO.setFechaExpiracion(FECHA_EXPIRACION);
        CREATE_TARJETA_DTO.setNombrePoseedor(NOMBRE_POSEEDOR);
        Mockito.when(tarjetaService.getTarjetaById(TARJETA_ID)).thenReturn(TARJETA_DTO);
        Mockito.when(tarjetaService.createTarjeta(CREATE_TARJETA_DTO)).thenReturn(TARJETA_DTO);
        Mockito.when(tarjetaService.deleteTarjeta(TARJETA_ID)).thenReturn(TARJETA_DELETED);
    }

    @Test
    public void createTarjetaTest() throws BookingException{
        BookingResponse<TarjetaDto> response = tarjetaController.createTarjeta(CREATE_TARJETA_DTO);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
    }

    @Test
    public void getTarjetaByIdTest() throws BookingException {
        final BookingResponse<TarjetaDto> response = tarjetaController.getTarjetaById(TARJETA_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), TARJETA_DTO);

    }

    @Test
    public void getTarjetasTest() throws BookingException {
        final BookingResponse<List<TarjetaDto>> response = tarjetaController.getTarjetas();

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), TARJETA_DTO_LIST);

    }

    @Test
    public void deleteReservationTest() throws BookingException{

        final BookingResponse<String> response = tarjetaController.deleteTarjeta(TARJETA_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), TARJETA_DELETED);

    }
}
