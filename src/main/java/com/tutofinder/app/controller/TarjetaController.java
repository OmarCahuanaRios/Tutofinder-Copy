package com.tutofinder.app.controller;

import com.tutofinder.app.dto.TarjetaDto;
import com.tutofinder.app.dto.create.CreateTarjetaDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/tutofinder")
public class TarjetaController {

    @Autowired
    TarjetaService tarjetaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tarjeta/{tarjetaId}")
    public BookingResponse<TarjetaDto> getTarjetaById(@PathVariable Long tarjetaId)throws BookingException {
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                tarjetaService.getTarjetaById(tarjetaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tarjetas")
    public BookingResponse<List<TarjetaDto>> getTarjetas() throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                tarjetaService.getTarjetas());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tarjeta")
    public BookingResponse<TarjetaDto> createTarjeta(@RequestBody @Valid CreateTarjetaDto createTarjetaDto)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                tarjetaService.createTarjeta(createTarjetaDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/tarjeta/{tarjetaId}")
    public BookingResponse<TarjetaDto> updateTarjeta(@PathVariable Long tarjetaId,@RequestBody @Valid CreateTarjetaDto createTarjetaDto)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                tarjetaService.updateTarjeta(createTarjetaDto,tarjetaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/tarjeta/{tarjetaId}")
    public BookingResponse<String> deleteTarjeta(@PathVariable Long tarjetaId)throws BookingException {
        return new BookingResponse<>("Deleted",String.valueOf(HttpStatus.OK),"OK",
                tarjetaService.deleteTarjeta(tarjetaId));
    }
}
