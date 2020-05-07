package com.chinita.company.gestionprocedimientos.api.repository;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long>, JpaSpecificationExecutor<Persona> {
}
