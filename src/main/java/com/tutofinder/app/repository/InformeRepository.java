package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Informe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformeRepository extends PagingAndSortingRepository<Informe,Long> {
}
