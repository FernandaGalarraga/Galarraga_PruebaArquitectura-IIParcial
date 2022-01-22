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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EstudianteService {
    private final EstudianteRepository estudianteRepo;

    public EstudianteService(EstudianteRepository estudianteRepo) {
        this.estudianteRepo = estudianteRepo;
    }
    
    public void crearEstudiante(Estudiante estudiante){
        LocalDateTime fechaActual = LocalDateTime.now(ZoneId.of("America/New_York"));
        if(this.encontrarPorCorreo(estudiante.getCorreoElectronico())==null){
            estudiante.setFechaCreacion(fechaActual);
            if (estudiante.getFechaNacimiento().isAfter(fechaActual.toLocalDate())) {
                log.error("Error en la fecha recibida: ",
                        estudiante.getFechaNacimiento());
                throw new RuntimeException("La fecha de nacimiento no puede ser mayor a la actual");
            }else{
                this.estudianteRepo.save(estudiante);
            }
            
        }else{
            throw new CreateException("El estudiante ingresado ya existe");
        }
    }
    
    public Estudiante encontrarPorCorreo(String correo){
        return this.estudianteRepo.findByCorreoElectronico(correo);
    }
}
