package com.tutofinder.app.service;

import com.tutofinder.app.dto.create.CreateMembresiaDto;
import com.tutofinder.app.entity.Docente;
import com.tutofinder.app.entity.Membresia;
import com.tutofinder.app.entity.Tarjeta;
import com.tutofinder.app.repository.AlumnoRepository;
import com.tutofinder.app.repository.MembresiaRepository;
import com.tutofinder.app.repository.TarjetaRepository;
import com.tutofinder.app.services.impl.MembresiaServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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

    @Mock
    MembresiaRepository informeRepository;

    @Mock
    TarjetaRepository tutoriaRepository;

    @Mock
    AlumnoRepository alumnoRepository;

    @InjectMocks
    MembresiaServiceImpl informeServiceImpl;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);

        INFORME.setId(INFORME_ID);
        INFORME.setDescripcionInforme(DESCRIPCION_INFORME);

        CREATE_INFORME_DTO.setDescripcionInforme(DESCRIPCION_INFORME);
        CREATE_INFORME_DTO.setTutoriaId(TUTORIA_ID);
        CREATE_INFORME_DTO.setAlumnoId(ALUMNO_ID);
    }

    @Test
    public void getInformeByIdTest() throws BookingException{
        Mockito.when(informeRepository.findById(INFORME_ID)).thenReturn(OPTIONAL_INFORME);
        informeServiceImpl.getInformeById(INFORME_ID);
    }

    @Test
    public void getInformesTest() throws BookingException{
        final Informe informe = new Informe();
        Mockito.when(informeRepository.findAll()).thenReturn(Arrays.asList(informe));
        final List<InformeDto> response = informeServiceImpl.getInformes();
        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(), 1);
    }

    @Test(expected = BookingException.class)
    public void getInformeByIdTestError() throws BookingException{
        Mockito.when(informeRepository.findById(INFORME_ID)).thenReturn(OPTIONAL_INFORME_EMPTY);
        informeServiceImpl.getInformeById(INFORME_ID);
        fail();
    }

    @Test
    public void createInformeTest() throws BookingException{
        Mockito.when(tutoriaRepository.findById(TUTORIA_ID)).thenReturn(OPTIONAL_TUTORIA);
        Mockito.when(alumnoRepository.findById(ALUMNO_ID)).thenReturn(OPTIONAL_ALUMNO);
        Mockito.when(informeRepository.findById(INFORME_ID)).thenReturn(OPTIONAL_INFORME);
        Mockito.when(informeRepository.save(Mockito.any(Informe.class))).thenReturn(INFORME);
        informeServiceImpl.createInforme(CREATE_INFORME_DTO);
    }

    @Test(expected = MockitoException.class)
    public void createInformeInternalServerErrorTest() throws BookingException {
        Mockito.when(informeRepository.findById(INFORME_ID)).thenReturn(OPTIONAL_INFORME);
        Mockito.doThrow(Exception.class).when(informeRepository).save(Mockito.any(Informe.class));
        informeServiceImpl.createInforme(CREATE_INFORME_DTO);
        fail();
    }

    @Test
    public void deleteInformeOk() throws BookingException {
        Mockito.when(informeRepository.findById(INFORME_ID)).thenReturn(OPTIONAL_INFORME);
        final String response = informeServiceImpl.deleteInforme(INFORME_ID);
        assertEquals(response, INFORME_DELETED);
    }

    @Test(expected = BookingException.class)
    public void deleteInformeNotFountError() throws BookingException {
        Mockito.when(informeRepository.findById(INFORME_ID)).thenReturn(OPTIONAL_INFORME_EMPTY);
        final String response = informeServiceImpl.deleteInforme(INFORME_ID);
        assertEquals(response, INFORME_DELETED);
        fail();
    }

    @Test(expected = MockitoException.class)
    public void deleteInformeInternalServerError() throws BookingException {
        Mockito.when(informeRepository.findById(INFORME_ID)).thenReturn(OPTIONAL_INFORME);
        Mockito.doThrow(Exception.class).when(informeRepository).deleteById(INFORME_ID);
        final String response = informeServiceImpl.deleteInforme(INFORME_ID);
        assertEquals(response, INFORME_DELETED);
        fail();
    }





}
