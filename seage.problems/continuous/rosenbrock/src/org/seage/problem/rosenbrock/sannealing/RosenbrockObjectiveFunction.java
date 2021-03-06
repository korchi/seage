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

package org.seage.problem.rosenbrock.sannealing;

import org.seage.metaheuristic.sannealing.IObjectiveFunction;
import org.seage.metaheuristic.sannealing.Solution;

/**
 *
 * @author Jan Zmatlik
 */
public class RosenbrockObjectiveFunction implements IObjectiveFunction
{
    // f(X) = SUM(to N-1, i = 0) [(1 - Xi)^2 + 100 * (Xi+1 - Xi^2)^2]
    public void setObjectiveValue(Solution solution)
    {
        double[] coords = ((RosenbrockSolution)solution).getCoords();
        double value = 0.0;
        for(int i = 0; i < coords.length - 1; i++)
        {
            value += (Math.pow(1 - coords[i], 2) + 100 * Math.pow( coords[i + 1] - Math.pow( coords[i], 2 ) , 2 ) );
        }
        solution.setObjectiveValue( value );
    }
}
