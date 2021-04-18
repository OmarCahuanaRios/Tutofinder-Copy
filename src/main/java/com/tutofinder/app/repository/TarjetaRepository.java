package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
    Optional<Tarjeta> findById(Long id);
}
