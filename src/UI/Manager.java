package UI;

import Experiment.TestCase;
import Optimization.Optimizer;
import Optimization.GA.GA;
import Optimization.GA.CrossoverMethod.Average;
import Optimization.GA.CrossoverMethod.BLX;
import Optimization.GA.CrossoverMethod.RandomPoint;
import Optimization.GA.SelectionMethod.DeepTournament;
import Optimization.GA.SelectionMethod.Tournament;
import Optimization.Hybrid.TandemHybrid;
import Optimization.PSO.PSO;
import SolutionSpace.SolutionSpace;
import SolutionSpace.Benchmarks.Ackley;
import SolutionSpace.Benchmarks.DropWave;
import SolutionSpace.Benchmarks.Easom;
import SolutionSpace.Benchmarks.EggHolder;
import SolutionSpace.Benchmarks.Levy;
import SolutionSpace.Benchmarks.Rastrigin;
import SolutionSpace.Benchmarks.Sphere;
import Util.Vector;

public class Manager 
{
	public static void main(String[] args) 
	{
		SolutionSpace ss = new Rastrigin(3);
		Optimizer pso = new PSO(50, 0.3, 2, 2);
		
		System.out.println("GLOBAL MINIMUM " + ss.Function(ss.getGlobalMinimum()));
		
		Optimizer ga = new GA(50, 0.01, new DeepTournament(), new BLX());
		
		Optimizer tandem = new TandemHybrid(50, 0.9, 2, 2, 0.01, 0.2);
		
		GA oldfashionedGA = new GA(50, 0.01, new DeepTournament(), new RandomPoint());

		
		int iteration = 20;
		
		TestCase test = new TestCase(iteration, ss, oldfashionedGA);
		test.run(true, false, 100);
		
	}

}
