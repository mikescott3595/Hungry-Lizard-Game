import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Manages the category of bee friends.
 */
public class Gang
{
	// fields
	private ArrayList<Bee> bees = new ArrayList<Bee>(); // has bees
	Random random = new Random();
	private int beeCounter;
	private Bee b;

	/*************************************** constructors **************************************/
	
	/**
	 * Constructor for a Gang
	 */
	public Gang()
	{
		makeBees();
		Timer t = new Timer(1000, e -> makeBees());
		t.setRepeats(true);
		t.start();
		beeCounter = 0;
	}

	/*************************************** methods **************************************/
	
	/**
	 * Births new bees and increments the bee counter
	 */
	public void makeBees() 
	{

		b = new Bee(800, random.nextInt(400 - 0 + 1));
		bees.add(b);
		b.move();
		beeCounter++;

	}

	/**
	 * Checks if a bee has collided with a Lizard
	 * @param lizard 
	 */
	public void checkCollision(Lizard lizard) 
	{
		for (Bee b : bees) 
		{

			if (!b.isDead() && b.collidesWith(lizard)) 
			{
				lizard.takeDamage();
				b.setDead(true);
			}

		}
	}

	/**
	 * Returns the Gang of Bees that exist
	 * @return bees all the bees in the gang
	 */
	public ArrayList<Bee> getBees() 
	{

		return bees;
	}

	/**
	 * Gets the Bee count 
	 * @return the count of the bees 
	 */
	public int getBeeCount() 
	{
		return beeCounter;
	}

}
