/*
 * Copyright (c) 2022 mafer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    mafer - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.arqsoftware.pruebamongo.controller;

import ec.edu.espe.arqsoftware.pruebamongo.dto.EstudianteRQ;
import ec.edu.espe.arqsoftware.pruebamongo.model.Estudiante;
import ec.edu.espe.arqsoftware.pruebamongo.service.EstudianteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mafer
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/estudiante")
public class EstudianteController {
    
    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }
    
    @ApiOperation(value = "Crear un estudiante",
            notes = "Inserción de un estudiante")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK. El estudiante se ha guardado correctamente"),
        @ApiResponse(code = 400, message = "Bad Request. No se pudo guardar el estudiante"),
        @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping
    public ResponseEntity crearEstudiante(@RequestBody EstudianteRQ request){
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(request.getNombre());
            estudiante.setCorreoElectronico(request.getCorreoElectronico());
            estudiante.setPais(request.getPais());
            estudiante.setFechaNacimiento(request.getFechaNacimiento());
            this.service.crearEstudiante(estudiante);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            log.error("Se produjo un error al crear el usuario {} ", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
}
