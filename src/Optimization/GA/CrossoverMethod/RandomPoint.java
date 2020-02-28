package Optimization.GA.CrossoverMethod;

import SolutionSpace.SolutionSpace;
import Util.BinaryOperations;
import Util.Vector;

public class RandomPoint implements Crossover
{

	@Override
	public Vector crossover(Vector parent1, Vector parent2, SolutionSpace s) 
	{
		// RandomPoint crosssover
		int crossoverPoint = (int)(Math.random() * 64);
		
		Vector child = new Vector(parent1.getComponents().length);
		String[] parent1B =  new String[(int) s.getDimensions()];
		String[] parent2B =  new String[(int) s.getDimensions()];
		
			
		for(int i = 0; i < s.getDimensions(); i++)
		{
			parent1B[i] = BinaryOperations.binarize(parent1.getComponents()[i]);
			parent2B[i] = BinaryOperations.binarize(parent2.getComponents()[i]);
		}
		
		
		for(int i = 0; i < child.getComponents().length; i++)
		{
			String firstPart = parent1B[i].substring(0, crossoverPoint);
			String secondPart = parent2B[i].substring(crossoverPoint);
			
			child.getComponents()[i] = BinaryOperations.debinarize(firstPart + secondPart);
		}
		
		return child;
	}

	
	
	public static void main(String[] args) {
		System.out.println(	BinaryOperations.binarize(-30.43453424));
		System.out.println(	BinaryOperations.debinarize(BinaryOperations.binarize(-30.43453424)));

	}
	


}
