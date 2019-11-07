package Optimization.GA.CrossoverMethod;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class BLX implements Crossover
{

	@Override
	public Vector crossover(Vector parent1, Vector parent2, SolutionSpace s) 
	{
		double[] components = new double[parent1.getComponents().length];
		Vector child = new Vector(components);
		double alpha = 0.1;
		
		for(int i = 0; i < parent1.getComponents().length; i++)
		{
			//minimum x - alpha ( y - x ) 
			//maximum y + alpoha( y - x )
			double min = Math.min(parent1.getComponents()[i], parent2.getComponents()[i]);
			double max = Math.max(parent1.getComponents()[i], parent2.getComponents()[i]);
			
			double lowEnd = min - alpha * (max - min);
			double highEnd = max + alpha * (max - min);
			
			double x = (Math.random() * ((highEnd - lowEnd) + 1)) + lowEnd;
			child.getComponents()[i] = x;
		}
		
		return child;
		
	}

}