package com.tutofinder.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.tutofinder.app.dto.TutoriaDto;
import com.tutofinder.app.dto.create.CreateTutoriaDto;
import com.tutofinder.app.entity.Curso;
import com.tutofinder.app.entity.Docente;
import com.tutofinder.app.entity.Tutoria;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.repository.CursoRepository;
import com.tutofinder.app.repository.DocenteRepository;
import com.tutofinder.app.repository.TutoriaRepository;
import com.tutofinder.app.services.impl.TutoriaServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TutoriaServiceTest {
    private static Long TUTORIA_ID;
    private static int CANTIDAD_HORAS;
    private static String DESCRIPCION_TUTORIA;
    private static Long CURSO_ID;
    private static Long DOCENTE_ID;

    private static CreateTutoriaDto CREATE_TUTORIA_DTO = new CreateTutoriaDto();
    private static Tutoria TUTORIA = new Tutoria();
    private static Curso CURSO = new Curso();
    private static Docente DOCENTE = new Docente();

    @InjectMocks
    TutoriaServiceImpl tutoriaServiceImpl;

    @Mock
    TutoriaRepository tutoriaRepository;

    @Mock
    CursoRepository cursoRepository;

    @Mock
    DocenteRepository docenteRepository;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        CREATE_TUTORIA_DTO.setCantidadHoras(CANTIDAD_HORAS);
        CREATE_TUTORIA_DTO.setDescripcionTutoria(DESCRIPCION_TUTORIA);
        CREATE_TUTORIA_DTO.setCursoId(CURSO_ID);
        CREATE_TUTORIA_DTO.setDocenteId(DOCENTE_ID);

        TUTORIA.setId(TUTORIA_ID);
        TUTORIA.setCantidadHoras(CANTIDAD_HORAS);
        TUTORIA.setDescripcionTutoria(DESCRIPCION_TUTORIA);
        TUTORIA.setCurso(CURSO);
        TUTORIA.setDocente(DOCENTE);
    }

    @Test
    public void getTutoriaByIdTest() throws BookingException {
        Mockito.when(tutoriaRepository.findById(TUTORIA_ID)).thenReturn(Optional.of(TUTORIA));
        tutoriaServiceImpl.getTutoriaById(TUTORIA_ID);
    }

    @Test
    public void getTutoriasTest() throws BookingException {
        Mockito.when(tutoriaRepository.findAll()).thenReturn(Arrays.asList(new Tutoria()));
        final List<TutoriaDto> response = tutoriaServiceImpl.getTutorias();
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(), 1);
    }

    @Test
    public void createTutoriaTest() throws BookingException {
        Mockito.when(docenteRepository.findById(DOCENTE_ID)).thenReturn(Optional.of(DOCENTE));
        Mockito.when(cursoRepository.findById(CURSO_ID)).thenReturn(Optional.of(CURSO));
        Mockito.when(tutoriaRepository.findById(TUTORIA_ID)).thenReturn(Optional.of(TUTORIA));
        Mockito.when(tutoriaRepository.save(Mockito.any(Tutoria.class))).thenReturn(TUTORIA);
        tutoriaServiceImpl.createTutoria(CREATE_TUTORIA_DTO);
    }

    @Test
    public void updateTutoriaTest() throws BookingException {
        Mockito.when(docenteRepository.findById(DOCENTE_ID)).thenReturn(Optional.of(DOCENTE));
        Mockito.when(cursoRepository.findById(CURSO_ID)).thenReturn(Optional.of(CURSO));
        Mockito.when(tutoriaRepository.findById(TUTORIA_ID)).thenReturn(Optional.of(TUTORIA));
        Mockito.when(tutoriaRepository.save(Mockito.any(Tutoria.class))).thenReturn(TUTORIA);
        tutoriaServiceImpl.createTutoria(CREATE_TUTORIA_DTO);
    }

    @Test
    public void deleteTutoriaTest() throws BookingException {
        Mockito.when(tutoriaRepository.findById(TUTORIA_ID)).thenReturn(Optional.of(TUTORIA));
        tutoriaServiceImpl.deleteTutoria(TUTORIA_ID);
    }
}
