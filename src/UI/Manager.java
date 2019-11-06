package UI;

import Experiment.TestCase;
import Optimization.Optimizer;
import Optimization.GA.GA;
import SolutionSpace.SolutionSpace;
import SolutionSpace.Benchmarks.Ackley;

public class Manager 
{
	public static void main(String[] args) 
	{
		SolutionSpace ackley = new Ackley();
		Optimizer ga = new GA(50, 0.01);
		int iteration = 50;
		
		TestCase test = new TestCase(iteration, ackley, ga);
		
		
	}

}
