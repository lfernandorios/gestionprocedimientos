package com.chinita.company.gestionprocedimientos.api.web.v1;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import com.chinita.company.gestionprocedimientos.api.servicio.PersonaServicio;
import com.chinita.company.gestionprocedimientos.api.servicio.modelo.PersonaGuardarCmd;
import com.chinita.company.gestionprocedimientos.api.shared.model.ResponsePagination;
import com.chinita.company.gestionprocedimientos.api.web.v1.modelo.PersonaGuardarRequest;
import com.chinita.company.gestionprocedimientos.api.web.v1.modelo.PersonaGuardarResponse;
import com.chinita.company.gestionprocedimientos.api.web.v1.modelo.PersonaListaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping(path = "/api/v1/personas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonaControlador {

    private PersonaServicio personaServicio;

    public PersonaControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin(exposedHeaders = {HttpHeaders.LOCATION})
    public ResponseEntity<Void> crear(@Valid @NotNull @RequestBody PersonaGuardarRequest personaACrear) {

        PersonaGuardarCmd personaACrearCmd = PersonaGuardarRequest.toModel(personaACrear);

        Persona personaCreada = personaServicio.crear(personaACrearCmd);

        URI location = fromUriString("/api/v1/personas").path("/{id}")
                .buildAndExpand(personaCreada.getRowId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonaGuardarResponse> buscarPorId(@Valid @PathVariable("id") @NotNull Long id) {

        Persona personaEncontrada = personaServicio.buscarPorId(id);

        return ResponseEntity.ok(PersonaGuardarResponse.fromModel(personaEncontrada));
    }

    @GetMapping
    public ResponsePagination<PersonaListaResponse> buscarTodos(@PageableDefault(page = 0, size = 10,
                                                                         direction = Sort.Direction.DESC, sort = "rowId")
                                                           Pageable pageable) {

        Page<Persona> personasEcontradas = personaServicio.buscarTodos(pageable);
        List<PersonaListaResponse> personasEncontradasLista = personasEcontradas.getContent().stream().map(PersonaListaResponse::fromModel)
                .collect(Collectors.toList());

        return ResponsePagination.fromObject(personasEncontradasLista, personasEcontradas.getTotalElements(), personasEcontradas.getNumber(),
                personasEncontradasLista.size());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminar(@Valid @PathVariable("id") @NotNull Long id) {

        personaServicio.eliminar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonaGuardarResponse> actualizar(@Valid @PathVariable("id") @NotNull Long id,
                                                             @Valid @RequestBody @NotNull PersonaGuardarRequest personaAActualizar) {

        PersonaGuardarCmd personaAActualizarCmd = PersonaGuardarRequest.toModel(personaAActualizar);

        Persona personaActualizada = personaServicio.actualizar(id, personaAActualizarCmd);


        return ResponseEntity.ok(PersonaGuardarResponse.fromModel(personaActualizada));
    }
}