package com.chinita.company.gestionprocedimientos.api.web.v1.modelo;

import com.chinita.company.gestionprocedimientos.api.servicio.modelo.PersonaGuardarCmd;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaGuardarRequest {

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
    private LocalDateTime fechaNacimiento;;

    public static PersonaGuardarCmd toModel(PersonaGuardarRequest personaACrear) {
        return PersonaGuardarCmd.builder().tipoDocumento(personaACrear.getTipoDocumento()).documento(personaACrear.getDocumento())
                .nombre(personaACrear.getNombre()).apellidos(personaACrear.getApellidos()).
                        sexo(personaACrear.getSexo()).fechaNacimiento(personaACrear.getFechaNacimiento()).build();
    }

}
