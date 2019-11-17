package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class DropWave extends SolutionSpace 
{
	public DropWave()
	{
		setName("DropWave");
		setLowerBound(-5.12);
		setHigherBound(5.12);
		setDimensions(2);
		double[] components = {0,0};
		setGlobalMinimum(new Vector(components));
	}
	
	@Override
	public double Function(Vector v)
	{
		double x1 = v.getComponents()[0];
		double x2 = v.getComponents()[1];
		
		
		return -(1 + Math.cos(12 * Math.sqrt(x1*x1 + x2*x2))) / (0.5 * (x1*x1 + x2*x2) + 2);
	}
}
