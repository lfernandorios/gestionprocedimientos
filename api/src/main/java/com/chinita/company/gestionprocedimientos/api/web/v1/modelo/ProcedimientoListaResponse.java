package com.chinita.company.gestionprocedimientos.api.web.v1.modelo;

import com.chinita.company.gestionprocedimientos.api.modelo.Procedimiento;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcedimientoListaResponse {

    private Long id;

    private String nombre;

    private String certificacion;

    private LocalDateTime vigencia;

    private String estado;

    public static ProcedimientoListaResponse fromModel(Procedimiento procedimiento) {
        return ProcedimientoListaResponse.builder().id(procedimiento.getId()).
                nombre(procedimiento.getNombre()).
                certificacion(procedimiento.getCertificacion()).
                vigencia(procedimiento.getVigencia()).
                estado(procedimiento.getEstado()).build();
    }
}
