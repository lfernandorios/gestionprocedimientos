package com.chinita.company.gestionprocedimientos.api.repository;

import com.chinita.company.gestionprocedimientos.api.modelo.Procedimiento;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimientoRepository extends PagingAndSortingRepository<Procedimiento, Long>, JpaSpecificationExecutor<Procedimiento> {

}
