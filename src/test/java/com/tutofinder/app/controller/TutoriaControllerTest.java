package com.tutofinder.app.controller;

import com.tutofinder.app.dto.TutoriaDto;
import com.tutofinder.app.dto.create.CreateTutoriaDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.TutoriaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TutoriaControllerTest {
    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";

    private static final Long TUTORIA_ID = 1L;
    private static final int CANTIDAD_HORAS_TUTORIA = 2;
    private static final String DESCRIPCION_TUTORIA = "Descripcion base";
    private static final Long CURSO_ID_TUTORIA = 1L;
    private static final Long DOCENTE_ID_TUTORIA = 1L;

    CreateTutoriaDto CREATE_TUTORIA_DTO = new CreateTutoriaDto();
    private static final String TUTORIA_DELETED = "TUTORIA_DELETED";
    private static final TutoriaDto TUTORIA_DTO = new TutoriaDto();
    public static final List<TutoriaDto> TUTORIA_DTO_LIST = new ArrayList<>();

    @Mock
    TutoriaService tutoriaService;

    @InjectMocks
    TutoriaController tutoriaController;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
        CREATE_TUTORIA_DTO.setDescripcionTutoria(DESCRIPCION_TUTORIA);
        CREATE_TUTORIA_DTO.setCantidadHoras(CANTIDAD_HORAS_TUTORIA);
        CREATE_TUTORIA_DTO.setDocenteId(DOCENTE_ID_TUTORIA);
        CREATE_TUTORIA_DTO.setCursoId(CURSO_ID_TUTORIA);

        Mockito.when(tutoriaService.getTutoriaById(TUTORIA_ID)).thenReturn(TUTORIA_DTO);
        Mockito.when(tutoriaService.createTutoria(CREATE_TUTORIA_DTO)).thenReturn(TUTORIA_DTO);
        Mockito.when(tutoriaService.deleteTutoria(TUTORIA_ID)).thenReturn(TUTORIA_DELETED);
    }

    @Test
    public void createTutoriaTest() throws BookingException{
        BookingResponse<TutoriaDto> response = tutoriaController.createTutoria(CREATE_TUTORIA_DTO);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), TUTORIA_DTO);
    }

    @Test
    public void getTutoriaByIdTest() throws BookingException {
        final BookingResponse<TutoriaDto> response = tutoriaController.getTutoriaById(TUTORIA_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), TUTORIA_DTO);

    }

    @Test
    public void getTutoriasTest() throws BookingException {
        final BookingResponse<List<TutoriaDto>> response = tutoriaController.getTutorias();

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), TUTORIA_DTO_LIST);

    }

    @Test
    public void deleteTutoriaTest() throws BookingException{

        final BookingResponse<String> response = tutoriaController.deleteTutoria(TUTORIA_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), TUTORIA_DELETED);

    }
}
