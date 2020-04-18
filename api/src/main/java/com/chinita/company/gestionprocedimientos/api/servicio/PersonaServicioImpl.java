package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.dto.PersonaDto;
import com.chinita.company.gestionprocedimientos.api.modelo.Persona;
import com.chinita.company.gestionprocedimientos.api.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServicioImpl implements PersonaServicio{

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonaServicioImpl.class);

    private ModelMapper modelMapper;

    private PersonaRepository personaRepository;

    public PersonaServicioImpl(PersonaRepository personaRepository, ModelMapper modelMapper) {
        this.personaRepository = personaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PersonaDto> consultarTodas() {
        List<Persona> listaPersonas = (List<Persona>) personaRepository.findAll();
        return listaPersonas.stream()
                .map(persona -> modelMapper.map(persona, PersonaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonaDto crear(PersonaDto personaACrearDto){
        LOGGER.debug("Comienza a crear: personaACrearDto={}", personaACrearDto);

        Persona personaACrear = new Persona();
        personaACrear.setTipoDocumento(personaACrearDto.getTipoDocumento());
        personaACrear.setDocumento(personaACrearDto.getDocumento());
        personaACrear.setNombre(personaACrearDto.getNombre());
        personaACrear.setApellidos(personaACrearDto.getApellidos());
        personaACrear.setSexo(personaACrearDto.getSexo());
        personaACrear.setFechaNacimiento(personaACrearDto.getFechaNacimiento());

        Persona personaCreada = personaRepository.save(personaACrear);
        PersonaDto personaCreadaDto = new PersonaDto();
        personaCreadaDto.setRowId(personaCreada.getRowId());
        personaCreadaDto.setTipoDocumento(personaCreada.getTipoDocumento());
        personaCreadaDto.setDocumento(personaCreada.getDocumento());
        personaCreadaDto.setNombre(personaCreada.getNombre());
        personaCreadaDto.setApellidos(personaCreada.getApellidos());
        personaCreadaDto.setSexo(personaCreada.getSexo());
        personaCreadaDto.setFechaNacimiento(personaCreada.getFechaNacimiento());

        return personaCreadaDto;
    }
}
