package com.chinita.company.gestionprocedimientos.api.gateway;

import com.chinita.company.gestionprocedimientos.api.modelo.Procedimiento;
import com.chinita.company.gestionprocedimientos.api.repository.ProcedimientoRepository;
import com.chinita.company.gestionprocedimientos.api.servicio.ProcedimientoGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public class ProcedimientoGatewayImpl implements ProcedimientoGateway {

    private static final String RESOURCE_NOT_FOUND = "Procedimiento no encontrado";
    private ProcedimientoRepository procedimientoRepository;

    public ProcedimientoGatewayImpl(ProcedimientoRepository procedimientoRepository) {
        this.procedimientoRepository = procedimientoRepository;
    }

    @Override
    public Procedimiento crear(@NotNull Procedimiento procedimientoACrear) {

        final Procedimiento procedimientoASerCreado = procedimientoACrear;

        final Procedimiento procedimientoCreado = procedimientoRepository.save(procedimientoASerCreado);

        return procedimientoCreado;
    }

    @Override
    public Procedimiento buscarPorId(@NotNull Long id) {

        Procedimiento procedimientoEncontrado = procedimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND));

        return procedimientoEncontrado;
    }

    @Override
    public Page<Procedimiento> buscarTodos(@NotNull Pageable pageable) {

        Page<Procedimiento> procedimientosEncontrados = procedimientoRepository.findAll(pageable);

        return procedimientosEncontrados;
    }

    @Override
    public void eliminar(@NotNull Long id) {

        Procedimiento procedimientoAEliminar = buscarPorId(id);
        procedimientoRepository.deleteById(procedimientoAEliminar.getId());

    }


    @Override
    public Procedimiento actualizar(@NotNull Procedimiento procedimientoAActualizar) {

        final Procedimiento procedimientoASerActualizado = procedimientoAActualizar;

        final Procedimiento procedimientoActualizado = procedimientoRepository.save(procedimientoASerActualizado);

        return procedimientoActualizado;
    }
}
