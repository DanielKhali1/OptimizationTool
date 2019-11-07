package Optimization.GA.SelectionMethod;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public interface Selection 
{
	public abstract Vector SelectParent(Vector[] population, SolutionSpace ss);

}
