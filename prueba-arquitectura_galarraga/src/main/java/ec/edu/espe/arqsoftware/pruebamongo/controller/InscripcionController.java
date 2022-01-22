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

import ec.edu.espe.arqsoftware.pruebamongo.dto.InscripcionRQ;
import ec.edu.espe.arqsoftware.pruebamongo.model.InscripcionCurso;
import ec.edu.espe.arqsoftware.pruebamongo.service.InscripcionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/inscripcion")
public class InscripcionController {
    
    private final InscripcionService service;

    public InscripcionController(InscripcionService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity crearInscripcion(@RequestBody InscripcionRQ request){
        try{
            InscripcionCurso inscripcion = new InscripcionCurso();
            inscripcion.setNombre(request.getNombre());
            inscripcion.setCodigoCurso(request.getCodigoCurso());
            inscripcion.setCorreoEstudiante(request.getCorreo());
            this.service.crearInscripcion(inscripcion);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            log.error("Se produjo un error al crear el usuario {} ", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
