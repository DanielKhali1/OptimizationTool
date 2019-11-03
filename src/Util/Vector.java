package Util;

/**
 * <p> the vector class holds a double array of components </p>
 * 
 * @author Danny
 *
 */
public class Vector 
{
	private double[] components;
	
	/** <p> constructor initializes the vector's "component" array </p>
	 * 
	 * @param components
	 */
	public Vector( double[] components )
	{
		this.setComponents(components);
	}
	
	/**
	 * <p> input a vector, method will add each individual component to the vectors respected component </p>
	 * 
	 * @param vector
	 */
	public void add ( Vector vector )
	{
		for(int i = 0; i < vector.getComponents().length; i++)
		{
			this.getComponents()[i] += vector.getComponents()[i];
		}
	}
	
	/**
	 * <p> input a double constant, method will multiply each component by that constant </p>
	 * @param constant
	 */
	public void mult ( double constant )
	{
		for(int i = 0; i < this.components.length; i++)
			this.components[i] *= constant;
	}
	
	/**
	*
	*<p> input a double constant, method will divide each component by that constant </p>
	 * @param constant
	 */
	public void div ( double constant )
	{
		for(int i = 0; i < this.components.length; i++)
			this.components[i] /= constant;
	}
	
	/**
	 * <p> will normalize the vector </p>
	 */
	public void normalize ( )
	{
		div( mag() );
	}
	
	/**
	 * <p> will return the magnitude of the vector </p>
	 * 
	 * @return
	 */
	public double mag ( )
	{
		double sum = 0;
		
		for(int i = 0; i < this.components.length; i++)
			sum += this.components[i] * this.components[i];
		
		return Math.sqrt(sum);
	}
	
	/**
	 * <p> will return an identical Vector </p>
	 */
	public Vector clone()
	{
		Vector v;
		double[] comp = new double[this.components.length];
		
		for(int i = 0; i < comp.length; i++)
			comp[i] = this.components[i];
		
		v = new Vector(comp);
		return v;	
	}

	/**
	 * <p> will return the vector's components </p>
	 * 
	 * @return
	 */
	public double[] getComponents() { return components; }

	/**
	 * <p> will set the vector's components </p>
	 * @param components
	 */
	public void setComponents(double[] components) { this.components = components; }

}
