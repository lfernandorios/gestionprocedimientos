package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import com.chinita.company.gestionprocedimientos.api.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicioImplementacion implements PersonaServicio{

    private PersonaRepository personaRepository;

    public PersonaServicioImplementacion(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona addPersona(Persona persona){
        return personaRepository.save(persona);
    }
}
