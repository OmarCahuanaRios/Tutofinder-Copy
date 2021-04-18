package com.tutofinder.app.controller;

import com.tutofinder.app.dto.DocenteDto;
import com.tutofinder.app.dto.create.CreateDocenteDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/tutofinder")
public class DocenteController {
    @Autowired
    DocenteService docenteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/docente/{docenteId}")
    public BookingResponse<DocenteDto> getDocenteById(@PathVariable Long docenteId) throws BookingException {
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                docenteService.getDocenteById(docenteId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/docentes")
    public BookingResponse<List<DocenteDto>> getDocentes() throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                docenteService.getDocentes());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/docente")
    public BookingResponse<DocenteDto> createDocente(@RequestBody @Valid CreateDocenteDto createDocenteDto)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                docenteService.createDocente(createDocenteDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/docente/{docenteId}")
    public BookingResponse<DocenteDto> updateDocente(@PathVariable Long docenteId,@RequestBody @Valid CreateDocenteDto createDocenteDto)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                docenteService.updateDocente(createDocenteDto,docenteId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/docente/{docenteId}")
    public BookingResponse<String> deleteDocente(@PathVariable Long docenteId)throws BookingException {
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                docenteService.deleteDocente(docenteId));
    }
}
