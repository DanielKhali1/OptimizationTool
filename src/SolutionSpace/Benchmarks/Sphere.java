package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Sphere extends SolutionSpace
{
	public Sphere()
	{
		setName("Sphere");
		setLowerBound(-5.12);
		setHigherBound(5.12);
		double[] components = {0,0};
		setGlobalMinimum(new Vector(components));
	}
	
	
	@Override
	public double Function(Vector v) 
	{	
		double sum = 0.0;
		for(int i = 0; i < v.getComponents().length; i++)
		{
			sum = sum + Math.pow ( v.getComponents()[i], 2 );
		}
		
		return sum;
	}

}
