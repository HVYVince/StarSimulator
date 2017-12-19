package ch.hepia.tournier;

public class Velocity {
	private double vx;
	private double vy;
	
	public Velocity()
	{
		vx = 0.0;
		vy = 0.0;
	}
	
	public Velocity(double x, double y) 
	{
		vx = x;
		vy = y;
	}
	
	public void addVelocity(Velocity v)
	{
		vx += v.getVx();
		vy += v.getVy();
	}

	public double getVx() 
	{
		return vx;
	}
	
	public void setVx(double vx) 
	{
		this.vx = vx;
	}
	
	public double getVy() 
	{
		return vy;
	}
	
	public void setVy(double vy) 
	{
		this.vy = vy;
	}
	
	public boolean equals(Object o)
	{
		if(o == this)
			return true;
		if(!(o instanceof Velocity))
			return false;
		Velocity v = (Velocity) o;
		
		return vx == v.getVy() && vy == v.getVy();
	}
}
