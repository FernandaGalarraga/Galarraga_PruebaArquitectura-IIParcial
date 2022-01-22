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
package ec.edu.espe.arqsoftware.pruebamongo.service;

import ec.edu.espe.arqsoftware.pruebamongo.dao.CursoRepository;
import ec.edu.espe.arqsoftware.pruebamongo.exception.FoundException;
import ec.edu.espe.arqsoftware.pruebamongo.model.Curso;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CursoService {
    private final CursoRepository cursoRepo;

    public CursoService(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }
    
    public List<Curso> buscarPorAreaYNombre(String area, String nombre){
        Curso curso = new Curso();
        LocalDate fechaActual = LocalDate.now(ZoneId.of("America/New_York"));
        Period diff = Period.between(fechaActual, curso.getFechaInicio());
        if (fechaActual.isBefore(curso.getFechaInicio())) {
            if (diff.getMonths() <= 1) {
                return this.cursoRepo.findByAreaAndNombreLike(area, nombre);
            }else{
                throw new FoundException("La fecha de inicio de curso es lejana a la actual");
            }
        }else{
            throw new FoundException("Fechas inválidas, la fecha inicio es menor a la actual");
        }  
    }
}
