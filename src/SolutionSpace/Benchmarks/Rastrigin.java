package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Rastrigin extends SolutionSpace
{
	
	public Rastrigin(int dimensions)
	{
		setName("Rastrigin");
		setLowerBound(-5.12);
		setHigherBound(5.12);
		double[] components = {0,0};
		setGlobalMinimum(new Vector(components));
		setDimensions(dimensions);
	}
	
	
	@Override
	public double Function(Vector v) 
	{
		double sum = 0;
		
		for(int i = 0; i < v.getComponents().length; i++)
		{
			sum = sum + ( Math.pow ( v.getComponents()[i] , 2 ) - 10 * Math.cos( 2 * Math.PI * v.getComponents()[i] ) );
		}
		return (10 * v.getComponents().length + sum);
	}

}
