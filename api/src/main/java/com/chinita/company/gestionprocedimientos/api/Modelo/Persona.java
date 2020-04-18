package com.chinita.company.gestionprocedimientos.api.Modelo;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table (name="Persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

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
    private Date fechaNacimiento;

}
