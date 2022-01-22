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

import ec.edu.espe.arqsoftware.pruebamongo.dao.InscripcionRepository;
import ec.edu.espe.arqsoftware.pruebamongo.model.InscripcionCurso;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class InscripcionService {
    
    private final InscripcionRepository inscripcionRepo;

    public InscripcionService(InscripcionRepository inscripcionRepo) {
        this.inscripcionRepo = inscripcionRepo;
    }
    
    @Transactional
    public void crearInscripcion(InscripcionCurso inscripcion){
        
    }
}
