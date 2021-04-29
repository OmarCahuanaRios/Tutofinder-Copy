package com.tutofinder.app.controller;

import com.tutofinder.app.dto.AlumnoDto;
import com.tutofinder.app.dto.CursoDto;
import com.tutofinder.app.dto.create.CreateAlumnoDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.AlumnoService;
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

public class AlumnoControllerTest {
    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";
    private static final String ALUMNO_DELETED = "ALUMNO_DELETED";

    private static final Long ALUMNO_ID = 1L;
    private static final String NOMBRE_ALUMNO = "Pablito";
    private static final String APELLIDO_ALUMNO = "Rodriguez";
    private static final String GRADO_ESTUDIO_ALUMNO = "Secundaria";
    private static final String DNI_ALUMNO = "12345678";
    private static final String CORREO_ALUMNO = "plabitor@gmail.com";
    private static final Long PADRE_ID_ALUMNO = 1L;
    private static final byte[] FOTO_ALUMNO = new byte[] { (byte)0xe0};

    private static final AlumnoDto ALUMNO_DTO = new AlumnoDto();
    CreateAlumnoDto CREATE_ALUMNO_DTO = new CreateAlumnoDto();
    public static final List<AlumnoDto> ALUMNO_DTO_LIST = new ArrayList<>();

    MultipartFile multipartFile = new MockMultipartFile("name",
            "originalFileName", "contentType", (byte[]) null);

    @Mock
    AlumnoService alumnoService;

    @InjectMocks
    AlumnoController alumnoController;

    @Before
    public void init() throws BookingException, IOException {
        MockitoAnnotations.initMocks(this);

        CREATE_ALUMNO_DTO.setNombre(NOMBRE_ALUMNO);
        CREATE_ALUMNO_DTO.setApellido(APELLIDO_ALUMNO);
        CREATE_ALUMNO_DTO.setDni(DNI_ALUMNO);
        CREATE_ALUMNO_DTO.setCorreo(CORREO_ALUMNO);
        CREATE_ALUMNO_DTO.setFoto(FOTO_ALUMNO);
        CREATE_ALUMNO_DTO.setGradoEstudio(GRADO_ESTUDIO_ALUMNO);
        CREATE_ALUMNO_DTO.setPadreId(PADRE_ID_ALUMNO);

        Mockito.when(alumnoService.getAlumnoById(ALUMNO_ID)).thenReturn(ALUMNO_DTO);
        Mockito.when(alumnoService.createAlumno(CREATE_ALUMNO_DTO,multipartFile)).thenReturn(ALUMNO_DTO);
        Mockito.when(alumnoService.deleteAlumno(ALUMNO_ID)).thenReturn(ALUMNO_DELETED);
    }

    @Test
    public void createAlumnoTest() throws BookingException, IOException {
        BookingResponse<AlumnoDto> response = alumnoController.createAlumno(CREATE_ALUMNO_DTO,multipartFile);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), ALUMNO_DTO);
    }

    @Test
    public void getAlumnoByIdTest() throws BookingException {
        final BookingResponse<AlumnoDto> response = alumnoController.getAlumnoById(ALUMNO_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), ALUMNO_DTO);
    }

    @Test
    public void getAlumnosTest() throws BookingException {
        final BookingResponse<List<AlumnoDto>> response = alumnoController.getAlumnos();
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), ALUMNO_DTO_LIST);
    }

    @Test
    public void deleteAlumnoTest() throws BookingException{
        final BookingResponse<String> response = alumnoController.deleteAlumno(ALUMNO_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), ALUMNO_DELETED);
    }

}
