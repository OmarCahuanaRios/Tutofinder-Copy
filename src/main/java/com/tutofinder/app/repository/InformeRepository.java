package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Informe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InformeRepository extends JpaRepository<Informe,Long> {
    Optional<Informe> findById(Long id);
}
