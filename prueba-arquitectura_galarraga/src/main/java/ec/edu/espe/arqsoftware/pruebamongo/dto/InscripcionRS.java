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
package ec.edu.espe.arqsoftware.pruebamongo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InscripcionRS {
    
    private String nombreEstudiante;
    
    private String nombreCurso;
    
    private Integer duracionCurso;
}
