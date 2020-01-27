package Optimization.GA.CrossoverMethod;

import SolutionSpace.SolutionSpace;
import Util.Vector;

public class RandomPoint implements Crossover
{

	@Override
	public Vector crossover(Vector parent1, Vector parent2, SolutionSpace s) 
	{
		// RandomPoint crosssover
		int crossoverPoint = (int)(Math.random() * 64);
		
		Vector child = new Vector(s.getDimensions());
		//convert to binary strings
		String[] parent1B =  new String[(int) s.getDimensions()];
		String[] parent2B =  new String[(int) s.getDimensions()];
		
		for(int i = 0; i < s.getDimensions(); i++)
		{
			parent1B[i] = binarize(parent1.getComponents()[i]);
			parent2B[i] = binarize(parent2.getComponents()[i]);
		}
		
		// crossover
		
		for(int i = 0; i < child.getComponents().length; i++)
		{
			String firstPart = parent1B[i].substring(0, crossoverPoint);
			String secondPart = parent2B[i].substring(crossoverPoint);
			
			child.getComponents()[i] = debinarize(firstPart + secondPart);
		}
		
		return child;
	}

	private String binarize(double d) 
	{
		double decimal = d;
		String binaryString = "";
		if(decimal < 0)
		{
			binaryString += "1";
			decimal = Math.abs(decimal);
		}
		else
			binaryString += "0";
		for(int i = 11; i >= -51; i--)
		{
			if(decimal - Math.pow(2, i) >= 0)
			{
				decimal -= Math.pow(2, i);
				binaryString += "1";
			}
			else
			{
				binaryString += "0";
			}
		}
		
		return binaryString;
	}
	
	private double debinarize(String binaryString) 
	{
		double decimal = 0;
		
		for(int i = 1; i < binaryString.length(); i++)
		{
			if(binaryString.charAt(i) == '1')
			{
				decimal += Math.pow(2, -(i-1) + 11);
			}
		}
		
		if(binaryString.charAt(0) == '1')
		{
			decimal *= -1;
		}
		
		return decimal;
	}

}
