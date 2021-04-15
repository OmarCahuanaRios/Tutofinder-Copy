package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Docente;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends PagingAndSortingRepository <Docente,Long> {

}
