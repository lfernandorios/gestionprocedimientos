package com.chinita.company.gestionprocedimientos.api.web.v1.modelo;

import com.chinita.company.gestionprocedimientos.api.servicio.modelo.ProcedimientoGuardarCmd;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcedimientoGuardarRequest {

    @NotNull
    private String nombre;

    @NotNull
    private String certificacion;

    @NotNull
    private LocalDateTime vigencia;

    @NotNull
    private String estado;

    public static ProcedimientoGuardarCmd toModel(ProcedimientoGuardarRequest procedimientoACrear) {
        return ProcedimientoGuardarCmd.builder().nombre(procedimientoACrear.getNombre()).
            certificacion(procedimientoACrear.getCertificacion()).
                vigencia(procedimientoACrear.getVigencia()).
                    estado(procedimientoACrear.getEstado()).build();
    }

}
