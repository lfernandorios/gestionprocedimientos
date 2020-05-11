package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import com.chinita.company.gestionprocedimientos.api.modelo.Procedimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;

public interface ProcedimientoGateway {
    Procedimiento crear(@NotNull Procedimiento procedimientoACrear);
    Procedimiento buscarPorId(@NotNull Long id);
    Page <Procedimiento> buscarTodos(@NotNull Pageable pageable);
    void eliminar(@NotNull Long id);
    Procedimiento actualizar(@NotNull Procedimiento procedimientoAActualizar);
}
