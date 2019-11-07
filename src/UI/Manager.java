package UI;

import Experiment.TestCase;
import Optimization.Optimizer;
import Optimization.GA.GA;
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
//		SolutionSpace dropwave = new DropWave();
//		Optimizer ga = new GA(200, 0.01, new DeepTournament(), new BLX());
//		int iteration = 200;
//		
//		TestCase test = new TestCase(iteration, dropwave, ga);
//		test.run(false, true, false);
		
		SolutionSpace ackleys = new Levy(2);
		System.out.println(ackleys.Function(new Vector(1, 1)));

		
		
	}

}
