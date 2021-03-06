/*******************************************************************************
 * Copyright (c) 2009 Richard Malek and SEAGE contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://seage.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Martin Zaloga
 *     - Initial implementation
 */
package org.seage.problem.sat.grasp;

/**
 *
 * @author Martin Zaloga
 */
public class SatTestSolution extends SatSolution {

    public SatTestSolution(int countLiterals) {
        super();
        initTestSol(countLiterals);
    }

    private void initTestSol(int countLiterals) {
        _litValues = new boolean[countLiterals];
        for (int i = 0; i < countLiterals; i++) {
            _litValues[i] = true;
        }
    }
}
