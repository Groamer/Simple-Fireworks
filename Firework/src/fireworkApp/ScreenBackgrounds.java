package fireworkApp;

import java.awt.Toolkit;
import java.awt.Image;
import java.util.Random;

public class ScreenBackgrounds
{
	private Random random = new Random();
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	private Image background1 = toolkit.getImage("src/backgrounds/background1.jpg");
	private Image background2 = toolkit.getImage("src/backgrounds/background2.jpg");
	private Image background3 = toolkit.getImage("src/backgrounds/background3.jpg");
	
	private Image[] backgrounds = new Image[]
	{
		background1,
		background2,
		background3
	};
	
	public Image getRandomFile()
	{
		return backgrounds[random.nextInt(backgrounds.length)];
	}
}