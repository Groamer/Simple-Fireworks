package fireworkApp;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean configSettings = false;
		boolean weirdSounds = false;
		
		while(true)
		{
			System.out.println("Wilt u de standaard instellingen gebruiken?"
					+ "\n(j/n)");
			String defaultConfigString = scan.next();
			if (defaultConfigString.equals("n"))
			{
				configSettings = true;
				break;
			}
			if (defaultConfigString.equals("j"))
			{
				scan.close();
				new Frame(60, 10, 20, 100, false);
				break;	
			}
			if (!defaultConfigString.equals("j") || !defaultConfigString.equals("n"))
			{
				System.out.println("Invoer niet herkend."
						+ "\nVoer 'j' voor ja en 'n' voor nee in.");
			}
		}

		if (configSettings)
		{
			System.out.println("Hoeveel beeldjes moet de simulator per seconde genereren?"
					+ "\n(Voer '0' in als u geen limiet wilt)");
			int refresh = scan.nextInt();
			
			System.out.println("Hoeveel vuurpijlen mogen maximaal tegelijkertijd getoond worden?");
			int rocketAmount = scan.nextInt();
			
			System.out.println("Hoeveel deeltjes moeten minimaal gerenderd worden?");
			int particleMin = scan.nextInt();
			
			System.out.println("Hoeveel deeltjes moeten maximaal gerenderd worden?");
			int particleMax = scan.nextInt();
			
			System.out.println("Mag de simulator rare geluiden maken?"
					+ "\n(j/n)");
			String weirdSoundsString = scan.next();
			if (weirdSoundsString.equals("j"))
			{
				weirdSounds = true;
			}
			
			scan.close();
			new Frame(refresh, rocketAmount, particleMin, particleMax, weirdSounds);
		}
	}
}