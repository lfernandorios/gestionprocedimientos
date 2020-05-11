package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.modelo.Procedimiento;
import com.chinita.company.gestionprocedimientos.api.servicio.modelo.ProcedimientoGuardarCmd;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@Transactional
public class ProcedimientoServicioImpl implements ProcedimientoServicio{

    private ProcedimientoGateway procedimientoGateway;

    public ProcedimientoServicioImpl(ProcedimientoGateway procedimientoGateway) {
        this.procedimientoGateway = procedimientoGateway;
    }

    @Override
    public Procedimiento crear(@NotNull ProcedimientoGuardarCmd procedimientoACrearCmd) {
        Procedimiento procedimientoACrear = ProcedimientoGuardarCmd.toModel(procedimientoACrearCmd);
        Procedimiento procedimientoCreado = procedimientoGateway.crear(procedimientoACrear);
        return procedimientoCreado;
    }

    @Override
    @Transactional(readOnly = true)
    public Procedimiento buscarPorId(@NotNull Long id) {
        Procedimiento procedimientoEncontrado = procedimientoGateway.buscarPorId(id);
        return procedimientoEncontrado;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Procedimiento> buscarTodos(@NotNull Pageable pageable) {
        Page<Procedimiento> procedimientosEncontrados = procedimientoGateway.buscarTodos(pageable);
        return procedimientosEncontrados;
    }

    @Override
    public void eliminar(@NotNull Long id) {
        procedimientoGateway.eliminar(id);
    }

    @Override
    public Procedimiento actualizar(@NotNull Long id, @NotNull ProcedimientoGuardarCmd procedimientoAActualizarCmd) {

        Procedimiento procedimientoEnBaseDato = buscarPorId(id);
        Procedimiento procedimientoAActualizar = procedimientoEnBaseDato.toBuilder().nombre(procedimientoAActualizarCmd.getNombre()).
                certificacion(procedimientoAActualizarCmd.getCertificacion()).
                vigencia(procedimientoAActualizarCmd.getVigencia()).estado(procedimientoAActualizarCmd.getEstado()).build();

        Procedimiento procedimientoActualizado = procedimientoGateway.actualizar(procedimientoAActualizar);

        return procedimientoActualizado;
    }

}
