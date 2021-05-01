package com.tutofinder.app.service;

import com.tutofinder.app.dto.create.CreateMembresiaDto;
import com.tutofinder.app.entity.Docente;
import com.tutofinder.app.entity.Membresia;
import com.tutofinder.app.entity.Tarjeta;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.util.DateUtil.now;

public class MembresiaServiceTest {
    private static final Long MEMBRESIA_ID = 1L;
    private static final String DESCRIPCION_MEMBRESIA = "bueno";
    private static final Double COSTO_MEMBRESIA = 45.8;
    private static final Date FECHA_EXPIRACION = now();
    public static final Membresia MEMBRESIA = new Membresia();

    CreateMembresiaDto CREATE_MEMBRESIA_DTO = new CreateMembresiaDto();
    private static final String INFORME_DELETED = "INFORME_DELETED";
    private static final Optional<Membresia> OPTIONAL_INFORME_EMPTY = Optional.empty();
    private static final Optional<Membresia> OPTIONAL_INFORME = Optional.of(MEMBRESIA);
    private static final Optional<Tarjeta> OPTIONAL_TUTORIA = Optional.of(new Tarjeta());
    private static final Optional<Docente> OPTIONAL_ALUMNO = Optional.of(new Docente());





}
