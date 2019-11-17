package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class EggHolder extends SolutionSpace 
{
	
	public EggHolder()
	{
		setName("EggHolder");
		setLowerBound(-512);
		setHigherBound(512);
		setDimensions(2);
		double[] components = {512, 404.2319};
		setGlobalMinimum(new Vector(components));
	}
	
	
	@Override
	public double Function(Vector v) 
	{	
		
		
		double x1 = v.getComponents()[0];
		double x2 = v.getComponents()[1];
		
		return -(x2 + 47)* Math.sin(Math.abs(Math.sqrt(x2 + (x1/2) + 47))) - (x1 * Math.sin(Math.sqrt(Math.abs(x1 - (x2 + 47)))));
	}
	

}
