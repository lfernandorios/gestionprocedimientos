package com.chinita.company.gestionprocedimientos.api.servicio;

import com.chinita.company.gestionprocedimientos.api.dto.PersonaDto;

import java.util.List;

public interface PersonaServicio {

    List<PersonaDto> consultarTodas();
    PersonaDto crear(PersonaDto personaDto);

}
