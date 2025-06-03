import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

/**
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Manages the category of food, which
 *         consists of flies.
 */
public class Snackaroo
{
	//fields
	private ArrayList<Fly> flies = new ArrayList<Fly>(); // has flies
	Random random = new Random();
	private int flyCounter;
	private Fly f;

	/*************************************** constructors **************************************/
	
	/**
	 * Constructor for Snackaroo
	 * 
	 * @param rows number of rows in the fly grid
	 * @param col  number of columns in the fly grid
	 */
	public Snackaroo()
	{
		makeFlies();
		Timer t = new Timer(1000, e -> makeFlies());
		t.setRepeats(true);
		t.start();
		flyCounter = 0;
	}

	/*************************************** methods **************************************/
	
	/**
	 * Makes new flies for the Snackaroo collection
	 */
	public void makeFlies() 
	{
		f = new Fly(800, random.nextInt(400 - 0 + 1));
		flies.add(f);
		f.move();
		flyCounter++;
	}

	/**
	 * Returns the ArrayList containing all of the flies made
	 * @return flies snackaroo flies
	 */
	public ArrayList<Fly> getFlies() 
	{
		return flies;
	}
}