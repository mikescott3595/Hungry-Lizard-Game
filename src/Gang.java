import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class Gang
{
	private ArrayList<Bee> bees = new ArrayList<Bee>(); // has bees
	Random random = new Random();
	 private int beeCounter;
	 private Bee b;
	
	 public Gang() 
	 {
		 makeBees();
		   Timer t = new Timer(1000, e -> makeBees());
		    t.setRepeats(true);
		    t.start();
	        beeCounter = 0;
	
	 }
	 
	 public void makeBees()
	    {
	        
		    b = new Bee(800, random.nextInt(400  - 0 + 1));
		    bees.add(b);
		    b.move();
		    beeCounter++;

	    }
	 


	public void checkCollision(Lizard lizard)
	{
		for (Bee b : bees)
		{
			if(!bee.isDead() && bee.collidesWith(lizard))
			{
				lizard.takeDamage();
				bee.setDead(true);
			}
		}
	}
	

	public ArrayList<Bee> getBees()
	{
		
		return bees;
	}
	
	public int getBeeCount()
	{
		return beeCounter;
	}
	
    

}
