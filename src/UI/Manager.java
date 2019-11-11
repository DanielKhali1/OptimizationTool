package UI;

import Experiment.TestCase;
import Optimization.Optimizer;
import Optimization.GA.GA;
import Optimization.GA.CrossoverMethod.Average;
import Optimization.GA.CrossoverMethod.BLX;
import Optimization.GA.SelectionMethod.DeepTournament;
import Optimization.GA.SelectionMethod.Tournament;
import SolutionSpace.SolutionSpace;
import SolutionSpace.Benchmarks.Ackley;
import SolutionSpace.Benchmarks.DropWave;
import SolutionSpace.Benchmarks.EggHolder;
import SolutionSpace.Benchmarks.Levy;
import SolutionSpace.Benchmarks.Rastrigin;
import SolutionSpace.Benchmarks.Sphere;
import Util.Vector;

public class Manager 
{
	public static void main(String[] args) 
	{
		SolutionSpace ackley = new Ackley(2);
		Optimizer ga = new GA(500, 0.01, new DeepTournament(), new BLX());
		((GA) ga).setElitismRate(0.2);
		int iteration = 50;
		
		System.out.println(ackley.getLowerBound() + " " + ackley.getHigherBound());
		
		TestCase test = new TestCase(iteration, ackley, ga);
		test.run(false, true, false);

		
		
	}

}
