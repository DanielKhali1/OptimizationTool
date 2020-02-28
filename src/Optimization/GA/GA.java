package Optimization.GA;

import java.util.Arrays;

import Optimization.Optimizer;
import Optimization.GA.CrossoverMethod.Average;
import Optimization.GA.CrossoverMethod.BLX;
import Optimization.GA.CrossoverMethod.Crossover;
import Optimization.GA.SelectionMethod.DeepTournament;
import Optimization.GA.SelectionMethod.Selection;
import Util.Vector;

/**<p> Pure Genetic Algorithm Class </p>
 * <p> Child of Optimizer Class </p>
 * <p> allows differen't types of Selection, Crossover, and Modifiers </p>
 * 
 * @author Danny
 *
 */
public class GA extends Optimizer
{
	double mutationRate;
	Selection selection;
	Crossover crossover;
	
	private double ElitismRate;
	double GenitorRate;
	
	/**<p> constructs an instance of GA </p>
	 * <ul>
	 * <li>selection (default) : DeepTournament</li>
	 * <li>crossover (default) : BLX </li>
	 * </ul>
	 * 
	 * @param population
	 * @param mutationRate
	 */
	public GA(int population, double mutationRate)
	{
		super(population);
		this.mutationRate = mutationRate;
		selection = new DeepTournament();
		crossover = new BLX();
		ElitismRate = 0;
	}
	
	/**
	 * <p>constructs an instance of GA with a given selection method</p>
	 * <ul>
	 * <li>crossover (default) : BLX </li>
	 * </ul>
	 * @param population
	 * @param mutationRate
	 * @param s
	 */
	public GA(int population, double mutationRate, Selection s)
	{
		super(population);
		this.mutationRate = mutationRate;
		this.selection = s;
		crossover = new BLX();
		ElitismRate = 0;
	}
	
	/**
	 * <p> constructs an instance of GA with a given crossover method</p>
	 * <ul>
	 * <li>selection (default) : DeepTournament</li>
	 * </ul>
	 * @param population
	 * @param mutationRate
	 * @param c
	 */
	public GA(int population, double mutationRate, Crossover c)
	{
		super(population);
		this.mutationRate = mutationRate;
		this.selection = new DeepTournament();
		crossover = c;
		ElitismRate = 0;
	}
	
	/**
	 * <p> constructs an instance of GA with a given crossover method, and a given selection method</p>
	 * @param population
	 * @param mutationRate
	 * @param s
	 * @param c
	 */
	public GA(int population, double mutationRate, Selection s, Crossover c)
	{
		super(population);
		this.mutationRate = mutationRate;
		this.selection = s;
		crossover = c;
		ElitismRate = 0;
	}

	/**
	 * evolves the population
	 */
	@Override
	public void nextEpoch() 
	{
		evolve();
		currentIteration++;
	}
	
	
	/**
	 * <p>evolves the population based off of their scores in the given solution space</p>
	 * <ol>
	 * <li>selects 2 parent via a selection method</li>
	 * <li>crossover the 2 parent vectors via a crossover method</li>
	 * <li>mutate the child</li>
	 * <li>add the child to the new population</li>
	 * <li>repeat 1-4 until a new population has been formed</li>
	 * </ol>
	 */
	private void evolve()
	{
		Vector[] newPopulation = new Vector[population.length];
		
		for(int i = 0; i < (int)(ElitismRate*(population.length)); i++)
		{
			newPopulation[i] = bestSolution();
		}
		
		
		for(int i = (int)(ElitismRate*(population.length)); i < newPopulation.length; i++)
		{
			Vector parent1 = selection.SelectParent(population, solutionSpace);
			Vector parent2 = selection.SelectParent(population, solutionSpace);
			
			Vector child = crossover.crossover(parent1, parent2, solutionSpace);
			mutate(child);
			
			newPopulation[i] = child;
		}
		
		population = newPopulation;
		
	}
	
	/**
	 * <p> given a vector <b> child </b> and the set mutation rate mutate the vector </p>
	 * @param child
	 */
	private void mutate(Vector child)
	{
		for(int i = 0; i < child.getComponents().length; i++)
		{
			if(mutationRate > Math.random())
			{
				child.getComponents()[i] *= (Math.random() * 4)-2;
			}
		}
	}
	
	/***
	 * <p> sets a rate of elitism for evolution rate must be between 0 - 1 </p>
	 * @param rate
	 */
	public void setElitismRate(double rate)
	{
		ElitismRate = rate;
		
		if(ElitismRate > 1)
		{
			System.err.println("ELITISM RATE MUST BE BETWEEN 0-1");
		}
	}

	@Override
	public void reset() 
	{
		randPop(population.length);
		setCurrentIteration(0);
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}
	

}
