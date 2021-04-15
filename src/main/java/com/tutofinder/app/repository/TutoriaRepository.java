package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Tutoria;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutoriaRepository extends PagingAndSortingRepository<Tutoria,Long> {
}
