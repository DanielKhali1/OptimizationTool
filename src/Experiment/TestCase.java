package Experiment;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Optimization.Optimizer;
import SolutionSpace.SolutionSpace;

public class TestCase 
{
	private int iterations;
	private Optimizer[] optimizers;
	
	public TestCase(int iterations, SolutionSpace ss, Optimizer ... optimizers)
	{
		this.iterations = iterations;
		this.optimizers = optimizers;
		
		for(Optimizer optimizer : optimizers)
		{
			optimizer.setSolutionSpace(ss);
			optimizer.randPop(optimizer.getPopulationSize());
			optimizer.setup();
		}
	}
	
	public void step()
	{
		for(int i = 0; i < optimizers.length; i++)
		{
			optimizers[i].nextEpoch();
		}
	}
	
	public void run(boolean showSolution, boolean saveToCSV, int avg)
	{
		ArrayList<String> lines = new ArrayList<String>();
		double[][] data = new double[iterations][optimizers.length];
		
		if(saveToCSV)
		{
			String title = "iteration,GA,PSO,Hybrid";
			lines.add(title);
		}
		
		for(int i = 0; i < avg; i++)
		{
			for(int j = 0; j < iterations; j++)
			{
				for(int k = 0; k < optimizers.length ; k++)
				{
					optimizers[k].nextEpoch();
					data[j][k] += optimizers[k].getSolutionSpace().Function(optimizers[k].bestSolution());
				}
			}
			for(Optimizer optimizer : optimizers)
			{
				optimizer.reset();
			}
			
		}
		
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				data[i][j] /= avg;
			}
		}

		for(int i = 0; i < data.length; i++)
		{
			String line = i + ",";
			
			for(int j = 0; j < data[i].length; j++)
				line += data[i][j] + ",";
				
			
			if(saveToCSV)
				lines.add(line);
			if(showSolution)
				System.out.println(line);
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
	public Optimizer[] getOptimizers() { return optimizers; }
	

	public void setIterations(int iterations) { this.iterations = iterations; }
	public void setOptimizer(Optimizer[] optimizers) { this.optimizers = optimizers; }

}
