package com.tutofinder.app.services.impl;

import com.tutofinder.app.dto.AlumnoDto;
import com.tutofinder.app.dto.create.CreateAlumnoDto;
import com.tutofinder.app.entity.Alumno;
import com.tutofinder.app.entity.Padre;
import com.tutofinder.app.entity.Tutoria;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.exception.InternalServerErrorException;
import com.tutofinder.app.exception.NotFoundException;
import com.tutofinder.app.repository.AlumnoRepository;
import com.tutofinder.app.repository.PadreRepository;
import com.tutofinder.app.repository.TutoriaRepository;
import com.tutofinder.app.services.AlumnoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    PadreRepository padreRepository;

    @Autowired
    TutoriaRepository tutoriaRepository;

    public static ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public AlumnoDto getAlumnoById(Long alumnoId) throws BookingException {
        return modelMapper.map(getAlumnoEntity(alumnoId),AlumnoDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AlumnoDto> getAlumnos() throws BookingException {
        List<Alumno> alumnoEntity = alumnoRepository.findAll();
        return alumnoEntity.stream().map(service->modelMapper.map(service,AlumnoDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AlumnoDto createAlumno(CreateAlumnoDto createAlumnoDto, MultipartFile archivo) throws BookingException, IOException {
        final Padre padre = padreRepository.findById(createAlumnoDto.getPadreId()).
                orElseThrow(()->new NotFoundException("PADRE_NOT_FOUND","PADRE_NOT_FOUND"));
        final Tutoria tutoria = tutoriaRepository.findById(createAlumnoDto.getTutoriaId()).
                orElseThrow(()->new NotFoundException("TUTORIA_NOT_FOUND","TUTORIA_NOT_FOUND"));
        Alumno alumnoEntity;
        Alumno alumno = new Alumno();
        alumno.setApellido(createAlumnoDto.getApellido());
        alumno.setGradoEstudio(createAlumnoDto.getGradoEstudio());
        alumno.setNombre(createAlumnoDto.getNombre());
        alumno.setFoto(archivo.getBytes());
        alumno.setPadre(padre);
        alumno.setTutoria(tutoria);
        alumno.setDni(createAlumnoDto.getDni());
        alumno.setCorreo(createAlumnoDto.getCorreo());
        try {
            alumnoEntity = alumnoRepository.save(alumno);
        } catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getAlumnoEntity(alumnoEntity.getId()), AlumnoDto.class);
    }

    @Override
    @Transactional
    public AlumnoDto updateAlumno(CreateAlumnoDto createAlumnoDto, Long alumnoId, MultipartFile archivo) throws BookingException, IOException {
        final Padre padre = padreRepository.findById(createAlumnoDto.getPadreId()).
                orElseThrow(()->new NotFoundException("PADRE_NOT_FOUND","PADRE_NOT_FOUND"));
        final Tutoria tutoria = tutoriaRepository.findById(createAlumnoDto.getTutoriaId()).
                orElseThrow(()->new NotFoundException("TUTORIA_NOT_FOUND","TUTORIA_NOT_FOUND"));
        Optional<Alumno> alumno = alumnoRepository.findById(alumnoId);
        if(!alumno.isPresent()){
            throw new NotFoundException("ID_NOT_FOOUND","ID_NOT_FOUND");
        }
        Alumno alumnoEntity = alumno.get();
        alumnoEntity.setNombre(createAlumnoDto.getNombre());
        alumnoEntity.setApellido(createAlumnoDto.getApellido());
        alumnoEntity.setGradoEstudio(createAlumnoDto.getGradoEstudio());
        alumnoEntity.setFoto(archivo.getBytes());
        alumnoEntity.setPadre(padre);
        alumnoEntity.setTutoria(tutoria);
        alumnoEntity.setDni(createAlumnoDto.getDni());
        alumnoEntity.setCorreo(createAlumnoDto.getCorreo());
        try {
            alumnoRepository.save(alumnoEntity);
        }
        catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getAlumnoEntity(alumnoEntity.getId()), AlumnoDto.class);
    }

    @Override
    public String deleteAlumno(Long alumnoId) throws BookingException {
        alumnoRepository.findById(alumnoId).
                orElseThrow(()-> new NotFoundException("SNOT-404-1","ALUMNO_NOT_FOUND"));
        try {
            alumnoRepository.deleteById(alumnoId);
        } catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return "ALUMNO_DELETED";
    }

    private Alumno getAlumnoEntity(Long alumnoId) throws BookingException{
        return alumnoRepository.findById(alumnoId).
                orElseThrow(()-> new NotFoundException("SNOT-404-1","CURSO_NOT_FOUND"));
    }
}
