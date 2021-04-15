package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Favorito;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritoRepository extends PagingAndSortingRepository <Favorito,Long> {
}
