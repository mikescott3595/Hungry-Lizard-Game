import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.util.List;

/**
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Represents the lizard's tongue action
 *         (attack or grabbing). Should handle extension, collision detection
 *         with insects, and retraction.
 */

public class Tongue extends JLabel
{
	// fields
	private static final long serialVersionUID = 1L;
	private Boolean isTongueExtended;
	private ImageIcon tongue = new ImageIcon("tongue.png");
	private Rectangle bounds;
	private int x;
	private int y;
	private GamePanel gamePanel;
	private boolean hasAlreadyHit = false;

	/*************************************** constructors **************************************/
	
	/**
	 * Constructor for a Tongue
	 * @param startX x coordinate value
	 * @param startY y coordinate value
	 * @param panel the game
	 */
	public Tongue(int startX, int startY, GamePanel panel)
	{
		this.isTongueExtended = false;
		this.bounds = new Rectangle(startX + 15, startY - 40, 10, 40);
		this.gamePanel = panel;

		// Make this JLabel visible
		this.setIcon(tongue);
		this.setBounds(startX + 15, startY - 40, 10, 40);
		this.setVisible(false); // hidden initially
		System.out.println("Tongue image width: " + tongue.getIconWidth());
	}

	/*************************************** methods **************************************/
	
	/**
	 * Extends the Tongue for a Lizard
	 * @param lizardx x coordinate value
	 * @param lizardy y coordinate value
	 */
	public void extendedTongue(int lizardx, int lizardy) {
		isTongueExtended = true;
		this.x = lizardx;
		this.y = lizardy;
		hasAlreadyHit = false;

		int tongueX = x + (40 / 2) - (10 / 2);

		int tongueHeight = 550;
		int tongueY = y - tongueHeight + 40;

		bounds.setBounds(tongueX, tongueY, 10, tongueHeight);
		this.setBounds(tongueX, tongueY, 10, tongueHeight);

		this.setVisible(true);

		System.out.println("Tongue positioned at: " + tongueX + ", " + tongueY + ", height: " + tongueHeight);
	}

	/**
	 * Retracts the Tongue for a Lizard
	 */
	public void retractedTongue() {
		isTongueExtended = false;
		this.setVisible(false); // hide it
	}

	/**
	 * Returns the bounds of the rectangle encapsulating the Tongue
	 * @return bounds rectangle bounds
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * Tongue collides with fly to eat it
	 * @param fly fly
	 * @return if fly was eaten or not
	 */
	public boolean eatFly(Fly fly) {
		if (isTongueExtended && !fly.isEaten() && bounds.intersects(fly.getBounds())) {
			fly.setEaten(true);

			if (gamePanel != null) {
				gamePanel.increaseScore(10);
			}
			return true;
		}
		return false;
	}

	/**
	 * Tongue collides with bee to eat it
	 * @param bee bee colliding with tongue
	 */
	public void checkBeeCollision(List<Bee> bees) {
		if (isTongueExtended && !hasAlreadyHit) {
			for (Bee bee : bees) {
				if (bounds.intersects(bee.getBounds())) {
					if (gamePanel != null && gamePanel.getLizard() != null) {
						gamePanel.getLizard().takeDamage();
						gamePanel.checkGameOver();
						bee.setHasDamaged(true);
						hasAlreadyHit = true;
						System.out.println("Ouch! The lizard took damage!");
					}
				}
			}
		}
	}

	/**
	 * Returns state of tongue if it's extended or not
	 * @return state of tongue
	 */
	public boolean isExtended() {
		return isTongueExtended;
	}
}
