package fireworkApp;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Frame extends JFrame
{	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	public Frame(long refresh, int rocketAmount, int particleMin, int particleMax, boolean weirdSounds)
	{	
		this.setTitle("Simple Firework Sim by Groamer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(toolkit.getScreenSize().width, toolkit.getScreenSize().height));
		this.setResizable(false);
		this.setVisible(true);
		
		new Screen(this, refresh, rocketAmount, particleMin, particleMax, weirdSounds);
	}
}
