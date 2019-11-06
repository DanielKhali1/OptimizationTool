package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Sphere extends SolutionSpace
{
	public Sphere()
	{
		//setDimensions(d);
		setName("Sphere");
		setLowerBound(-5.12);
		setHigherBound(5.12);
		double[] components = {0,0};
		setGlobalMinimum(new Vector(components));
	}
	
	
	@Override
	public double Function(Vector v) 
	{	
		
		//TODO : define Sphere function
		
		return 0.0;
	}

}
