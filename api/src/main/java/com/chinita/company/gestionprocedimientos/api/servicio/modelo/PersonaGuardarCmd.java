package com.chinita.company.gestionprocedimientos.api.servicio.modelo;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@Getter
@Setter
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaGuardarCmd {

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
    private LocalDateTime fechaNacimiento;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Persona toModel(@NotNull PersonaGuardarCmd personaAGuardarCmd){
            return Persona.builder().tipoDocumento(personaAGuardarCmd.getTipoDocumento()).documento(personaAGuardarCmd.getDocumento()).
                    nombre(personaAGuardarCmd.getNombre()).apellidos(personaAGuardarCmd.getApellidos())
                    .sexo(personaAGuardarCmd.getSexo()).fechaNacimiento(personaAGuardarCmd.getFechaNacimiento()).build();
    }
}
