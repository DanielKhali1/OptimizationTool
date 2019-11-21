package Optimization.PSO;

import Util.Vector;

public class Particle 
{
	private Vector position;
	private Vector velocity;
	
	private Vector personalBest;
	
	public Particle(Vector solution)
	{
		setPosition(solution.clone());
		setPersonalBest(getPosition().clone());
	}
	
	public void setRandomVelocity(double lowerBound, double higherBound)
	{
		double[] comp = new double[getPosition().getComponents().length];
		
		for(int i = 0; i < comp.length; i++)
			comp[i] = ( Math.random() * (higherBound - lowerBound) ) + lowerBound;
		
		setVelocity(new Vector(comp));
	}

	
	
	
	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	public Vector getPersonalBest() {
		return personalBest;
	}

	public void setPersonalBest(Vector personalBest) {
		this.personalBest = personalBest;
	}
	

}
