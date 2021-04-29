package com.tutofinder.app.controller;

import com.tutofinder.app.dto.FavoritoDto;
import com.tutofinder.app.dto.create.CreateFavoritoDto;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.response.BookingResponse;
import com.tutofinder.app.services.FavoritoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FavoritoControllerTest {
    private static final String SUCCES_STATUS = "Success";
    private static final String SUCCES_CODE = "200 OK";
    private static final String OK = "OK";
    private static final String FAVORITO_DELETED = "FAVORITO_DELETED";
    private static final Long FAVORITO_ID = 1L;
    private static final Long PADRE_ID_FAVORITO = 1L;
    private static final Long DOCENTE_ID_FAVORITO = 1L;

    private static final FavoritoDto FAVORITO_DTO = new FavoritoDto();

    CreateFavoritoDto CREATE_FAVORITO_DTO = new CreateFavoritoDto();
    public static final List<FavoritoDto> FAVORITO_DTO_LIST = new ArrayList<>();

    @Mock
    FavoritoService favoritoService;

    @InjectMocks
    FavoritoController favoritoController;

    @Before
    public void init() throws BookingException{
        MockitoAnnotations.initMocks(this);
        CREATE_FAVORITO_DTO.setDocenteId(DOCENTE_ID_FAVORITO);
        CREATE_FAVORITO_DTO.setPadreId(PADRE_ID_FAVORITO);

        Mockito.when(favoritoService.getFavoritoById(FAVORITO_ID)).thenReturn(FAVORITO_DTO);
        Mockito.when(favoritoService.createFavorito(CREATE_FAVORITO_DTO)).thenReturn(FAVORITO_DTO);
        Mockito.when(favoritoService.deleteFavorito(FAVORITO_ID)).thenReturn(FAVORITO_DELETED);
    }

    @Test
    public void createFavoritoTest() throws BookingException{
        BookingResponse<FavoritoDto> response = favoritoController.createFavorito(CREATE_FAVORITO_DTO);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), FAVORITO_DTO);
    }

    @Test
    public void getFavoritoByIdTest() throws BookingException {
        final BookingResponse<FavoritoDto> response = favoritoController.getFavoritoById(FAVORITO_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), FAVORITO_DTO);
    }

    @Test
    public void getFavoritosTest() throws BookingException {
        final BookingResponse<List<FavoritoDto>> response = favoritoController.getFavoritos();
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), FAVORITO_DTO_LIST);
    }
    @Test
    public void getFavoritosByPadreIdTest() throws BookingException {
        final BookingResponse<List<FavoritoDto>> response = favoritoController.getFavoritoByPadreId(PADRE_ID_FAVORITO);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), FAVORITO_DTO_LIST);
    }

    @Test
    public void deleteFavoritoTest() throws BookingException{
        final BookingResponse<String> response = favoritoController.deleteFavorito(FAVORITO_ID);
        assertEquals(response.getStatus(), SUCCES_STATUS);
        assertEquals(response.getCode(), SUCCES_CODE);
        assertEquals(response.getMessage(), OK);
        assertEquals(response.getData(), FAVORITO_DELETED);
    }

}
