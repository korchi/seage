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
 *     Richard Malek
 *     - Added algorithm annotations
 */
package org.seage.problem.tsp.sannealing;

import org.seage.aal.Annotations;
import org.seage.aal.algorithm.IAlgorithmAdapter;
import org.seage.aal.algorithm.IAlgorithmFactory;
import org.seage.aal.data.ProblemInstanceInfo;
import org.seage.aal.algorithm.sannealing.SimulatedAnnealingAdapter;
import org.seage.aal.data.ProblemConfig;
import org.seage.metaheuristic.sannealing.Solution;
import org.seage.problem.tsp.City;
import org.seage.problem.tsp.TspProblemInstance;
import org.seage.problem.tsp.TspProblemProvider;

/**
 *
 * @author Jan Zmatlik
 */
@Annotations.AlgorithmId("SimulatedAnnealing")
@Annotations.AlgorithmName("Simulated Annealing")
public class TspSimulatedAnnealingFactory implements IAlgorithmFactory
{
    private TspSolution _tspSolution;
    private TspProblemProvider _provider;

    public TspSimulatedAnnealingFactory()
    {
    }


//    public TspSimulatedAnnealingFactory(DataNode params, City[] cities) throws Exception
//    {
//        String solutionType = params.getValueStr("initSolutionType");
//        if( solutionType.toLowerCase().equals("greedy") )
//            _tspSolution = new TspGreedySolution( cities );
//        else if( solutionType.toLowerCase().equals("random") )
//            _tspSolution = new TspRandomSolution( cities );
//        else if( solutionType.toLowerCase().equals("sorted") )
//            _tspSolution = new TspSortedSolution( cities );
//    }


    public Class getAlgorithmClass() {
        return SimulatedAnnealingAdapter.class;
    }

    public IAlgorithmAdapter createAlgorithm(ProblemInstanceInfo instance, ProblemConfig config) throws Exception
    {
        IAlgorithmAdapter algorithm;
        final City[] cities = ((TspProblemInstance)instance).getCities();
        
        algorithm = new SimulatedAnnealingAdapter((Solution) _tspSolution,
                new TspObjectiveFunction(),
                new TspMoveManager(), false, "")
        {
            public void solutionsFromPhenotype(Object[][] source) throws Exception 
            {
                TspSolution initialSolution = new TspGreedySolution(cities);
                Integer[] tour = initialSolution.getTour();

                for(int i = 0; i < tour.length; i++)
                    tour[i] = (Integer)source[0][i];
                
                _initialSolution = initialSolution;
            }

            public Object[][] solutionsToPhenotype() throws Exception
            {
                Integer[] tour = ((TspSolution) _simulatedAnnealing.getBestSolution()).getTour();
                Object[][] source = new Object[1][ tour.length ];

                source[0] = new Integer[ tour.length ];
                for(int i = 0; i < tour.length; i++)
                    source[0][i] = tour[i];

                return source;
            }

        };

        return algorithm;
    }

}
