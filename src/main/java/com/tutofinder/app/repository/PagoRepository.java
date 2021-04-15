package com.tutofinder.app.repository;


import com.tutofinder.app.entity.Pago;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends PagingAndSortingRepository<Pago,Long> {
}
