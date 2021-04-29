package com.tutofinder.app.controller;

import com.tutofinder.app.dto.PadreDto;
import com.tutofinder.app.dto.create.CreatePadreDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.PadreService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PadreControllerTest {
    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";
    private static final String PADRE_DELETED = "PADRE_DELETED";

    private static final Long PADRE_ID = 1L;
    private static final String NOMBRE_PADRE = "Roberto";
    private static final String APELLIDO_PADRE = "Casas";
    private static final String DNI_PADRE = "12345678";
    private static final String CORREO_PADRE = "robertoc@gmail.com";
    private static final byte[] FOTO_PADRE = new byte[] { (byte)0xe0};

    private static final PadreDto PADRE_DTO = new PadreDto();
    CreatePadreDto CREATE_PADRE_DTO = new CreatePadreDto();
    public static final List<PadreDto> PADRE_DTO_LIST = new ArrayList<>();

    MultipartFile MULTIPARTFILE = new MockMultipartFile("name",
            "originalFileName", "contentType", (byte[]) null);

    @Mock
    PadreService padreService;

    @InjectMocks
    PadreController padreController;

    @Before
    public void init() throws BookingException, IOException {
        MockitoAnnotations.initMocks(this);
        CREATE_PADRE_DTO.setNombre(NOMBRE_PADRE);
        CREATE_PADRE_DTO.setApellido(APELLIDO_PADRE);
        CREATE_PADRE_DTO.setDni(DNI_PADRE);
        CREATE_PADRE_DTO.setCorreo(CORREO_PADRE);
        CREATE_PADRE_DTO.setFoto(FOTO_PADRE);

        Mockito.when(padreService.getPadreById(PADRE_ID)).thenReturn(PADRE_DTO);
        Mockito.when(padreService.createPadre(CREATE_PADRE_DTO,MULTIPARTFILE)).thenReturn(PADRE_DTO);
        Mockito.when(padreService.deletePadre(PADRE_ID)).thenReturn(PADRE_DELETED);
    }

    @Test
    public void createPadreTest() throws BookingException, IOException {
        BookingResponse<PadreDto> response = padreController.createPadre(CREATE_PADRE_DTO,MULTIPARTFILE);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), PADRE_DTO);
    }

    @Test
    public void getPadreByIdTest() throws BookingException {
        final BookingResponse<PadreDto> response = padreController.getPadreById(PADRE_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), PADRE_DTO);
    }

    @Test
    public void getPadresTest() throws BookingException {
        final BookingResponse<List<PadreDto>> response = padreController.getPadres();
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), PADRE_DTO_LIST);
    }

    @Test
    public void deletePadreTest() throws BookingException{
        final BookingResponse<String> response = padreController.deletePadre(PADRE_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), PADRE_DELETED);
    }
}
