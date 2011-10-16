/*******************************************************************************
 * Copyright (c) 2009 Richard Malek and SEAGE contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://seage.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Richard Malek
 *     - Initial implementation
 */
package org.seage.aal.algorithm;

import org.seage.aal.data.ProblemConfig;
import org.seage.aal.data.ProblemInfo;
import org.seage.data.DataNode;

/**
 * Problem provider interface
 * @author Richard Malek
 */
public interface IProblemProvider
{
    // Returns meta-data on the problem to be solved
    // ProblemInfo
    //  |_ id
    //  |_ name
    //  |_ class
    //  |_ Algorithms
    //  |   |_ Algorithm
    //  |   |   |_ id
    //  |   |   |_ name
    //  |   |   |_ factoryClass
    //  |   |   |_ Parameter
    //  |   |   |   |_ name
    //  |   |   |   |_ max
    //  |   |   |   |_ min
    //  |   |   |   |_ init
    //  |   |   |_ ...
    //  |   |   |_ Parameter
    //  |   |_ Algorithm
    //  |       |_ ...
    //  |_ Instances
    //      |_ Instance
    //      |   |_ type ("file" | "resource")
    //      |   |_ path
    //      |_ ...
    //      |_ Instance
    ProblemInfo getProblemInfo() throws Exception;

    // Returns the algorithm factory
    IAlgorithmFactory getAlgorithmFactory(String algId) throws Exception;

    // Initializes (reads) a problem instance.
    ProblemInstance initProblemInstance(ProblemConfig params) throws Exception;

    //  Initializes an evaluator of solutions in phenotype representation
    // (i.e. in general representation of a problem solution).
    IPhenotypeEvaluator initPhenotypeEvaluator() throws Exception;

    // Generates the very first solution(s).
    // Solutions can be random, hungry, or other.
    Object[][] generateInitialSolutions(int numSolutions, ProblemInstance instance) throws Exception;

    // Visualizes solution, usually produces a picture.
    public void visualizeSolution(Object[] solution, ProblemInstance instance) throws Exception;
}