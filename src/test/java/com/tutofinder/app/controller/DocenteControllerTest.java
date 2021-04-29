package com.tutofinder.app.controller;
import com.tutofinder.app.dto.DocenteDto;
import com.tutofinder.app.dto.create.CreateDocenteDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.DocenteService;
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

public class DocenteControllerTest {
    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";
    private static final String DOCENTE_DELETED = "DOCENTE_DELETED";

    private static final Long DOCENTE_ID = 1L;
    private static final String NOMBRE_DOCENTE = "Pablito";
    private static final String APELLIDO_DOCENTE = "Rodriguez";
    private static final String DNI_DOCENTE = "12345678";
    private static final String CORREO_DOCENTE = "plabitor@gmail.com";
    private static final double COSTO_HORA_DOCENTE = 300.0;
    private static final String DOMICILIO_DOCENTE = "Casa de Pablito";
    private static final String NUMERO_CUENTO_DOCENTE = "1234567890";
    private static final byte[] FOTO_DOCENTE = new byte[] { (byte)0xe0};

    private static final DocenteDto DOCENTE_DTO = new DocenteDto();
    CreateDocenteDto CREATE_DOCENTE_DTO = new CreateDocenteDto();
    public static final List<DocenteDto> DOCENTE_DTO_LIST = new ArrayList<>();
    MultipartFile MULTIPARTFILE = new MockMultipartFile("name",
            "originalFileName", "contentType", (byte[]) null);

    @Mock
    DocenteService docenteService;

    @InjectMocks
    DocenteController docenteController;

    @Before
    public void init() throws BookingException, IOException {
        MockitoAnnotations.initMocks(this);

        CREATE_DOCENTE_DTO.setNombre(NOMBRE_DOCENTE);
        CREATE_DOCENTE_DTO.setApellido(APELLIDO_DOCENTE);
        CREATE_DOCENTE_DTO.setDni(DNI_DOCENTE);
        CREATE_DOCENTE_DTO.setCorreo(CORREO_DOCENTE);
        CREATE_DOCENTE_DTO.setFoto(FOTO_DOCENTE);
        CREATE_DOCENTE_DTO.setCostoHora(COSTO_HORA_DOCENTE);
        CREATE_DOCENTE_DTO.setDomicilio(DOMICILIO_DOCENTE);
        CREATE_DOCENTE_DTO.setNumeroCuenta(NUMERO_CUENTO_DOCENTE);

        Mockito.when(docenteService.getDocenteById(DOCENTE_ID)).thenReturn(DOCENTE_DTO);
        Mockito.when(docenteService.createDocente(CREATE_DOCENTE_DTO,MULTIPARTFILE)).thenReturn(DOCENTE_DTO);
        Mockito.when(docenteService.deleteDocente(DOCENTE_ID)).thenReturn(DOCENTE_DELETED);
    }

    @Test
    public void createDocenteTest() throws BookingException, IOException {
        BookingResponse<DocenteDto> response = docenteController.createDocente(CREATE_DOCENTE_DTO,MULTIPARTFILE);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), DOCENTE_DTO);
    }

    @Test
    public void getDocenteByIdTest() throws BookingException {
        final BookingResponse<DocenteDto> response = docenteController.getDocenteById(DOCENTE_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), DOCENTE_DTO);
    }

    @Test
    public void getDocentesTest() throws BookingException {
        final BookingResponse<List<DocenteDto>> response = docenteController.getDocentes();
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), DOCENTE_DTO_LIST);
    }

    @Test
    public void deleteDocenteTest() throws BookingException{
        final BookingResponse<String> response = docenteController.deleteDocente(DOCENTE_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), DOCENTE_DELETED);
    }
}
