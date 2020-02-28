package Util;

public class BinaryOperations 
{
	
	public static String binarize(double d) 
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
	
	public static double debinarize(String binaryString) 
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
