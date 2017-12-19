package ch.hepia.tournier;

import java.util.ArrayList;
import java.util.List;

public class StarSystem {
	public static final double G = 6.673e-11;
	public static final double SOFTENING = 1000;
	//private static final double solarMass = 1.98892e30;
	
	private List<Star> system;
	private int step;
	
	public StarSystem() 
	{
		system = new ArrayList<>();
		step = 0;
	}
	
	public void addStar(Star s)
	{
		system.add(s);
	}
	
	public void nextStep(double timeDelta)
	{
		system.forEach(starA->{
			starA.resetForce();
			system.stream().filter(starB->!starA.equals(starB)).forEach(starB->{
				starA.computeForce(starB);
			});
		});
		system.forEach(starA->starA.computeNextPos(timeDelta));
		step++;
	}
	
	public void printSystem()
	{
		System.out.println("STEP #" + step);
		System.out.println("--------------");
		system.forEach(star->{
			star.validateNextPos();
			System.out.println(star.toString());
		});
		System.out.println("--------------");
		System.out.println();
	}
	
	public List<Star> getSystem()
	{
		return system;
	}
	
	public int getStep()
	{
		return step;
	}
}
