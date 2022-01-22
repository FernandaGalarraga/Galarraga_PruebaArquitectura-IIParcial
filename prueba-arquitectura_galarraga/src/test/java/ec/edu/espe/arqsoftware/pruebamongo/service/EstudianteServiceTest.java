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

import ec.edu.espe.arqsoftware.pruebamongo.dao.EstudianteRepository;
import ec.edu.espe.arqsoftware.pruebamongo.exception.CreateException;
import ec.edu.espe.arqsoftware.pruebamongo.model.Estudiante;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {
    
    @Mock
    EstudianteRepository estudianteRepo;
    
    @InjectMocks
    EstudianteService service;
    Estudiante estudiante;
    Estudiante estudianteEj;
    
    @BeforeEach
    void setUp() {
        LocalDateTime fechaCreacion = LocalDateTime.now(ZoneId.of("America/New_York")).withNano(0);
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha = "2021-12-24";
        LocalDate fechaNacimiento = LocalDate.parse(fecha, sdf);
        estudiante = new Estudiante();
        estudiante.setCorreoElectronico("camilo@espe.edu.ec");
        estudiante.setFechaNacimiento(fechaNacimiento);
        estudiante.setNombre("Camilo Sanchez");
        estudiante.setPais("EC");
        estudiante.setFechaCreacion(fechaCreacion);
        
        String fechaN = "2022-12-24";
        LocalDate fechaNacimiento1 = LocalDate.parse(fechaN, sdf);
        estudianteEj = new Estudiante();
        estudianteEj.setCorreoElectronico("camilop@espe.edu.ec");
        estudianteEj.setFechaNacimiento(fechaNacimiento1);
        estudianteEj.setNombre("Camilo Perez");
        estudianteEj.setPais("EC");
        estudianteEj.setFechaCreacion(fechaCreacion);
    }
    
    @Test
    void crearEstudianteTest(){
        lenient().when(estudianteRepo.findByCorreoElectronico("camiloj@espe.edu.ec")).thenReturn(estudiante);
        when(estudianteRepo.save(estudiante)).thenReturn(estudiante);
        this.service.crearEstudiante(estudiante);
    }
    
    @Test
    void crearEstudianteTestException(){
        lenient().when(estudianteRepo.findByCorreoElectronico("camilop@espe.edu.ec")).thenReturn(estudianteEj);
        when(estudianteRepo.save(estudianteEj)).thenThrow(CreateException.class);
        Assertions.assertThrows(CreateException.class, () -> {
            this.service.crearEstudiante(estudiante);
        });
    }
}
