package com.chinita.company.gestionprocedimientos.api.controlador;


import com.chinita.company.gestionprocedimientos.api.servicio.PersonaServicio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<List<Persona>> getPerosonas(){
        return ResponseEntity.ok(personasServicio.getPersonas());
    }

    @PostMapping("")
    public ResponseEntity<Persona> addPersona(Persona persona){
        return ResponseEntity.ok(personaServicio.addPersona(persona));
    }
}
