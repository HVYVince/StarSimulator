package ch.hepia.tournier;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;

public class StarSimulator {
	public static int STARCOUNT = 4;
	public static void main(String[] args) 
	{
		Random rand = new Random();
		Iterator<Integer> rands = rand.ints(-100, 101).iterator();
		StarSystem hollywood = new StarSystem();
		
		for(int i = 0 ; i < STARCOUNT ; i++)
			hollywood.addStar(new Star(rands.next(), rands.next(), 1));//rand.nextInt(5) + 1));
		
//		for(int i = 0 ; i < STARCOUNT ; i++)
//			hollywood.addStar(new Star(100 * Math.cos(i * (2 * Math.PI) / STARCOUNT), 100 * Math.sin(i * (2 * Math.PI) / STARCOUNT), rand.nextInt(20) + 1));
		
//		for(int i = 0 ; i < STARCOUNT ; i++)
//			hollywood.addStar(new Star(100 * Math.cos(i * (2 * Math.PI) / STARCOUNT), 100 * Math.sin(i * (2 * Math.PI) / STARCOUNT), 1));
		
		StarGUI gui = new StarGUI(hollywood);
		
		JFrame window = new JFrame();
		window.setSize(400, 400);
		window.add(gui);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for(int i = 0 ; i < 10000000 ; i++)
		{
			hollywood.nextStep(10000);
			//hollywood.printSystem();
			window.repaint();
		}
	}
}
