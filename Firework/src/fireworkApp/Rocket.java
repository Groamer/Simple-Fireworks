package fireworkApp;

import java.awt.Toolkit;
import java.util.Random;
import javax.sound.sampled.*;

public class Rocket 
{
	private Particle[] particles;
	private RocketSounds soundEffects;
	private Random random = new Random();
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	private int x;
	private int y;
	
	private int fuse;
	
	private boolean exploded = false;
	private boolean dead = false;
	
	AudioInputStream stream;
	AudioFormat format;
	DataLine.Info info;
	Clip clip;
	
	public Rocket(int particleMin, int particleMax, boolean weirdSounds)
	{	
		soundEffects = new RocketSounds(weirdSounds);
		x = random.nextInt(toolkit.getScreenSize().width - 300 ) + 150;
		y = random.nextInt(toolkit.getScreenSize().height - 500) + 150;
		
		fuse = 20 + random.nextInt(500);
		
		particles = new Particle[particleMin + random.nextInt(particleMax)];
	}
	
	public void explode()
	{	
		for (int i = 0; i < particles.length; i ++)
		{
			particles[i] = new Particle(x, y);
		}
		
		exploded = true;
	}
	
	public void playSound()
	{
		try
		{
			Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(soundEffects.getRandomFile()));
	        clip.start();
			
		} catch (Exception e)
		{
			e.printStackTrace(System.out);
		}
	}
	
	public void update()
	{
		if (exploded)
		{
			int deadParticles = 0;
			
			for (int i = 0; i < particles.length; i ++)
			{
				if (particles[i] != null)
				{
					particles[i].update();
					
					if (particles[i].getDead())
					{
						particles[i] = null;
					}
				} else
				{
					deadParticles ++;
				}
			}
			
			if (deadParticles == particles.length)
			{
				dead = true;
			}
		} else
		{
			fuse --;
			
			if (fuse <= 0)
			{
				playSound();
				explode();
			}
		}
	}
	
	public Particle[] getParticles()
	{
		return particles;
	}
	
	public boolean getDead()
	{
		return dead;
	}
}