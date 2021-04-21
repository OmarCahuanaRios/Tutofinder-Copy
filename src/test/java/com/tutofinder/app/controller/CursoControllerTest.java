package com.tutofinder.app.controller;

import com.tutofinder.app.dto.CursoDto;
import com.tutofinder.app.dto.create.CreateCursoDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.CursoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CursoControllerTest {

    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";

    private static final Long CURSO_ID = 1L;
    private static final String NOMBRE_CURSO = "Matematica";
    CreateCursoDto CREATE_CURSO_DTO = new CreateCursoDto();

    private static final String CURSO_DELETED = "CURSO_DELETED";
    private static final CursoDto CURSO_DTO = new CursoDto();
    public static final List<CursoDto> CURSO_DTO_LIST = new ArrayList<>();

    @Mock
    CursoService cursoService;

    @InjectMocks
    CursoController cursoController;


    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        CREATE_CURSO_DTO.setNombre(NOMBRE_CURSO);
        Mockito.when(cursoService.getCursoById(CURSO_ID)).thenReturn(CURSO_DTO);
        Mockito.when(cursoService.createCurso(CREATE_CURSO_DTO)).thenReturn(CURSO_DTO);
        Mockito.when(cursoService.deleteCurso(CURSO_ID)).thenReturn(CURSO_DELETED);
    }

    @Test
    public void createCursoTest() throws BookingException{
        BookingResponse<CursoDto> response = cursoController.createCurso(CREATE_CURSO_DTO);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), CURSO_DTO);
    }

    @Test
    public void getCursoByIdTest() throws BookingException {
        final BookingResponse<CursoDto> response = cursoController.getCursoById(CURSO_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), CURSO_DTO);

    }

    @Test
    public void getCursosTest() throws BookingException {
        final BookingResponse<List<CursoDto>> response = cursoController.getCursos();

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), CURSO_DTO_LIST);

    }

    @Test
    public void deleteCursoTest() throws BookingException{

        final BookingResponse<String> response = cursoController.deleteCurso(CURSO_ID);

        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), CURSO_DELETED);

    }
}
