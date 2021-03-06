/*******************************************************************************
 * Copyright (c) 2009 Richard Malek and SEAGE contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://seage.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Jan Zmatlik
 *     - Initial implementation
 */
package org.seage.problem.qap.particles;

import org.seage.metaheuristic.particles.IObjectiveFunction;
import org.seage.metaheuristic.particles.Particle;
import org.seage.problem.qap.AssignmentProvider;

/**
 *
 * @author Karel Durkota
 */
public class QapObjectiveFunction implements IObjectiveFunction
{
    private Double[][][] _facilityLocation;

    public QapObjectiveFunction(Double[][][] facilityLocation)
    {
        _facilityLocation = facilityLocation;
    }

    public void setObjectiveValue(Particle particle)
    {
        QapParticle currentParticle = ((QapParticle)particle);
        double price = 0.0;
        Integer[] assign = currentParticle.getAssign();

        try
        {
            price = (int)AssignmentProvider.getTotalPrice(assign, _facilityLocation);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
 
        particle.setEvaluation( price );
    }
}

