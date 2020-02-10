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
import SolutionSpace.Benchmarks.HolderTable;
import SolutionSpace.Benchmarks.Levy;
import SolutionSpace.Benchmarks.Rastrigin;
import SolutionSpace.Benchmarks.Sphere;
import Util.Vector;

public class Manager 
{
	public static void main(String[] args) 
	{
		SolutionSpace ss = new Rastrigin(2);
		SolutionSpace ackley = new EggHolder();
		
		System.out.println("GLOBAL MINIMUM " + ss.Function(ss.getGlobalMinimum()));
		
		Optimizer ga = new GA(50, 0.01, new DeepTournament(), new BLX());
		Optimizer tandem = new TandemHybrid(50, 0.9, 2, 2, 0.01, 0.2);
		
		Optimizer pso = new PSO(50, 0.9, 2, 2);
		//GA oldfashionedGA = new GA(50, 0.01, new DeepTournament(), new RandomPoint());
		

		
		int iteration = 20;
		
	//	TestCase test = new TestCase(iteration, ss, oldfashionedGA);
		//test.run(true, false, 100);
		TestCase test = new TestCase(iteration, ss, ga, pso, tandem);
		test.run(true, true, 100);
		
	}

}
