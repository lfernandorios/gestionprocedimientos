package com.chinita.company.gestionprocedimientos.api.Repository;

import com.chinita.company.gestionprocedimientos.api.Modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
