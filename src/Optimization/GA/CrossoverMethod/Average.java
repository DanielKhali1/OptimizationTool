package Optimization.GA.CrossoverMethod;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Average implements Crossover
{

	@Override
	public Vector crossover(Vector parent1, Vector parent2, SolutionSpace s) 
	{
		Vector p1 = parent1.clone();
		Vector p2 = parent2.clone();
		
		p1.add(p2);
		p1.div(2);
		
		return p1;
	}

}
