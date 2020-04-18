package com.chinita.company.gestionprocedimientos.api.controlador;


import com.chinita.company.gestionprocedimientos.api.servicio.PersonaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<List<Persona>> getPersonas(){
        return ResponseEntity.ok(personaServicio.getPersonas());
    }

    @PostMapping ("")
    public ResponseEntity<Persona> addPersona(Persona persona){
        return ResponseEntity.ok(personaServicio.addPersona(persona));
    }
}
