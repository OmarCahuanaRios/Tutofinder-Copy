package com.tutofinder.app.controller;

import com.tutofinder.app.dto.MembresiaDto;
import com.tutofinder.app.dto.create.CreateMembresiaDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/tutofinder")
public class MembresiaController {

    @Autowired
    MembresiaService membresiaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/membresia/{membresiaId}")
    public BookingResponse<MembresiaDto> getMembresiaById(@PathVariable Long membresiaId) throws BookingException {
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                membresiaService.getMembresiaById(membresiaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/membresias")
    public BookingResponse<List<MembresiaDto>> getMembresias() throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                membresiaService.getMembresias());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/membresia")
    public BookingResponse<MembresiaDto> createMembresia(@RequestBody @Valid CreateMembresiaDto createMembresiaDto)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                membresiaService.createMembresia(createMembresiaDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/membresia/{membresiaId}")
    public BookingResponse<MembresiaDto> updateMembresia(@PathVariable Long membresiaId,@RequestBody @Valid CreateMembresiaDto createMembresiaDto)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                membresiaService.updateMembresia(createMembresiaDto,membresiaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/membresia/{membresiaId}")
    public BookingResponse<String> deleteMembresia(@PathVariable Long membresiaId)throws BookingException {
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                membresiaService.deleteMembresia(membresiaId));
    }
}
