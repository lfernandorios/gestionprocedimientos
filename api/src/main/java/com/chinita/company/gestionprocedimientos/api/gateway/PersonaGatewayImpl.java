package com.chinita.company.gestionprocedimientos.api.gateway;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import com.chinita.company.gestionprocedimientos.api.repository.PersonaRepository;
import com.chinita.company.gestionprocedimientos.api.servicio.PersonaGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import javax.validation.constraints.NotNull;

public class PersonaGatewayImpl implements PersonaGateway {

    private static final String RESOURCE_NOT_FOUND = "Personas no encontrada";
    private PersonaRepository personaRepository;

    public PersonaGatewayImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public Persona crear(@NotNull Persona personaACrear) {

        final Persona personaASerCreada = personaACrear;

        final Persona personaCreada = personaRepository.save(personaASerCreada);

        return personaCreada;
    }

    @Override
    public Persona buscarPorId(@NotNull Long id) {

        Persona personaEncontrada = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND));

        return personaEncontrada;
    }

    @Override
    public Page<Persona> buscarTodos(@NotNull Pageable pageable) {

        Page<Persona> personasEncontradas = personaRepository.findAll(pageable);

        return personasEncontradas;
    }

    @Override
    public void eliminar(@NotNull Long id) {

        Persona personaAEliminar = buscarPorId(id);
        personaRepository.deleteById(personaAEliminar.getRowId());

    }


    @Override
    public Persona actualizar(@NotNull Persona personaAActualizar) {

        final Persona personaASerActualizada = personaAActualizar;

        final Persona personaActualizada = personaRepository.save(personaASerActualizada);

        return personaActualizada;
    }
}
