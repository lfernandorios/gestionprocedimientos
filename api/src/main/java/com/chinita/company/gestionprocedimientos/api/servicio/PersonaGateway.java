package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import org.springframework.data.domain.Page;
import javax.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;

public interface PersonaGateway {
    Persona crear(@NotNull Persona personaACrear);
    Persona buscarPorId(@NotNull Long id);
    Page<Persona> buscarTodos(@NotNull Pageable pageable);
    void eliminar(@NotNull Long id);
    Persona actualizar(@NotNull Persona personaAActualizar);
}
