import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.util.Random;

/**
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Is-a Gang. Sprite class with movement
 *         behavior. Implements Movement. Causes damage if eaten.
 */

public class Bee extends JLabel implements Movement
{
	// fields
	private int x, y;
	private boolean isDead;
	private boolean hasDamaged = false;
	private ImageIcon beeImage = new ImageIcon("bee.png");;
	private int moveCount;
	private Direction currDir;
	JLabel label;
	Random rand = new Random();
	private int width, height;

	/*************************************** constructors **************************************/
	/**
	 * Constructor for a Bee
	 * 
	 * @param x x coordinate for a Bee
	 * @param y y coordinate for a Bee
	 */
	public Bee(int x, int y)
	{
		width = beeImage.getIconWidth();
		height = beeImage.getIconHeight();
		this.x = x;
		this.y = y;
		this.setIcon(beeImage);
		this.setBounds(x, y, width, height);
		this.isDead = false;
		this.currDir = Direction.WEST; // default direction
	}

	/*************************************** methods **************************************/

	/**
	 * this method handles bee movement
	 */
	public void move() {
		int directionNumber = rand.nextInt(4);

		if (directionNumber == 0) {
			currDir = Direction.NORTH;
			this.y += 15;
		}
		if (directionNumber == 1) {
			currDir = Direction.EAST;
			this.x += 15;
		}
		if (directionNumber == 2) {
			currDir = Direction.SOUTH;
			this.y -= 15;
		} else {
			currDir = Direction.WEST;
			this.x -= 20;
		}

		this.setLocation(x, y);
		this.repaint();

		if (x < 800) {
			Timer t = new Timer(100, e -> move());
			t.setRepeats(false);
			t.start();
		} else {
			setVisible(false);
		}
	}

	/**
	 * Checks if lizard has taken damage
	 * 
	 * @return hasDamaged lizard is or isn't damaged
	 */
	public boolean hasDamagedLizard() {
		return hasDamaged;
	}

	/**
	 * Sets the state of if Lizard has been damaged
	 * 
	 * @param damaged damage state
	 */
	public void setHasDamaged(boolean damaged) {
		this.hasDamaged = damaged;
	}

	/**
	 * Collision between Lizard and a Bee
	 * 
	 * @param lizard
	 * @return the intersection of Lizard and Bee
	 */
	public boolean collidesWith(Lizard lizard) {
		return getBounds().intersects(lizard.getBounds());
	}

	/**
	 * Returns of state of a Bee being alive or not
	 * 
	 * @return isDead bee life state
	 */
	public boolean isDead() {
		return isDead;
	}

	/**
	 * Sets the state of a Bee being alive or not
	 * 
	 * @param dead kills bee
	 */
	public void setDead(boolean dead) {
		isDead = dead;
	}

	/**
	 * Returns the bounds of the rectangle encapsulating a Bee
	 * 
	 * @return rectangle bounds
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	/**
	 * Returns x coordinate of bee
	 * 
	 * @return x bee x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y coordinate of a bee
	 * 
	 * @return y bee y coordinate
	 */
	public int getY() {
		return y;
	}
}
