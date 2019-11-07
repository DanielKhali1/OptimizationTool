package Optimization.GA;

import Optimization.Optimizer;
import Optimization.GA.CrossoverMethod.Average;
import Optimization.GA.CrossoverMethod.BLX;
import Optimization.GA.CrossoverMethod.Crossover;
import Optimization.GA.SelectionMethod.DeepTournament;
import Optimization.GA.SelectionMethod.Selection;
import Util.Vector;

public class GA extends Optimizer
{
	double mutationRate;
	Selection selection;
	Crossover crossover;
	
	
	public GA(int population, double mutationRate)
	{
		super(population);
		this.mutationRate = mutationRate;
		selection = new DeepTournament();
		crossover = new BLX();
	}
	
	public GA(int population, double mutationRate, Selection s)
	{
		super(population);
		this.mutationRate = mutationRate;
		this.selection = s;
		crossover = new Average();
	}
	
	public GA(int population, double mutationRate, Crossover c)
	{
		super(population);
		this.mutationRate = mutationRate;
		this.selection = new DeepTournament();
		crossover = c;
	}
	
	public GA(int population, double mutationRate, Selection s, Crossover c)
	{
		super(population);
		this.mutationRate = mutationRate;
		this.selection = s;
		crossover = c;
	}

	@Override
	public void nextEpoch() 
	{
		evolve();
	}
	
	private void evolve()
	{
		Vector[] newPopulation = new Vector[population.length];
		
		for(int i = 0; i < newPopulation.length; i++)
		{
			Vector parent1 = selection.SelectParent(population, solutionSpace);
			Vector parent2 = selection.SelectParent(population, solutionSpace);
			
			Vector child = crossover.crossover(parent1, parent2, solutionSpace);
			mutate(child);
			
			newPopulation[i] = child;
		}
		
		population = newPopulation;
	}
	
	private void mutate(Vector child)
	{
		for(int i = 0; i < child.getComponents().length; i++)
		{
			if(mutationRate > Math.random())
			{
				child.getComponents()[i] *= (Math.random() * 2);
			}
		}
	}
	

}
