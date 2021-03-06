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
package org.seage.metaheuristic.particles;

/**
 * @author Jan Zmatlik
 */
public interface IParticleSwarm {
        long getMaximalIterationCount();
        void setMaximalIterationCount(long maximalIterationCount);

        double getMaximalVelocity();
        void setMaximalVelocity(double maximalVelocity);
        double getMinimalVelocity();
        void setMinimalVelocity(double minimalVelocity);

        void startSearching(Particle[] particles);
        void stopSearching();

        Particle getBestParticle();
        public Particle[] getParticles();
        public void setParticles(Particle[] particles);
}
