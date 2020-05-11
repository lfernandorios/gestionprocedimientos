package com.chinita.company.gestionprocedimientos.api.web.v1;

import com.chinita.company.gestionprocedimientos.api.modelo.Procedimiento;
import com.chinita.company.gestionprocedimientos.api.servicio.ProcedimientoServicio;
import com.chinita.company.gestionprocedimientos.api.servicio.modelo.ProcedimientoGuardarCmd;
import com.chinita.company.gestionprocedimientos.api.shared.model.ResponsePagination;
import com.chinita.company.gestionprocedimientos.api.web.v1.modelo.*;

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
@RequestMapping(path = "/api/v1/procedimientos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProcedimientoControlador {
    private ProcedimientoServicio procedimientoServicio;

    public ProcedimientoControlador(ProcedimientoServicio procedimientoServicio) {
        this.procedimientoServicio = procedimientoServicio;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin(exposedHeaders = {HttpHeaders.LOCATION})
    public ResponseEntity<Void> crear(@Valid @NotNull @RequestBody ProcedimientoGuardarRequest procedimientoACrear) {

        ProcedimientoGuardarCmd procedimientoACrearCmd = ProcedimientoGuardarRequest.toModel(procedimientoACrear);

        Procedimiento procedimientoCreado = procedimientoServicio.crear(procedimientoACrearCmd);

        URI location = fromUriString("/api/v1/procedimientos").path("/{id}")
                .buildAndExpand(procedimientoCreado.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProcedimientoGuardarResponse> buscarPorId(@Valid @PathVariable("id") @NotNull Long id) {

        Procedimiento procedimientoEncontrado = procedimientoServicio.buscarPorId(id);

        return ResponseEntity.ok(ProcedimientoGuardarResponse.fromModel(procedimientoEncontrado));
    }

    @GetMapping
    public ResponsePagination<ProcedimientoListaResponse> buscarTodos(@PageableDefault(page = 0, size = 10,
            direction = Sort.Direction.DESC, sort = "id")
                                                                         Pageable pageable) {

        Page<Procedimiento> procedimientosEcontrados = procedimientoServicio.buscarTodos(pageable);
        List<ProcedimientoListaResponse> procedimientosEncontradosLista = procedimientosEcontrados.getContent().stream().map(ProcedimientoListaResponse::fromModel)
                .collect(Collectors.toList());

        return ResponsePagination.fromObject(procedimientosEncontradosLista, procedimientosEcontrados.getTotalElements(), procedimientosEcontrados.getNumber(),
                procedimientosEncontradosLista.size());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminar(@Valid @PathVariable("id") @NotNull Long id) {

        procedimientoServicio.eliminar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProcedimientoGuardarResponse> actualizar(@Valid @PathVariable("id") @NotNull Long id,
                                                             @Valid @RequestBody @NotNull ProcedimientoGuardarRequest procedimientoAActualizar) {

        ProcedimientoGuardarCmd procedimientoAActualizarCmd = ProcedimientoGuardarRequest.toModel(procedimientoAActualizar);

        Procedimiento procedimientoActualizado = procedimientoServicio.actualizar(id, procedimientoAActualizarCmd);


        return ResponseEntity.ok(ProcedimientoGuardarResponse.fromModel(procedimientoActualizado));
    }
}
