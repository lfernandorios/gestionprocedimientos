package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import java.util.List;

public interface PersonaServicio {

    List<Persona> getPersonas();
    Persona addPersona(Persona persona);

}
