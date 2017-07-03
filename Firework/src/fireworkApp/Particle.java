package fireworkApp;

import java.util.Random;
import java.awt.Color;

public class Particle 
{
	private Random random = new Random();
	private Color color;
	
	private float locationX;
	private float locationY;
	private float motionX;
	private float motionY;
	private float speed;
	private float speedFade;
	private float age = 0;
	private float maxAge = 150 + random.nextInt(400);
	
	private boolean dead = false;
	
	public Particle(float locationX, float locationY)
	{
		this.locationX = locationX;
		this.locationY = locationY;
		
		speed = random.nextFloat();
		speedFade = 0.995F;
		
		motionX = (random.nextFloat() - 0.5F) * speed;
		motionY = (random.nextFloat() - 1F) * speed;
		
		color = ParticleColors.getRandomColor();	
	}
	
	public float getLocationX()
	{
		return locationX;
	}
	
	public float getLocationY()
	{
		return locationY;
	}
	
	public boolean getDead()
	{
		return dead;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color colorInput)
	{
		color = colorInput;
	}
	
	public void update()
	{
		locationX += motionX;
		locationY += motionY;
		
		age ++;
		
		motionX *= speedFade;
		motionY *= speedFade; 
		motionY += 0.001F; 
		
		if (age >= maxAge)
		{
			dead = true;
		}
	}
}