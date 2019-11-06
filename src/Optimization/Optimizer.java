package Optimization;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public abstract class Optimizer 
{
	private String Algorithm;
	Vector[] population;
	SolutionSpace solutionSpace;
	private int populationSize;
	
	public Optimizer(int populationSize)
	{
		this.setAlgorithm(Algorithm);
		this.setPopulationSize(populationSize);
	}
	
	public void setSolutionSpace(SolutionSpace s)
	{
		solutionSpace = s;
	}

	public void randPop(int size)
	{
		double[] components;
		
		population = new Vector[size];
		for(int i = 0; i < size; i++)
		{
			components = new double[(int) solutionSpace.getDimensions()];
			for(int j = 0; j < components.length; j++)
			{
				components[j] = ( Math.random() * Math.abs(solutionSpace.getLowerBound() - solutionSpace.getHigherBound()) + solutionSpace.getLowerBound());
			}
			population[i] = new Vector(components);
		}
		
	}
	
	public abstract void nextEpoch();
	
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

	public Vector[] getPopulation() {
		return this.population;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}
	
}
