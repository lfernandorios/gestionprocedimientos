package com.chinita.company.gestionprocedimientos.api.Servicio;

import com.chinita.company.gestionprocedimientos.api.Repository.PersonaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicioImplementacion implements PersonaServicio{

    private PersonaRepository personaRepository;

    public PersonaServicioImplementacion(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
}
