package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Tarjeta;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends PagingAndSortingRepository<Tarjeta,Long> {
}
