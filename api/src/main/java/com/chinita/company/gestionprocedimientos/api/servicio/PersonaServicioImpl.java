package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import com.chinita.company.gestionprocedimientos.api.servicio.modelo.PersonaGuardarCmd;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import org.springframework.transaction.annotation.Transactional;
import javax.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class PersonaServicioImpl implements PersonaServicio{

    private PersonaGateway personaGateway;

    public PersonaServicioImpl(PersonaGateway personaGateway) {
        this.personaGateway = personaGateway;
    }


    @Override
    public Persona crear(@NotNull PersonaGuardarCmd personaACrearCmd) {
        Persona personaAcrear = PersonaGuardarCmd.toModel(personaACrearCmd);
        Persona personaCreada = personaGateway.crear(personaAcrear);
        return personaCreada;
    }

    @Override
    @Transactional(readOnly = true)
    public Persona buscarPorId(@NotNull Long id) {
        Persona personaEncontrada = personaGateway.buscarPorId(id);
        return personaEncontrada;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Persona> buscarTodos(@NotNull Pageable pageable) {
        Page<Persona> personasEncontradas = personaGateway.buscarTodos(pageable);
        return personasEncontradas;
    }

    @Override
    public void eliminar(@NotNull Long id) {
        personaGateway.eliminar(id);
    }

    @Override
    public Persona actualizar(@NotNull Long id, @NotNull PersonaGuardarCmd personaAActualizarCmd) {

        Persona personaEnBaseDato = buscarPorId(id);

        personaEnBaseDato.setTipoDocumento(personaAActualizarCmd.getTipoDocumento());
        personaEnBaseDato.setDocumento(personaAActualizarCmd.getDocumento());
        personaEnBaseDato.setNombre(personaAActualizarCmd.getNombre());
        personaEnBaseDato.setApellidos(personaAActualizarCmd.getApellidos());
        personaEnBaseDato.setSexo(personaAActualizarCmd.getSexo());
        personaEnBaseDato.setFechaNacimiento(personaAActualizarCmd.getFechaNacimiento());

        Persona personaAActualizar = personaEnBaseDato;

        Persona personaActualizada = personaGateway.actualizar(personaAActualizar);

        return personaActualizada;
    }
}
