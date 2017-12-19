package ch.hepia.tournier;

public class Force {
	private double fx;
	private double fy;
	
	public Force()
	{
		fx = 0.0;
		fy = 0.0;
	}
	
	public Force(double x, double y) 
	{
		fx = x;
		fy = y;
	}

	public double getFx() 
	{
		return fx;
	}
	
	public void setFx(double fx) 
	{
		this.fx = fx;
	}
	
	public double getFy() 
	{
		return fy;
	}
	
	public void setFy(double fy) 
	{
		this.fy = fy;
	}
	
	public void addForce(Force f)
	{
		fx += f.fx;
		fy += f.fy;
	}

	public void reset() 
	{
		fx = 0.0;
		fy = 0.0;
	}
}
