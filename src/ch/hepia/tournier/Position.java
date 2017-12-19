package ch.hepia.tournier;

public class Position {
	private double x;
	private double y;
	
	public Position()
	{
		x = 0.0;
		y = 0.0;
	}
	
	public Position(double x, double y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public void addPos(Position p)
	{
		x += p.getX();
		y += p.getY();
	}
	
	public void setPos(Position p)
	{
		x = p.getX();
		y = p.getY();
	}

	public double getY() 
	{
		return y;
	}
	
	public void setY(double y) 
	{
		this.y = y;
	}
	
	public double getX() 
	{
		return x;
	}
	
	public void setX(double x) 
	{
		this.x = x;
	}
	
	public boolean equals(Object o)
	{
		if(o == this)
			return true;
		if(!(o instanceof Position))
			return false;
		Position p = (Position) o;
		
		return x == p.getX() && y == p.getY();
	}
}
