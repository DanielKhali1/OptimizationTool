package Optimization.GA.SelectionMethod;


import SolutionSpace.SolutionSpace;
import Util.Vector;

public class DeepTournament implements Selection
{
	@Override
	public Vector SelectParent(Vector[] population, SolutionSpace ss) 
	{
		Vector fighter1 = population[(int)(Math.random() * population.length)];
		Vector fighter2 = population[(int)(Math.random() * population.length)];
		
		Vector champion1 = (ss.Function(fighter1) < ss.Function(fighter2) ) ? fighter1 : fighter2;
		
		Vector fighter3 = population[(int)(Math.random() * population.length)];
		Vector fighter4 = population[(int)(Math.random() * population.length)];
		
		Vector champion2 = (ss.Function(fighter3) < ss.Function(fighter4) ) ? fighter3 : fighter4;

		return (ss.Function(champion1) < ss.Function(champion2) ) ? champion1 : champion2;

	}
	
	

}
