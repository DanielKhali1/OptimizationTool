package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Easom extends SolutionSpace
{
	public Easom()
	{
		setName("EasomFunction");
		setLowerBound(-100);
		setHigherBound(100);
		double[] components = {Math.PI,Math.PI};
		setGlobalMinimum(new Vector(components));
		setDimensions(2);
	}

	@Override
	public double Function(Vector x) 
	{
		double x1 = x.getComponents()[0];
		double x2 = x.getComponents()[1];
		
		return -Math.cos(x1)*Math.cos(x2)*Math.exp(-Math.pow((x1 - Math.PI),2)-Math.pow(x2- Math.PI, 2));
	}
	

}
