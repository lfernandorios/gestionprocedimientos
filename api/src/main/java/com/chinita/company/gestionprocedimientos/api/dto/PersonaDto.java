package com.chinita.company.gestionprocedimientos.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Builder
public class PersonaDto {

    private long rowId;

    @NotNull
    private String tipoDocumento;

    @NotNull
    private String documento;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidos;

    @NotNull
    private String sexo;

    @NotNull
    private Date fechaNacimiento;
}
