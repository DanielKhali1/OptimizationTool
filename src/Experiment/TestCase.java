package Experiment;

import java.nio.file.Files;
import java.nio.file.Paths;
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
	
	public void run(boolean showInputs, boolean showSolution, boolean saveToCSV)
	{
		ArrayList<String> lines = new ArrayList<String>();
		
		if(saveToCSV)
			lines.add("iteration,fitness");
		
		for(int i = 0; i <= iterations; i++)
		{
			optimizer.nextEpoch();
			if(saveToCSV)
				lines.add(optimizer.getCurrentIteration() + "," + optimizer.getSolutionSpace().Function(optimizer.bestSolution()));
			if(showInputs)
				System.out.print(optimizer.bestSolution() + " " );
			if(showSolution)
				System.out.println(optimizer.getSolutionSpace().Function(optimizer.bestSolution()) + " ");
		}
		
		if(saveToCSV)
		{
			try 
			{
				saveToFile(lines);	
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void saveToFile(ArrayList<String> lines) throws Exception
	{
	    Files.write(Paths.get("test.csv"), lines);
	}
	
	

	public int getIterations() { return iterations; }
	public Optimizer getOptimizer() { return optimizer; }
	

	public void setIterations(int iterations) { this.iterations = iterations; }
	public void setOptimizer(Optimizer optimizer) { this.optimizer = optimizer; }

}
