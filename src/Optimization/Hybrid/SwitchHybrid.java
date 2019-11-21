package Optimization.Hybrid;

import Optimization.Optimizer;
import Optimization.GA.CrossoverMethod.BLX;
import Optimization.GA.CrossoverMethod.Crossover;
import Optimization.GA.SelectionMethod.DeepTournament;
import Optimization.GA.SelectionMethod.Selection;
import Optimization.PSO.Particle;
import Util.Vector;

public class SwitchHybrid extends Optimizer
{
	Particle[] particles;
	boolean GAfirst;
	Vector globalBest;
	Selection selection = new DeepTournament();
	Crossover crossover = new BLX();
	double mutationRate;
	double inertia;
	double cc;
	double sc;
	
	double iterationSwitchRatio;
	
	
	public SwitchHybrid(int populationSize, double iterationSwitchRatio, boolean GAfirst, double mutationRate, double inertia, double cc, double sc)
	{
		super(populationSize);
		
		particles = new Particle[populationSize];
		this.GAfirst = GAfirst;
		this.mutationRate = mutationRate;
		this.inertia = inertia;
		this.cc = cc;
		this.sc = sc;
		this.iterationSwitchRatio = iterationSwitchRatio;
	}
	
	public void evolve()
	{
		for(int i = population.length; i < population.length; i++)
		{
			Vector parent1 = selection.SelectParent(population, solutionSpace);
			Vector parent2 = selection.SelectParent(population, solutionSpace);
			
			Vector child = crossover.crossover(parent1, parent2, solutionSpace);
			mutate(child);
			
			population[i] = child;
		}
	}
	
	public void updateVelocities()
	{
		for(Particle particle : particles)
		{
			
			// - update the velocity - \\
			particle.getVelocity().mult(inertia);
			
			// p1 = cc * rand() * (pbest[] - position[]) 
			Vector pbestVector = particle.getPersonalBest().clone();
			pbestVector.sub(particle.getPosition().clone());
			pbestVector.mult(Math.random() * cc);
			
			// p2 = sc * rand() * (globalBest[] - position[])
			Vector gbestVector = globalBest.clone();
			gbestVector.sub(particle.getPosition().clone());
			gbestVector.mult(sc * Math.random());
			
			// velocity += p1 + p2
			particle.getVelocity().add(gbestVector);
			particle.getVelocity().add(pbestVector);
			
			
			// update position
			particle.getPosition().add(particle.getVelocity().clone());
			
			for(int i = 0; i < particle.getPosition().getComponents().length; i++)
			{
				if(particle.getPosition().getComponents()[i] > solutionSpace.getHigherBound())
				{
					particle.getPosition().getComponents()[i] = solutionSpace.getHigherBound();
				}
				else if(particle.getPosition().getComponents()[i] < solutionSpace.getLowerBound())
				{
					particle.getPosition().getComponents()[i] = solutionSpace.getLowerBound();
				}
			}

			
			//update pbest
			if(solutionSpace.Function(particle.getPosition()) < solutionSpace.Function(particle.getPersonalBest()))
			{
				particle.setPersonalBest(particle.getPosition().clone());
			}
			
			for(int i = 0; i < particles.length; i++)
			{
				population[i] = particles[i].getPosition().clone();
			}
		}
		
		for(int i = 0; i < population.length; i++)
		{
			//update gbest
			if(solutionSpace.Function(population[i]) < solutionSpace.Function(globalBest))
			{
				globalBest = population[i].clone();
			}
		}
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


	@Override
	public void nextEpoch()
	{
		
	}

	@Override
	public void reset() 
	{
		randPop(population.length);

		for(int i = 0; i < particles.length; i++)
		{
			//initializing particles
			particles[i] = new Particle(population[i].clone());
			//intitializing particles random velocity within the solution space bounds
			particles[i].setRandomVelocity(solutionSpace.getLowerBound(), solutionSpace.getHigherBound());
		}
		
		globalBest = population[0];
		
		for(int i = 0; i < population.length; i++)
		{
			//setting the global best of the population 
			if(solutionSpace.Function(population[i]) < solutionSpace.Function(globalBest))
			{
				globalBest = population[i].clone();
			}
		}
	}

	@Override
	public void setup() 
	{
		randPop(population.length);

		for(int i = 0; i < particles.length; i++)
		{
			//initializing particles
			particles[i] = new Particle(population[i].clone());
			//intitializing particles random velocity within the solution space bounds
			particles[i].setRandomVelocity(solutionSpace.getLowerBound(), solutionSpace.getHigherBound());
		}
		
		globalBest = population[0];
		
		for(int i = 0; i < population.length; i++)
		{
			//setting the global best of the population 
			if(solutionSpace.Function(population[i]) < solutionSpace.Function(globalBest))
			{
				globalBest = population[i].clone();
			}
		}
	}
	
}
