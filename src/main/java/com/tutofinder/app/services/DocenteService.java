package com.tutofinder.app.services;

import com.tutofinder.app.dto.DocenteDto;
import com.tutofinder.app.dto.create.CreateDocenteDto;
import com.tutofinder.app.exception.BookingException;

import java.util.List;

public interface DocenteService {
    DocenteDto getDocenteById(Long docenteId) throws BookingException;
    List<DocenteDto> getDocentes() throws BookingException;
    DocenteDto createDocente(CreateDocenteDto createDocenteDto) throws BookingException;
    DocenteDto updateDocente(CreateDocenteDto createDocenteDto, Long docenteId) throws BookingException;
    String deleteDocente(Long docenteId) throws BookingException;
}
