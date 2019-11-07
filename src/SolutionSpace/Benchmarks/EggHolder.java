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
		double term1 = -(v.getComponents()[1] + 47 ) * Math.sin(Math.sqrt(Math.abs(v.getComponents()[1] + v.getComponents()[0] / 2 + 47) ) );
		double term2 = -v.getComponents()[0] * Math.sin(Math.sqrt(Math.abs(v.getComponents()[0] - (v.getComponents()[1] + 47))));
		
		return (term1 + term2);
	}
	

}
