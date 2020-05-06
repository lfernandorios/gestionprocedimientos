package com.chinita.company.gestionprocedimientos.api.modelo;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table (name="Persona")
@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Builder (toBuilder = true)
public class Persona implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long rowId;

    @NotNull
    @Column
    private String tipoDocumento;

    @NotNull
    @Column
    private String documento;

    @NotNull
    @Column
    private String nombre;

    @NotNull
    @Column
    private String apellidos;

    @NotNull
    @Column
    private String sexo;

    @NotNull
    @Column
    private LocalDateTime fechaNacimiento;
/*
    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

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
    }*/
}
