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
	    private Timer beeSpawnTimer;
	    private int index; // for arraylist iteration
	    private int beeCounter;
	
	 public Gang() 
	 {
		 makeBees(); // spawn one bee immediately
		// Spawn bees every 2 seconds
	        beeSpawnTimer = new Timer(2000, e -> makeBees());
	        beeSpawnTimer.start();
	        beeCounter = 0;
	
	 }
	 
	 public void makeBees()
	    {
		    Bee b = new Bee(700, random.nextInt(500  - 0 + 1));
		    bees.add(b);
		    moveBees();
		    beeCounter++;
	    }
	 
	 public void moveBees()
	    {
		    for (int i = 0; i < bees.size(); i++)
		    {    
			    bees.get(index).move();
		    }
	    }

	public void checkCollision(Lizard lizard)
	{
		for (Bee bee : bees)
		{
			if(!bee.isDead() && bee.collidesWith(lizard))
			{
				lizard.takeDamage();
				bee.setDead(true);
			}
		}
	}
	

	public JLabel getBee()
	{
		
		return this.bees.get(beeCounter);
	}
	
	public int getBeeCount()
	{
		return beeCounter;
	}

}
