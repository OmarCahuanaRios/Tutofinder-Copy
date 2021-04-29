package com.tutofinder.app.controller;

import com.tutofinder.app.dto.MembresiaDto;
import com.tutofinder.app.dto.create.CreateMembresiaDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.MembresiaService;
import io.cucumber.java.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MembresiaControllerTest {
    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";
    private static final String MEMBRESIA_DELETED = "MEMBRESIA_DELETED";

    private static final Long MEMBRESIA_ID = 1L;
    private static final Long DOCENTE_ID_MEMBRESIA = 1L;
    private static final Long TARJETA_ID_MEMBRESIA = 1L;
    private static final Date FECHA_EXPIRACION_MEMBRESIA = new Date(2022,02,01);

    private static final String DESCRIPCION_MEMBRESIA = "Descripcion base";
    private static final double COSTO_MEMBRESIA = 300.0;
    CreateMembresiaDto CREATE_MEMBRESIA_DTO = new CreateMembresiaDto();
    private static final MembresiaDto MEMBRESIA_DTO = new MembresiaDto();
    public static final List<MembresiaDto> MEMBRESIA_DTO_LIST = new ArrayList<>();

    @Mock
    MembresiaService membresiaService;

    @InjectMocks
    MembresiaController membresiaController;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
        CREATE_MEMBRESIA_DTO.setDocenteId(DOCENTE_ID_MEMBRESIA);
        CREATE_MEMBRESIA_DTO.setTarjetaId(TARJETA_ID_MEMBRESIA);
        CREATE_MEMBRESIA_DTO.setFechaExpiracion(FECHA_EXPIRACION_MEMBRESIA);
        CREATE_MEMBRESIA_DTO.setDescripcionMembresia(DESCRIPCION_MEMBRESIA);
        CREATE_MEMBRESIA_DTO.setCostoMembresia(COSTO_MEMBRESIA);
        Mockito.when(membresiaService.getMembresiaById(MEMBRESIA_ID)).thenReturn(MEMBRESIA_DTO);
        Mockito.when(membresiaService.createMembresia(CREATE_MEMBRESIA_DTO)).thenReturn(MEMBRESIA_DTO);
        Mockito.when(membresiaService.deleteMembresia(MEMBRESIA_ID)).thenReturn(MEMBRESIA_DELETED);
    }

    @Test
    public void createMembresiaTest() throws BookingException{
        BookingResponse<MembresiaDto> response = membresiaController.createMembresia(CREATE_MEMBRESIA_DTO);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), MEMBRESIA_DTO);

    }

    @Test
    public void getMembresiaByIdTest() throws BookingException {
        final BookingResponse<MembresiaDto> response = membresiaController.getMembresiaById(MEMBRESIA_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), MEMBRESIA_DTO);

    }

    @Test
    public void getMembresiasTest() throws BookingException {
        final BookingResponse<List<MembresiaDto>> response = membresiaController.getMembresias();
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), MEMBRESIA_DTO_LIST);

    }

    @Test
    public void deleteMembresiaTest() throws BookingException{
        final BookingResponse<String> response = membresiaController.deleteMembresia(MEMBRESIA_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), MEMBRESIA_DELETED);

    }
}
