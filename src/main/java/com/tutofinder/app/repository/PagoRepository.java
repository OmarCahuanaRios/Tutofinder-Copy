package com.tutofinder.app.repository;


import com.tutofinder.app.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago,Long> {

    Optional<Pago> findById(Long id);

}
