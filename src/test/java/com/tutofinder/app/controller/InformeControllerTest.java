package com.tutofinder.app.controller;

import com.tutofinder.app.dto.InformeDto;
import com.tutofinder.app.dto.TarjetaDto;
import com.tutofinder.app.dto.create.CreateInformeDto;
import com.tutofinder.app.dto.create.CreateTarjetaDto;
import com.tutofinder.app.entity.Informe;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.InformeService;
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

public class InformeControllerTest {
    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";

    private static final Long INFORME_ID = 1L;
    private static final String DESCRIPCION_INFORME = "bueno";
    CreateInformeDto CREATE_INFORME_DTO = new CreateInformeDto();

    private static final String INFORME_DELETED = "INFORME_DELETED";
    private static final InformeDto INFORME_DTO = new InformeDto();
    public static final List<InformeDto> INFORME_DTO_LIST = new ArrayList<>();

    @Mock
    InformeService informeService;

    @InjectMocks
    InformeController informeController;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        CREATE_INFORME_DTO.setDescripcionInforme(DESCRIPCION_INFORME);
        Mockito.when(informeService.getInformeById(INFORME_ID)).thenReturn(INFORME_DTO);
        Mockito.when(informeService.createInforme(CREATE_INFORME_DTO)).thenReturn(INFORME_DTO);
        Mockito.when(informeService.deleteInforme(INFORME_ID)).thenReturn(INFORME_DELETED);
    }

    @Test
    public void createInformeTest() throws BookingException{
        BookingResponse<InformeDto> response = informeController.createInforme(CREATE_INFORME_DTO);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), INFORME_DTO);
    }

    @Test
    public void getInformeByIdTest() throws BookingException {
        final BookingResponse<InformeDto> response = informeController.getInformeById(INFORME_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), INFORME_DTO);

    }

    @Test
    public void getInformesTest() throws BookingException {
        final BookingResponse<List<InformeDto>> response = informeController.getInformes();

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), INFORME_DTO_LIST);

    }

    @Test
    public void deleteInformeTest() throws BookingException{

        final BookingResponse<String> response = informeController.deleteInforme(INFORME_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), INFORME_DELETED);

    }
}
