package com.chinita.company.gestionprocedimientos.api.controlador;


import com.chinita.company.gestionprocedimientos.api.servicio.PersonaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.chinita.company.gestionprocedimientos.api.modelo.Persona;

@RestController
@RequestMapping ("/personas")
public class PersonaControlador {

    private PersonaServicio personaServicio;

    public PersonaControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getPersonas(){
        return ResponseEntity.ok(personaServicio.getPersonas());
    }

    @PostMapping
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
        return ResponseEntity.ok(personaServicio.addPersona(persona));
        
    }
}
