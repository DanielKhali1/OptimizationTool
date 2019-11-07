package Optimization.GA.SelectionMethod;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Tournament extends Selection
{

	@Override
	public Vector SelectParent(Vector[] population, SolutionSpace ss) 
	{
		Vector fighter1 = population[(int)(Math.random() * population.length)];
		Vector fighter2 = population[(int)(Math.random() * population.length)];
		
		return (ss.Function(fighter1) < ss.Function(fighter2) ) ? fighter1 : fighter2;
	}
	
	

}
