package fireworkApp;

import java.io.File;
import java.util.Random;

public class RocketSounds 
{
	private Random random = new Random();
	
	private File effect1 = new File("src/sounds/effect1.wav");
	private File effect2 = new File("src/sounds/effect2.wav");
	private File effect3 = new File("src/sounds/effect3.wav");
	private File effect4 = new File("src/sounds/effect4.wav");
	private File effectWeird1 = new File("src/sounds/IvoScream1.wav");
	private File effectWeird2 = new File("src/sounds/IvoScream2.wav");
	
	boolean weirdSounds;
	
	public RocketSounds(boolean weirdSounds)
	{
		this.weirdSounds = weirdSounds;
	}
	
	private File[] soundEffects = new File[]
	{
			effect1, effect2, effect3, effect4
	};
	
	private File[] soundEffectsWeird = new File[]
	{
			effectWeird1, effectWeird2
	};
	
	public File getRandomFile()
	{
		if (!weirdSounds)
		{
			return soundEffects[random.nextInt(soundEffects.length)];
		}
		
		if (weirdSounds)
		{
			return soundEffectsWeird[random.nextInt(soundEffectsWeird.length)];
		}
		
		else
		{
			return null;
		}
	}
}