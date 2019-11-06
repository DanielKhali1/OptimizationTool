package Optimization;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public abstract class Optimizer 
{
	private String Algorithm;
	Vector[] population;
	SolutionSpace solutionSpace;
	
	public Optimizer(int populationSize)
	{
		this.setAlgorithm(Algorithm);
	}
	
	public void setSolutionSpace(SolutionSpace s)
	{
		solutionSpace = s;
	}

	public void randPop(int size)
	{
		double[] components = new double[ (int) solutionSpace.getDimensions()];
		
		population = new Vector[size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < components.length; j++)
			{
				components[j] = ( Math.random() * Math.abs(solutionSpace.getLowerBound() - solutionSpace.getHigherBound()) + solutionSpace.getLowerBound());
			}
			population[i] = new Vector(components);
		}
		
	}
	
	public void printPopulation()
	{
		for(Vector v : population)
		{
			System.out.println(v);
		}
	}
	
	
	
	public String getAlgorithm() {
		return Algorithm;
	}

	public void setAlgorithm(String algorithm) {
		Algorithm = algorithm;
	}
	
}
