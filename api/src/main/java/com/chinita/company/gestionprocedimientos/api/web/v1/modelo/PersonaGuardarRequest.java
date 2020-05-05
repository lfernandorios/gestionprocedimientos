package com.chinita.company.gestionprocedimientos.api.web.v1.modelo;

import com.chinita.company.gestionprocedimientos.api.servicio.modelo.PersonaGuardarCmd;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
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

    public static PersonaGuardarCmd toModel(PersonaGuardarRequest personaACrear) {
        return PersonaGuardarCmd.builder().tipoDocumento(personaACrear.getTipoDocumento()).documento(personaACrear.getDocumento())
                .nombre(personaACrear.getNombre()).apellidos(personaACrear.getApellidos()).
                        sexo(personaACrear.getSexo()).fechaNacimiento(personaACrear.getFechaNacimiento()).build();
    }

}
