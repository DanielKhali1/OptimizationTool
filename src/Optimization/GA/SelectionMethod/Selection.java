package Optimization.GA.SelectionMethod;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public abstract class Selection 
{
	public abstract Vector SelectParent(Vector[] population, SolutionSpace ss);

}
