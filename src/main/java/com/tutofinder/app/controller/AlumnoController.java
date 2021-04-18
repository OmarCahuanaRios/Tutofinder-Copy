package com.tutofinder.app.controller;

import com.tutofinder.app.dto.AlumnoDto;
import com.tutofinder.app.dto.create.CreateAlumnoDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tutofinder")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/alumno/{alumnoId}")
    BookingResponse<AlumnoDto> getAlumnoById(@PathVariable Long alumnoId)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                alumnoService.getAlumnoById(alumnoId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/alumnos")
    BookingResponse<List<AlumnoDto>> getAlumnos()throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                alumnoService.getAlumnos());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/alumno")
    BookingResponse<AlumnoDto> createAlumno(@RequestBody @Valid CreateAlumnoDto createAlumnoDto)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                alumnoService.createAlumno(createAlumnoDto));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/alumno/{alumnoId}")
    BookingResponse<AlumnoDto> updateAlumno(@PathVariable Long alumnoId , @RequestBody @Valid CreateAlumnoDto createAlumnoDto)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                alumnoService.updateAlumno(createAlumnoDto,alumnoId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/alumno/{alumnoId}")
    BookingResponse<String> deleteAlumno(@PathVariable Long alumnoId)throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                alumnoService.deleteAlumno(alumnoId));
    }
}
