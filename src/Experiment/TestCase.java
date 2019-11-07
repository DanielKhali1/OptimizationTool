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
	}
	
	public void run(boolean showInputs, boolean showSolution)
	{
		for(int i = 0; i < iterations; i++)
		{
			optimizer.nextEpoch();
			if(showInputs)
				System.out.print(optimizer.bestSolution() + " " );
			if(showSolution)
				System.out.println(optimizer.getSolutionSpace().Function(optimizer.bestSolution()) + " ");
		}
	}
	
	public void saveToFile(ArrayList<String> lines)
	{
		
	}
	
	

	public int getIterations() { return iterations; }
	public Optimizer getOptimizer() { return optimizer; }
	

	public void setIterations(int iterations) { this.iterations = iterations; }
	public void setOptimizer(Optimizer optimizer) { this.optimizer = optimizer; }

}
