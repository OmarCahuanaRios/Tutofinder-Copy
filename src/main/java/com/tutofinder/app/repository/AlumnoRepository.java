package com.tutofinder.app.repository;

import com.tutofinder.app.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
    Optional<Alumno> findById(Long id);
}
