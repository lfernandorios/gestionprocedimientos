package com.chinita.company.gestionprocedimientos.api.modelo;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="Procedimiento")
@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Procedimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column
    private String nombre;

    @NotNull
    @Column
    private String certificacion;

    @NotNull
    @Column
    private LocalDateTime vigencia;

    @NotNull
    @Column
    private String estado;

}
