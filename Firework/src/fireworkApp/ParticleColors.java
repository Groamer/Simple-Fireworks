package fireworkApp;

import java.awt.Color;
import java.util.Random;

public class ParticleColors 
{
	private static Random random = new Random();
	
	private static Color[] colors = new Color[]
	{
		Color.RED, 
		Color.GREEN,
		Color.BLUE,
		Color.ORANGE,
		Color.WHITE,
	};
	
	public static Color getRandomColor()
	{
		return colors[random.nextInt(colors.length)];
	}
}
