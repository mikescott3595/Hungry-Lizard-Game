import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Lizard extends HungryLizardGame
{
	private int x, y;
	private int speed;
	private int width = 40;
	private int height = 40;
	private ImageIcon lizardImage = new ImageIcon("lizard.png");
	private JLabel lizardLabel;
	private Health health; // has-a health
	private Tongue tongue; // has-a tongue

	/**
	 * Constructor for a Lizard
	 * @param startX starting x coordinate for the Lizard
	 * @param startY starting y coordinate for the Lizard
	 */
	public Lizard(int startX, int startY)
	{
		super();
		this.x = startX;
		this.y = startY;
		this.speed = 5;
		
		lizardLabel = new JLabel(lizardImage);
		lizardLabel.setLocation(startX, startY)
		Health health = new Health(); // gives lizard health starting at 3 hearts
	}
	
	/**
	 * Method that moves the lizard
	 * @param dx where the lizard will move in the x direction
	 */
	public void move(int dx)
	{
		Point current = lizardLabel.getLocation();
		// updates x value in coordinate
		lizardLabel.setLocation(current.x + dx, current.y);
	}

	public void eat()
	{
		// call a method from Tongue class maybe called lick
	}
	
	/**
	 * Method that updates the hearts in the health panel
	 */
	public void takeDamage()
	{
		health.damage();
	}

	/**
	 * Method that returns the JPanel displaying the heart containers
	 * @return the panel displaying Lizard's health
	 */
	public JPanel getHealthPanel()
	{
		return health.getPanel();
	}
	
	/**
	 * Method that returns the current health of the lizard
	 * @return the number of hearts
	 */
	public int getHealth()
	{
		return health.getHearts();
	}
	
	/**
	 * Method that returns the Lizard label which contains icon
	 * @return lizardLabel lizard icon
	 */
	public JLabel getLizard()
	{
		return lizardLabel;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	@Override
	public void startGame() {
	// Initialize or reset specific things for the lizard
		this.x = 300;
		this.y = 500; //test positions
	}

    @Override
	 public void updateGameState() {
	 // Update the lizard's state or check for collisions with bees or flies
	 }

	@Override
	public void endGame() {
    // Handle what happens when the game ends 
	}
}

