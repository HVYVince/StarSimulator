package ch.hepia.tournier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class StarGUI extends JComponent {
	private static final long serialVersionUID = 5438653795150766090L;
	private StarSystem system;
	
	public StarGUI(StarSystem sys) 
	{
		system = sys;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D graphics = (Graphics2D) g;
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, getSize().width, getSize().width);
		graphics.setColor(Color.RED);
		//graphics.drawString(Integer.toString(system.getStep()), 0, 0);
		graphics.translate((double) getSize().width / 2.0, (double) getSize().height / 2.0);
		system.getSystem().forEach(star->{
			//graphics.setColor(star.getColor());
			star.validateNextPos();
			graphics.fillOval((int) Math.round(star.getPos().getX()), (int) Math.round(star.getPos().getY()), 3, 3);
		});
	}
}
