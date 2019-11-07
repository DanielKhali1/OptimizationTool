package Optimization.GA.SelectionMethod;
import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Roulette implements Selection
{

	@Override
	public Vector SelectParent(Vector[] population, SolutionSpace ss) 
	{
		double[] fitness = new double[population.length];
		double sumOfFitnesses = 0;
		
		for(int i = 0; i < fitness.length; i++)
		{
			fitness[i] = ss.Function(population[i]);
			sumOfFitnesses += fitness[i];
		}
		
		for(int i = 0; i < fitness.length; i++)
		{
			fitness[i] /= sumOfFitnesses;
		}
		
		double wheelspin = Math.random();
		
		for(int i = 0; i < fitness.length; i++)
		{
			if(wheelspin >= fitness[i])
			{
				
			}
		}
		
		return null;
	}
	
	

}
