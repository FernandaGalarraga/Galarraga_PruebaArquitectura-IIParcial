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
import ec.edu.espe.arqsoftware.pruebamongo.model.Curso;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {
    
    @Mock
    CursoRepository cursoRepo;
    
    @InjectMocks
    CursoService service;
    Curso curso;
    List<Curso> cursos;
    
    @BeforeEach
    void setUp() {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha = "2022-02-20";
        LocalDate fechaInicio = LocalDate.parse(fecha, sdf);
        curso = new Curso();
        curso.setArea("Idiomas");
        curso.setNombre("Ingles");
        curso.setFechaInicio(fechaInicio);
        
        cursos = new ArrayList<>();
        cursos.add(curso);
    }
    
    @Test
    void obtenerCursoTest(){
        when(cursoRepo.findByAreaAndNombreLike("Idiomas", "Ingles")).thenReturn(cursos);
        this.service.buscarPorAreaYNombre("Idiomas", "Ingles");
    }
}
