package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Ackley extends SolutionSpace
{
	
	public Ackley()
	{
		setDimensions(2);
		setName("Ackleys");
		setLowerBound(-32.768);
		setHigherBound(32.768);
		double[] components = {0,0};
		setGlobalMinimum(new Vector(components));
	}
	
	
	@Override
	public double Function(Vector v) 
	{	
		//Doesn't work
		return ( -20 * Math.exp( -0.2 * Math.sqrt( 0.5 * ( ( v.getComponents()[0] * v.getComponents()[0] ) + ( v.getComponents()[1] * v.getComponents()[1] ) ) ) ) )
				- (Math.exp( 0.5* ( Math.cos( 2 * Math.PI * v.getComponents()[0] ) + Math.cos( 2 * Math.PI * v.getComponents()[1] ) ) ) )
				+ Math.E + 20;
	}

}
