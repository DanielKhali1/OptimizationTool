package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class HolderTable extends SolutionSpace
{
	
	public HolderTable()
	{
		setName("HolderTable");
		setLowerBound(-10);
		setHigherBound(10);
		double[] components = {0,0};
		setGlobalMinimum(new Vector(components));
		setDimensions(2);
	}
	
	
	@Override
	public double Function(Vector v) 
	{
		double x1 = v.getComponents()[0];
		double x2 = v.getComponents()[1];
		
		return -Math.abs(Math.sin(x1) * Math.cos(x2) * 
				Math.exp( Math.abs(1 - ((Math.sqrt(x1 * x1 + x2 * x2))/Math.PI))));
	}
}
