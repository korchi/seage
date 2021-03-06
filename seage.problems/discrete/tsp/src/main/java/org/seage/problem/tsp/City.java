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
package org.seage.problem.tsp;

import java.io.Serializable;

/**
 *  @author Richard Malek
 */
public class City implements Serializable
{
	public int ID = 0;
	public double X = 0;
	public double Y = 0;

	public City(int id, Double x, Double y)
	{
		ID = id;
		X = x;
		Y = y;
	}
}
