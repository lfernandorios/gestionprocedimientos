package com.chinita.company.gestionprocedimientos.api.web.v1.modelo;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaListaResponse {

    private long rowId;

    private String tipoDocumento;

    private String documento;

    private String nombre;

    private String apellidos;

    private String sexo;

    private LocalDateTime fechaNacimiento;

    public static PersonaListaResponse fromModel(Persona persona){
        return PersonaListaResponse.builder().rowId(persona.getRowId()).tipoDocumento(persona.getTipoDocumento()).
                documento(persona.getDocumento()).nombre(persona.getNombre()).apellidos(persona.getApellidos()).
                sexo(persona.getSexo()).build();
    }
}
