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

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Jan Zmatlik
 */
public class Particle implements Cloneable, Serializable{

    private double[] _coords;

    private double[] _velocity;

    private double _evaluation = Double.MAX_VALUE;

    public Particle(int dimension)
    {
        _coords = new double[ dimension ];
        _velocity = new double[ dimension ];
    }

    public double[] getCoords() {
        return _coords;
    }

    public void setCoords(double[] coords) {
        this._coords = coords;
    }

    public double getEvaluation() {
        return _evaluation;
    }

    public void setEvaluation(double evaluation) {
        this._evaluation = evaluation;
    }

    public double[] getVelocity() {
        return _velocity;
    }

    public void setVelocity(double[] velocity) {
        this._velocity = velocity;
    }

    @Override
    public  Particle clone()
    {
        try
        {
            Particle particle = (Particle)super.clone();
            particle._coords = _coords.clone();
            particle._velocity = _velocity.clone();
            particle._evaluation = _evaluation;
            return particle;
        }
        catch(CloneNotSupportedException e)
        {
            throw new InternalError( e.toString() );
        }
    }

    protected class CoordComparator implements Comparator<Integer>
    {
        double _coords[];
        public CoordComparator(double[] coords)
        {
            _coords = coords;
        }

        public int compare(Integer t, Integer t1)
        {
            if( _coords[t] >  _coords[t1])
                return 1;
            if( _coords[t] <  _coords[t1])
                return -1;

            return 0;
        }


    }
}
