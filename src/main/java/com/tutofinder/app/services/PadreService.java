package com.tutofinder.app.services;

import com.tutofinder.app.dto.PadreDto;
import com.tutofinder.app.dto.create.CreatePadreDto;
import com.tutofinder.app.exception.BookingException;

import java.util.List;

public interface PadreService {
    PadreDto getPadreById(Long padreId) throws BookingException;
    List<PadreDto> getPadres() throws BookingException;
    PadreDto createPadre(CreatePadreDto createPadreDto) throws  BookingException;
    PadreDto updatePadre(CreatePadreDto createPadreDto , Long padreId) throws  BookingException;
    String deletePadre(Long padreId) throws BookingException;
}
