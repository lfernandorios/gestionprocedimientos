package com.chinita.company.gestionprocedimientos.api.Controlador;


import com.chinita.company.gestionprocedimientos.api.Servicio.PersonaServicio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/personas")
public class PersonaControlador {

    private PersonaServicio personaServicio;

    public PersonaControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }
}
