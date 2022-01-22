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

import ec.edu.espe.arqsoftware.pruebamongo.model.Curso;
import ec.edu.espe.arqsoftware.pruebamongo.service.CursoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/curso")
public class CursoController {
    
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }
    
    @ApiOperation(value = "Listar cursos",
            notes = "Obtener cursos por area y nombre")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK. Se encontraron cursos con los parametros dados"),
        @ApiResponse(code = 400, message = "Bad Request. No se encontro ningun curso"),
        @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping(value = "/{area}/{nombre}")
    public ResponseEntity listarCursosPorAreaYNombre(@PathVariable("area") String area, @PathVariable("nombre") String nombre) {
        try{
        List<Curso> cursos = this.service.buscarPorAreaYNombre(area, nombre);
        return ResponseEntity.ok(cursos);
        } catch(Exception e){
            log.error("Se produjo un error al obtener los cursos {} ", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
