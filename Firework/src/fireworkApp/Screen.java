package fireworkApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Screen 
{
	private Rocket[] rockets;
	private ScreenBackgrounds screenBackgrounds = new ScreenBackgrounds();
	
	private Image background = screenBackgrounds.getRandomFile();
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	private int screenW = toolkit.getScreenSize().width;
	private int screenH = toolkit.getScreenSize().height;
	
	private int particleMin;
	private int particleMax;
	
	private boolean weirdSounds;
	
	public Screen (Frame x, long refresh, int rocketAmount, int particleMin, int particleMax, boolean weirdSounds)
	{
		rockets = new Rocket[rocketAmount];
		
		this.particleMin = particleMin;
		this.particleMax = particleMax;
		this.weirdSounds = weirdSounds;
		
		x.add(panel);
		update();
		
		//berekent de screen refreshrate
		Thread screenrefreshThread = new Thread(new Runnable() 
		{
			public void run() 
			{
				while (true) 
				{  
					panel.repaint();
					
					try 
					{	
						Thread.sleep(calcRefresh(refresh));
					} catch (Exception e) 
					{
						System.out.println(e);
					}
				}
			}
		});
		screenrefreshThread.start();
		
		//berekent het vuurwerk
		Thread calculateThread = new Thread(new Runnable() 
		{
			public void run() 
			{
				while (true) 
				{  
					update();
					
					try 
					{
						Thread.sleep(10);
					} catch (Exception e) 
					{
						System.out.println(e);
					}
				}
			}
		});
		calculateThread.start();
		
		/*Thread fpsCountThread = new Thread(new Runnable()
		{
			public void run()
			{
				while (true)
				{
					
					
					try
					{
						Thread.sleep(1000);
					} catch (Exception e)
					{
						System.out.println(e);
					}
				}
			}
		});
		fpsCountThread.start();*/
	}
	
	//tekent de rockets
	private JPanel panel = new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.BLACK);
			g.clearRect(0, 0, screenW, screenH);
			g.drawImage(background, 0, 0, screenW, screenH, null);
			
			for (int i = 0; i < rockets.length; i ++)
			{
				if (rockets[i] != null)
				{
					for (int j = 0; j < rockets[i].getParticles().length; j ++)
					{
						if (rockets[i].getParticles()[j] != null)
						{
							g.setColor(rockets[i].getParticles()[j].getColor());
							g.fillOval((int)rockets[i].getParticles()[j].getLocationX(), (int)rockets[i].getParticles()[j].getLocationY(), 3, 3);
						}
					}
				}
			}
		}
	};
	
	//voegt een waarde toe aan de rockets
	public void update()
	{
		for (int i = 0; i < rockets.length; i ++)
		{
			//maakt nieuwe rocket als andere rocket geen waarde meer heeft
			if (rockets[i] == null)
			{
				rockets[i] = new Rocket(particleMin, particleMax, weirdSounds);
			}
			
			rockets[i].update();
			
			//verwijdert rockets die geen waarde meer hebben
			if (rockets[i].getDead())
			{
				rockets[i] = null;
			}
		}
	}
	
	//Zorgt ervoor dat het gewenste aantal beeldjes per seconde wordt weergegeven
	private long calcRefresh(long x)
	{
		if (x == 0)
		{
			return 0;
		}
		
		long refresh = 1000 / x;
		return refresh;
	}
}