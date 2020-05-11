package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.modelo.Procedimiento;
import com.chinita.company.gestionprocedimientos.api.servicio.modelo.ProcedimientoGuardarCmd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;

public interface ProcedimientoServicio {

    Procedimiento crear(@NotNull ProcedimientoGuardarCmd procedimientoACrearCmd);
    Procedimiento buscarPorId(@NotNull Long id);
    Page<Procedimiento> buscarTodos(@NotNull Pageable pageable);
    void eliminar(@NotNull Long id);
    Procedimiento actualizar(@NotNull Long id,@NotNull ProcedimientoGuardarCmd procedimientoAActualizarCmd);
}
