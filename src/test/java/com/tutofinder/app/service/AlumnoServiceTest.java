package com.tutofinder.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


import com.tutofinder.app.dto.AlumnoDto;
import com.tutofinder.app.dto.TutoriaDto;
import com.tutofinder.app.dto.create.CreatePadreDto;
import com.tutofinder.app.entity.Alumno;
import com.tutofinder.app.entity.Curso;
import com.tutofinder.app.entity.Padre;
import com.tutofinder.app.entity.Tutoria;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.repository.AlumnoRepository;
import com.tutofinder.app.repository.PadreRepository;
import com.tutofinder.app.services.impl.AlumnoServiceImpl;
import com.tutofinder.app.services.impl.PadreServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlumnoServiceTest {

    @Mock
    AlumnoRepository alumnoRepository;
    @InjectMocks
    AlumnoServiceImpl alumnoServiceImpl;


    private static final Long ALUMNO_ID = 1L;
    private static final String NOMBRE_ALUMNO = "RASO";
    private static final String ALUMNO_APELLIDO="RES";
    private static final String DNI ="AADADD";
    private static final String GRADO_DE_ESTUDIO="SUP";
    private static final long PADREID = 1L;
    private static final String CORREO = "SDADADDDADA";
    private static  final byte [] FOTO  = "Any String you want".getBytes();
    private static final Date DATE = new Date();

    CreatePadreDto CREATE_PADRE_DTO = new CreatePadreDto();

    public  static  final Alumno ALUMNO = new Alumno();

    private static final String PADRE_DELETED = "INFORME_DELETED";
    private static final Optional<Alumno> OPTIONAL_PADRE_EMPTY = Optional.empty();
    private static final Optional<Alumno> OPTIONAL_ALUMNO = Optional.of(ALUMNO);
    public static final List<Tutoria> TUTORIA_DTO_LIST = new ArrayList<>();

    @Mock
    PadreRepository padreRepository;
    @InjectMocks
    PadreServiceImpl padreServiceImpl;

    @Before
    public  void init() throws  BookingException{
        MockitoAnnotations.initMocks(this);
        ALUMNO.setNombre(NOMBRE_ALUMNO);
        ALUMNO.setApellido(ALUMNO_APELLIDO);
        ALUMNO.setCorreo(CORREO);
        ALUMNO.setDni(DNI);
        ALUMNO.setFoto(FOTO);
        //ALUMNO.setTutorias(TUTORIA_DTO_LIST);
    }



    @Test
    public void getPadreById() throws BookingException{
        Mockito.when(alumnoRepository.findById(ALUMNO_ID)).thenReturn(OPTIONAL_ALUMNO);
        alumnoServiceImpl.getAlumnoById(ALUMNO_ID);
    }

    @Test
    public void  getAlumnos() throws BookingException {
        final Alumno alumno = new Alumno();
        Mockito.when(alumnoRepository.findAll()).thenReturn(Arrays.asList(alumno));
        final List<AlumnoDto> response = alumnoServiceImpl.getAlumnos();
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(), 1);
    }
    @Test
    public void createAlumno() throws BookingException, IOException {

    }
    @Test
    public void updateAlumno() throws BookingException, IOException{

    }
    @Test
    public void deleteAlumno() throws BookingException{

    }
}


