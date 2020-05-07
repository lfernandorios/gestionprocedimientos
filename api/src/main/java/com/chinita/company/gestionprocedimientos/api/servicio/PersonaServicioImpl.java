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
        Persona personaAActualizar = personaEnBaseDato.toBuilder().tipoDocumento(personaAActualizarCmd.getTipoDocumento()).
                documento(personaAActualizarCmd.getDocumento()).nombre(personaAActualizarCmd.getNombre()).
                apellidos(personaAActualizarCmd.getApellidos()).sexo(personaAActualizarCmd.getSexo()).
                fechaNacimiento(personaAActualizarCmd.getFechaNacimiento()).build();

        Persona personaActualizada = personaGateway.actualizar(personaAActualizar);

        return personaActualizada;
    }
}
