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
		double[] w = new double[v.getComponents().length];
		
		for(int i = 0; i < v.getComponents().length; i++)
		{
			w[i] = 1 + (v.getComponents()[i] - 1) / 4;
		}
		double term1 = Math.pow((Math.sin(Math.PI * w[0])),2);
		double term2 = Math.pow ( ( w [ w.length - 1 ] - 1 ) , 2 ) * ( 1 + Math.pow ( Math.sin ( 2 * Math.PI * w [ w.length - 1 ] ) , 2 ) );
		
		double add = 0;
		double sum = 0;
		for(int i = 0; i < (w.length -1); i++)
		{
			add = ( Math.pow (v.getComponents()[i] - 1, 2) * ( 1 + 10 * ( Math.pow ( ( Math.sin ( Math.PI * v.getComponents()[i] + 1) ), 2 ) ) ) );
			sum = sum + add;
		}

		return (term1 + sum + term2);
	}
	
}
