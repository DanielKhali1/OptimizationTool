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
		setDimensions(2);
		//Global minimum = -19.2085
		double[] components = {8.05502,9.66459,8.05502,-9.66459,-8.05502,9.66459,-8.05502,-9.66459};
		setGlobalMinimum(new Vector (components));
	}
	
	
	@Override
	public double Function(Vector v) 
	{	
		
		//TODO : define HolderTable function
		
		return -Math.abs( ( Math.sin( v.getComponents()[0] ) * Math.cos( v.getComponents()[1]) * 
			   ( Math.exp( Math.abs( 1 - Math.sqrt( Math.pow(v.getComponents()[0], 2 ) + Math.pow(v.getComponents()[1], 2 ) / Math.PI) ) ) ) ) );
	}

}
