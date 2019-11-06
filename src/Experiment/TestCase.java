package Experiment;

import java.util.ArrayList;

import Optimization.Optimizer;
import SolutionSpace.SolutionSpace;

public class TestCase 
{
	private int iterations;
	private Optimizer optimizer;
	
	public TestCase(int iterations, SolutionSpace ss, Optimizer optimizer)
	{
		this.iterations = iterations;
		this.optimizer = optimizer;
		this.optimizer.setSolutionSpace(ss);
		this.optimizer.randPop(optimizer.getPopulationSize());
		this.optimizer.printPopulation();
	}
	
	public void run()
	{
		
	}
	
	public void saveToFile(ArrayList<String> lines)
	{
		
	}

	public int getIterations() { return iterations; }
	public Optimizer getOptimizer() { return optimizer; }
	

	public void setIterations(int iterations) { this.iterations = iterations; }
	public void setOptimizer(Optimizer optimizer) { this.optimizer = optimizer; }

}
