package Optimization.GA.CrossoverMethod;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public interface Crossover 
{
	public abstract Vector crossover(Vector parent1, Vector parent2, SolutionSpace s);
}
