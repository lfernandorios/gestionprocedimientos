package com.chinita.company.gestionprocedimientos.api.repository;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
