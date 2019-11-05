package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Ackley extends SolutionSpace
{

	
	public Ackley()
	{
		setName("Ackleys");
		setLowerBound(-32.768);
		setHigherBound(32.768);
		setGlobalMinimum(0);
	}
	
	
	@Override
	public double Function(Vector v) 
	{	
		
		return ( -20 * Math.exp( -0.2 * Math.sqrt( 0.5 * ( ( v.getComponents()[0] * v.getComponents()[0] ) + ( v.getComponents()[1] * v.getComponents()[1] ) ) ) ) )
				- (Math.exp( 0.5* ( Math.cos( 2 * Math.PI * v.getComponents()[0] ) + Math.cos( 2 * Math.PI * v.getComponents()[1] ) ) ) )
				+ Math.E + 20;
	}

}
