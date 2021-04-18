package com.tutofinder.app.controller;

import com.tutofinder.app.dto.PadreDto;
import com.tutofinder.app.dto.create.CreatePadreDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.PadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/tutofinder")
public class PadreController {
    @Autowired
    PadreService padreService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/padre/{padreId}")
    public BookingResponse<PadreDto> getPadreById(@PathVariable Long padreId) throws BookingException {
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                padreService.getPadreById(padreId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/padres")
    public BookingResponse<List<PadreDto>> getPadres() throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                padreService.getPadres());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/padre")
    public BookingResponse<PadreDto> createPadre(@RequestBody @Valid CreatePadreDto createPadreDto) throws BookingException {
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                padreService.createPadre(createPadreDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/padre/{padreId}")
    public BookingResponse<PadreDto> createPadre(@PathVariable Long padreId ,@RequestBody @Valid CreatePadreDto createPadreDto) throws BookingException {
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                padreService.updatePadre(createPadreDto,padreId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/padre/{padreId}")
    public BookingResponse<String> deletePadre(@PathVariable Long padreId) throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                padreService.deletePadre(padreId));
    }
}
