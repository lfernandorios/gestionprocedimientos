package com.chinita.company.gestionprocedimientos.api.controlador;

import com.chinita.company.gestionprocedimientos.api.dto.PersonaDto;
import com.chinita.company.gestionprocedimientos.api.servicio.PersonaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/personas")
public class PersonaControlador {

    private PersonaServicio personaServicio;

    public PersonaControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping
    public ResponseEntity<List<PersonaDto>> consultarTodas(){
        return ResponseEntity.ok(personaServicio.consultarTodas());
    }

    @PostMapping
    public ResponseEntity<PersonaDto> crear(@RequestBody PersonaDto personaDto){
        PersonaDto personaCreada = personaServicio.crear(personaDto);
        return new ResponseEntity<PersonaDto>(personaCreada, null, HttpStatus.CREATED);
    }
}