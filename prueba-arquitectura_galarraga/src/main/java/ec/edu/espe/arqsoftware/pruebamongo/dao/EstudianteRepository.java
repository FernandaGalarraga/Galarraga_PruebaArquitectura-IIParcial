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
package ec.edu.espe.arqsoftware.pruebamongo.dao;

import ec.edu.espe.arqsoftware.pruebamongo.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EstudianteRepository extends MongoRepository<Estudiante, String>{
    Estudiante findByCorreoElectronico(String correo);
}
