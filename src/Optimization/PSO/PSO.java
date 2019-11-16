package Optimization.PSO;

import Optimization.Optimizer;
import Util.Vector;

public class PSO extends Optimizer
{
	private double sc;
	private double cc;
	private double inertia;
	
	Particle[] particles;
	Vector globalBest;

	public PSO(int populationSize, double inertia, double sc, double cc) 
	{
		super(populationSize);
		//initialize each particle		
		particles = new Particle[populationSize];
		this.sc = sc;
		this.cc = cc;
	}
	

	@Override
	public void setup() 
	{
		globalBest = population[0];
		for(int i = 0; i < particles.length; i++)
		{
			//initializing particles
			particles[i] = new Particle(population[i].clone());
			//intitializing particles random velocity within the solution space bounds
			particles[i].setRandomVelocity(solutionSpace.getLowerBound(), solutionSpace.getHigherBound());
			
			//setting the global best of the population 
			if(solutionSpace.Function(particles[i].getPosition()) < solutionSpace.Function(globalBest))
			{
				globalBest = particles[i].getPosition().clone();
			}
		}
	}
	
	@Override
	public void nextEpoch() 
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
			
			//update gbest
			if(solutionSpace.Function(particle.getPosition()) < solutionSpace.Function(globalBest))
			{
				globalBest = particle.getPosition().clone();
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
		
	}

	@Override
	public void reset() 
	{
		randPop(particles.length);
		globalBest = population[0];
		for(int i = 0; i < particles.length; i++)
		{
			//initializing particles
			particles[i] = new Particle(population[i].clone());
			//intitializing particles random velocity within the solution space bounds
			particles[i].setRandomVelocity(solutionSpace.getLowerBound(), solutionSpace.getHigherBound());
			
			//setting the global best of the population 
			if(solutionSpace.Function(particles[i].getPosition()) < solutionSpace.Function(globalBest))
			{
				globalBest = particles[i].getPosition().clone();
			}
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
