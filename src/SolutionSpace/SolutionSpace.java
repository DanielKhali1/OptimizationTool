package SolutionSpace;

import Util.Vector;

public abstract class SolutionSpace 
{
	/**
	 * <h2> Solution Space Constructor </h2>
	 * 
	 * 
	 */
	private double lowerBound;
	private double higherBound;
	private double globalMinimum;
	
	
	/**
	 * <p> input any number of x's for a given function </p>
	 * <p> will return the solution at the given parameter </p>
	 * 
	 * @param x
	 * @return the solution at the given function
	 */
	public abstract double Function(Vector x);

	
	public double getGlobalMinimum() { return globalMinimum; }
	public double getLowerBound() { return lowerBound; }
	public double getHigherBound() { return higherBound; }
	
	public void setGlobalMinimum(double globalMinimum) { this.globalMinimum = globalMinimum; }
	public void setHigherBound(double higherBound) { this.higherBound = higherBound; }
	public void setLowerBound(double lowerBound) { this.lowerBound = lowerBound; }
	
	

}
