package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Alumno;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno,Long> {
}
