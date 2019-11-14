package Optimization;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public abstract class Optimizer 
{
	private String Algorithm;
	protected Vector[] population;
	protected SolutionSpace solutionSpace;
	private int populationSize;
	protected int currentIteration;
	
	
	
	
	public Optimizer(int populationSize)
	{
		this.setAlgorithm(Algorithm);
		this.setPopulationSize(populationSize);
		this.setCurrentIteration(0);
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
	public abstract void reset();
	public abstract void setup();
	
	public void printPopulation()
	{
		for(Vector v : population)
		{
			System.out.println(v);
		}
	}
	
	public Vector bestSolution()
	{
		Vector bestSolution = population[0];
		
		for(int i = 1; i < population.length; i++)
		{
			if(solutionSpace.Function(bestSolution) > solutionSpace.Function(population[i]))
			{
				bestSolution = population[i];
			}
		}
		
		return bestSolution;
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
	
	public SolutionSpace getSolutionSpace() {
		return solutionSpace;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public int getCurrentIteration() {
		return currentIteration;
	}

	public void setCurrentIteration(int currentIteration) {
		this.currentIteration = currentIteration;
	}
	
}
