package SolutionSpace.Benchmarks;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class Levy extends SolutionSpace
{
	
	public Levy()
	{
		setName("Levy");
		setLowerBound(-10);
		setHigherBound(10);
		double[] components = {1,1};
		setGlobalMinimum(new Vector(components));
	}

	@Override
	public double Function(Vector v) 
	{	
		double[] w = null;
		double summation = 0;
		for(int i = 0; i < v.getComponents().length; i++)
		{
			w[i] = 1 + ( v.getComponents()[i] - 1 ) / 4;
		}
		
		for(int i = 0; i < v.getComponents().length - 1; i++)
		{
			double sum = (Math.pow( ( w[i] - 1 ), 2 ) * ( 1 + 10 * (Math.pow ( Math.sin( Math.PI * w[i] + 1 ), 2))));
			summation = summation + sum;
		}
		
		return (summation + ( Math.pow( ( Math.sin( Math.PI * w[0] ) ), 2) ) + 
			   ( Math.pow ( w[v.getComponents().length] - 1 , 2 ) * (1 + ( Math.pow(Math.sin( 2 * Math.PI * w[v.getComponents().length] ) , 2 ) ) ) ) );
	}
}
