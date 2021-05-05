package com.tutofinder.app.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tutofinder.app.dto.TutoriaDto;
import com.tutofinder.app.dto.create.CreateTutoriaDto;
import com.tutofinder.app.entity.Curso;
import com.tutofinder.app.entity.Docente;
import com.tutofinder.app.entity.Tutoria;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.exception.InternalServerErrorException;
import com.tutofinder.app.exception.NotFoundException;
import com.tutofinder.app.repository.CursoRepository;
import com.tutofinder.app.repository.DocenteRepository;
import com.tutofinder.app.repository.TutoriaRepository;
import com.tutofinder.app.services.TutoriaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutoriaServiceImpl implements TutoriaService {

    @Autowired
    TutoriaRepository tutoriaRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    DocenteRepository docenteRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public TutoriaDto getTutoriaById(Long tutoriaId) throws BookingException {
        return modelMapper.map(getTutoriaEntity(tutoriaId), TutoriaDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TutoriaDto> getTutorias() throws BookingException {
        List<Tutoria> tutoriaEntity = tutoriaRepository.findAll();
        return tutoriaEntity.stream().map(service -> modelMapper.map(service, TutoriaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TutoriaDto> getTutorias(Pageable pageable) throws BookingException {
        Page<Tutoria> tutoriaEntity = tutoriaRepository.findAll(pageable);
        return tutoriaEntity.stream().map(service -> modelMapper.map(service, TutoriaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TutoriaDto createTutoria(CreateTutoriaDto createTutoriaDto) throws BookingException {
        final Docente docente = docenteRepository.findById(createTutoriaDto.getDocenteId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "DOCENTE_NOT_FOUND"));

        final Curso curso = cursoRepository.findById(createTutoriaDto.getCursoId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "CURSO_NOT_FOUND"));

        Tutoria tutoria = new Tutoria();
        Long id;
        tutoria.setDescripcionTutoria(createTutoriaDto.getDescripcionTutoria());
        tutoria.setCantidadHoras(createTutoriaDto.getCantidadHoras());
        tutoria.setCurso(curso);
        tutoria.setDocente(docente);

        try {
            id = tutoriaRepository.save(tutoria).getId();
        } catch (final Exception e) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getTutoriaEntity(id), TutoriaDto.class);
    }

    @Override
    @Transactional
    public TutoriaDto updateTutoria(CreateTutoriaDto createTutoriaDto, Long tutoriaId) throws BookingException {
        final Curso curso = cursoRepository.findById(createTutoriaDto.getCursoId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "CURSO_NOT_FOUND"));
        Optional<Tutoria> tutoria = tutoriaRepository.findById(tutoriaId);
        if (!tutoria.isPresent()) {
            throw new NotFoundException("ID_NOT_FOOUND", "ID_NOT_FOUND");
        }

        Tutoria tutoriaEntity = tutoria.get();
        Long id;
        tutoriaEntity.setDescripcionTutoria(createTutoriaDto.getDescripcionTutoria());
        tutoriaEntity.setCantidadHoras(createTutoriaDto.getCantidadHoras());
        tutoriaEntity.setCurso(curso);
        try {
            id = tutoriaRepository.save(tutoriaEntity).getId();
        } catch (final Exception e) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getTutoriaEntity(id), TutoriaDto.class);
    }

    @Override
    public String deleteTutoria(Long tutoriaId) throws BookingException {
        tutoriaRepository.findById(tutoriaId)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "TUTORIA_NOT_FOUND"));
        try {
            tutoriaRepository.deleteById(tutoriaId);
        } catch (final Exception e) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return "TUTORIA_DELETED";
    }

    private Tutoria getTutoriaEntity(Long tutoriaId) throws BookingException {
        return tutoriaRepository.findById(tutoriaId)
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "TUTORIA_NOT_FOUND"));
    }
}
