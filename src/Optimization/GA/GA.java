package Optimization.GA;

import Optimization.Optimizer;

public class GA extends Optimizer
{
	double mutationRate;
	
	public GA(int population, double mutationRate)
	{
		super(population);
		this.mutationRate = mutationRate;
	}

}
