package Experiment;

import Optimization.Optimizer;
import SolutionSpace.SolutionSpace;

public class TestCase 
{
	private int iterations;
	private SolutionSpace ss;
	private Optimizer optimizer;
	
	public TestCase(int iterations, SolutionSpace ss, Optimizer optimizer)
	{
		this.iterations = iterations;
		this.ss = ss;
		this.optimizer = optimizer;
	}

	public int getIterations() { return iterations; }
	public SolutionSpace getSs() { return ss; }
	public Optimizer getOptimizer() { return optimizer; }
	

	public void setIterations(int iterations) { this.iterations = iterations; }
	public void setSs(SolutionSpace ss) { this.ss = ss; }
	public void setOptimizer(Optimizer optimizer) { this.optimizer = optimizer; }

}
