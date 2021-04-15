package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Membresia;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends PagingAndSortingRepository<Membresia,Long> {
}
