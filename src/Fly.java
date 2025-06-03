import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Is-a Snackaroo. Enemy class with movement
 *         behavior. Implements Movement.
 */
public class Fly extends JLabel implements Movement
{
	// fields
	private int x, y;
	private int width, height;
	private boolean isEaten;
	private ImageIcon flyImage = new ImageIcon("fly.png");;
	private Direction currDir;
	Random rand = new Random();

	/************************************** constructors **************************************/
	
	/**
	 * Constructor for a Fly
	 * @param x fly's x coordinate
	 * @param y fly's y coordinate
	 */
	public Fly(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.isEaten = false;
		width = flyImage.getIconWidth();
		height = flyImage.getIconHeight();
		this.setIcon(flyImage);
		this.setBounds(x, y, width, height);
		this.currDir = Direction.WEST; // default direction
	}

	/*************************************** methods **************************************/
	
	/**
	 * Handles fly movement
	 */
	public void move() {
		int directionNumber = rand.nextInt(4);

		if (directionNumber == 0) {
			currDir = Direction.NORTH;
			this.y += 20;
		}
		if (directionNumber == 1) {
			currDir = Direction.EAST;
			this.x += 20;
		}
		if (directionNumber == 2) {
			currDir = Direction.SOUTH;
			this.y -= 20;
		} else {
			currDir = Direction.WEST;
			this.x -= 25;
		}

		this.setLocation(x, y);
		this.repaint();

		if (x < 800) {
			Timer t = new Timer(50, e -> move());
			t.setRepeats(false);
			t.start();
		} else {
			setVisible(false);
		}
	}

	/**
	 * Returns state of fly being alive or not
	 * @return isEaten fly's life state
	 */
	public boolean isEaten() {
		return isEaten;
	}

	/**
	 * Returns the bounds of the rectangle encapsulating a Fly
	 * @return rectangle bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	/**
	 * Returns the x coordinate value of a Fly
	 * @return x fly x coordinate value
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y coordinate value of a Fly
	 * @return y fly y coordinate value
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns the state of the fly being eaten or not
	 * @param eaten state of fly's life
	 */
	public void setEaten(boolean eaten) {
		this.isEaten = eaten; // Store the eaten state
		this.setVisible(!eaten); // Hide the fly if it’s eaten
	}

}
