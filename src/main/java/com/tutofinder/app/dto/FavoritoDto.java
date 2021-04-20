package com.tutofinder.app.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoritoDto {
    private Long id;
    private Long padreId;
    private DocenteDto docente;
}
