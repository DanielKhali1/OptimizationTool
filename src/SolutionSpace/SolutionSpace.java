package SolutionSpace;

import Util.Vector;

public abstract class SolutionSpace 
{
	/**
	 * <h2> Solution Space Constructor </h2>
	 * 
	 * 
	 */
	private String name;
	private double lowerBound;
	private double higherBound;
	private Vector globalMinimum;
	private int dimensions;
	
	
	/**
	 * <p> input any number of x's for a given function </p>
	 * <p> will return the solution at the given parameter </p>
	 * 
	 * @param x
	 * @return the solution at the given function
	 */
	public abstract double Function(Vector x);

	public Vector getGlobalMinimum() { return globalMinimum; }
	public double getLowerBound() { return lowerBound; }
	public double getHigherBound() { return higherBound; }
	public String getName() { return name; }
	public double getDimensions() {return dimensions;}
	
	public void setGlobalMinimum(Vector globalMinimum) { this.globalMinimum = globalMinimum; }
	public void setHigherBound(double higherBound) { this.higherBound = higherBound; }
	public void setLowerBound(double lowerBound) { this.lowerBound = lowerBound; }
	public void setName(String name) {this.name = name; }
	public void setDimensions(int dimensions) {this.dimensions = dimensions;}




	
	

}
