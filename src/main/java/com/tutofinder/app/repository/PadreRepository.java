package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Padre;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadreRepository extends PagingAndSortingRepository<Padre,Long> {
}
