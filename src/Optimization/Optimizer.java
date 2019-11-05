package Optimization;

public class Optimizer 
{
	private String Algorithm;
	
	public Optimizer(String Algorithm)
	{
		this.setAlgorithm(Algorithm);
	}

	public String getAlgorithm() {
		return Algorithm;
	}

	public void setAlgorithm(String algorithm) {
		Algorithm = algorithm;
	}
	
}
