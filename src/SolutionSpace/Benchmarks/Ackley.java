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
		double sum1 = 0.0;
		double sum2 = 0.0;
		for(int i = 0; i < v.getComponents().length; i++)
		{
			sum1 = sum1 + Math.pow ( v.getComponents()[i], 2 );
			sum2 = sum2 + Math.cos( 2 * Math.PI * v.getComponents()[i] );
		}
		double term1 = -20 * Math.exp ( -0.2 * Math.sqrt ( sum1 / v.getComponents().length ) );
		double term2 = -Math.exp ( sum2 / v.getComponents().length );
		
		return (term1 + term2 + 20 + Math.exp(1) );
	}

}
