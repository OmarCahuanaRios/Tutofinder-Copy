package com.tutofinder.app.services;

import com.tutofinder.app.dto.AlumnoDto;
import com.tutofinder.app.dto.create.CreateAlumnoDto;
import com.tutofinder.app.exception.BookingException;

import java.util.List;

public interface AlumnoService {
    AlumnoDto getAlumnoById(Long alumnoId) throws BookingException;
    List<AlumnoDto> getAlumnos() throws BookingException;
    AlumnoDto createAlumno(CreateAlumnoDto createAlumnoDto) throws BookingException;
    AlumnoDto updateAlumno(CreateAlumnoDto createAlumnoDto, Long alumnoId) throws BookingException;
    String deleteAlumno(Long alumnoId) throws BookingException;
}
