package ch.hepia.tournier;

import java.awt.Color;

public class Star {

	private Position pos;
	private Position nextPos;
	public Velocity speed;
	public Force total;
	public double mass;
	public Color color;    
	
	public Star()
	{
		pos = new Position();
		nextPos = new Position();
		speed = new Velocity();
		total = new Force();
		mass = 1.0;
		color = Color.RED;
	}
	
	public Star(Position start, double mass)
	{
		this();
		this.mass = mass;
		pos = start;
		nextPos.setPos(pos);
	}
	
	public Star(double x, double y, double mass) 
	{
		this(new Position(x, y), mass);
	}

	@Override
	public boolean equals(Object o)
	{
		if(o == this)
			return true;
		if(!(o instanceof Star))
			return false;
		
		Star s = (Star) o;
		return pos.equals(s.getPos()) && mass == s.mass;
	}

	public void resetForce() 
	{
		total.reset();
	}

	public void computeForce(Star starB) 
	{
		double xDist = starB.getPos().getX() - pos.getX();
	    double yDist = starB.getPos().getY() - pos.getY();
	    double distance = Math.sqrt(xDist * xDist + yDist * yDist);
	    double gravForce = (StarSystem.G * mass * starB.getMass());
	    gravForce /= ((distance * distance) + (StarSystem.SOFTENING * StarSystem.SOFTENING));
	    Force ponderated = new Force(gravForce * (xDist / distance), gravForce * (yDist / distance));
	    total.addForce(ponderated);
	}
	
	public void computeNextPos(double timeStep) 
	{
		Velocity v = new Velocity(timeStep * (total.getFx() / mass), timeStep * (total.getFy() / mass));
		speed.addVelocity(v);
		Position p = new Position(timeStep * speed.getVx(), timeStep * speed.getVy());
	    
		nextPos.addPos(p);
	}

	public Position getPos()
	{
		return pos;
	}
	
	public double getMass() 
	{
		return mass;
	}

	public String toString()
	{
		return "(" + pos.getX() + ":" + pos.getY() + ") speed : (" + speed.getVx() + ":" + speed.getVy() + "), mass " + mass;
	}

	public void validateNextPos() 
	{
		pos.setPos(nextPos);
	}

	public Color getColor() 
	{
		return color;
	}
}
