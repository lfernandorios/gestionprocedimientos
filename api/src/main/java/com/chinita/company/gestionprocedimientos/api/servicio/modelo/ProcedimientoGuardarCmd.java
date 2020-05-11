package com.chinita.company.gestionprocedimientos.api.servicio.modelo;

import com.chinita.company.gestionprocedimientos.api.modelo.Procedimiento;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcedimientoGuardarCmd {

    @NotNull
    private String nombre;

    @NotNull
    private String certificacion;

    @NotNull
    private LocalDateTime vigencia;

    @NotNull
    private String  estado;

    public static Procedimiento toModel(@NotNull ProcedimientoGuardarCmd procedimientoGuardarCmd){
        return Procedimiento.builder().nombre(procedimientoGuardarCmd.getNombre()).
                certificacion(procedimientoGuardarCmd.getCertificacion()).
                vigencia(procedimientoGuardarCmd.getVigencia()).estado(procedimientoGuardarCmd.getEstado()).build();
    }

}
