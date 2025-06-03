import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Represents the player character. Includes
 *         movement, health, and collision detection with food/enemies.
 */

public class Lizard extends JLabel
{
	// fields
	private int x, y;
	private int speed;
	private int width;
	private int height;
	private ImageIcon lizardImage = new ImageIcon("lizard.png");
	private JLabel lizardLabel;
	private Health health; // has-a health
	private Tongue tongue; // has-a tongue
	private GamePanel gamePanel;

	/*************************************** constructors **************************************/
	
	/**
	 * Constructor for a Lizard
	 * 
	 * @param startX starting x coordinate for the Lizard
	 * @param startY starting y coordinate for the Lizard
	 */
	public Lizard(int startX, int startY, GamePanel panel)
	{
		// super();
		this.x = startX;
		this.y = startY;
		this.speed = 15;
		this.gamePanel = panel;
		this.tongue = new Tongue(x, y, gamePanel);
		this.setIcon(lizardImage);
		width = lizardImage.getIconWidth();
		height = lizardImage.getIconHeight();
		this.setBounds(x, y, width, height);
		this.health = new Health(); // gives lizard health starting at 3 hearts
	}

	/*************************************** methods **************************************/
	
	/**
	 * Method that moves the lizard
	 * 
	 * @param dx where the lizard will move in the x direction
	 */
	public void move(int dx) 
	{
		x += dx; // 1️⃣ update x position
		this.setLocation(x, y); // 2️⃣ update JLabel position
		this.repaint(); // 3️⃣ repaint the component
	}

	/**
	 * Returns the bounds of the rectangle encapsulating the Lizard
	 * @return rectangle bounds
	 */
	@Override
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, width, height);
	}

	/**
	 * Lizard eats flies by extending the tongue
	 */
	public void eat() 
	{
		tongue.extendedTongue(getX(), getY());

		new javax.swing.Timer(300, new java.awt.event.ActionListener() 
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				tongue.retractedTongue();
			}
		}) {

			private static final long serialVersionUID = 1L;

			{
				setRepeats(false);
				start();
			}
		};
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
	 * 
	 * @return the panel displaying Lizard's health
	 */
	public JPanel getHealthPanel() 
	{
		return health.getPanel();
	}

	/**
	 * Method that returns the current health of the lizard
	 * 
	 * @return the number of hearts
	 */
	public int getHealth() 
	{
		return health.getHearts();
	}

	/**
	 * Method that returns the Lizard label which contains icon
	 * 
	 * @return lizardLabel lizard icon
	 */
	public JLabel getLizard() 
	{
		return lizardLabel;
	}

	/**
	 * Gets the speed of the Lizard
	 * @return speed speed of lizard
	 */
	public int getSpeed() 
	{
		return speed;
	}

	/**
	 * Gets the x coordinate value of the Lizard
	 * @return x lizard x coordinate value 
	 */
	public int getX() 
	{
		return x;
	}

	/**
	 * Gets the y coordinate value of the Lizard
	 * @return y lizard y coordinate value
	 */
	public int getY() 
	{
		return y;
	}

	/**
	 * Gets the Lizard tongue
	 * @return tongue lizard tongue
	 */
	public Tongue getTongue() 
	{
		return tongue;
	}
}