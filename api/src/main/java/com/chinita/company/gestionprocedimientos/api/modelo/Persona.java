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

}
