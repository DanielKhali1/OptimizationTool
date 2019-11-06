package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Rastrigin extends SolutionSpace
{
	
	public Rastrigin()
	{
		//setDimensions(d);
		setName("Rastrigin");
		setLowerBound(-5.12);
		setHigherBound(5.12);
		//Global Minimum = 0
		double[] components = {0,0};
		setGlobalMinimum(new Vector(components));
	}
	
	
	@Override
	public double Function(Vector v) 
	{
		double sum = 0;
		
		for(int i = 0; i < v.getComponents().length; i++)
		{
			
		}
		return 0.0;
	}

}
