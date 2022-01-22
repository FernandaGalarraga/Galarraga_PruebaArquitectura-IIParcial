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

import ec.edu.espe.arqsoftware.pruebamongo.model.Curso;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CursoRepository extends MongoRepository<Curso, String> {
    List<Curso> findByAreaAndNombreLike(String area, String nombre);
    Curso findByCodigo(String codigo);
}
