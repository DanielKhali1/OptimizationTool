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
		return ( - ( 1 + Math.cos ( 12 * Math.sqrt ( Math.pow(v.getComponents()[0], 2) + Math.pow( v.getComponents()[1], 2 ) ) ) ) ) / 
			   ( 0.5 * ( Math.pow(v.getComponents()[0], 2 ) + Math.pow(v.getComponents()[1], 2 ) ) + 2 );
	}
}
