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
import SolutionSpace.Benchmarks.HolderTable;
import SolutionSpace.Benchmarks.Levy;
import SolutionSpace.Benchmarks.Sphere;
import Util.Vector;

public class Manager 
{
	public static void main(String[] args) 
	{
		SolutionSpace sphere = new Sphere(10);
		Optimizer ga = new GA(500, 0.01, new DeepTournament(), new BLX());
		int iteration = 100;
		
		TestCase test = new TestCase(iteration, sphere, ga);
		test.run(false, true);
		
		
	}

}
