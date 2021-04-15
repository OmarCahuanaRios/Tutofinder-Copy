package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Curso;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends PagingAndSortingRepository<Curso,Long> {
}
