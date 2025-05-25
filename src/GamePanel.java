import java.awt.event.*;
import javax.swing.*;

/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */

public class GamePanel extends JPanel implements KeyListener 
{
	// I created this to handle some of the stuff that happens within the game play
	// gui which includes movement for lizard

	// fields
	private Lizard lizard; // has-a lizard

	/**
	 * Constructor for a GamePanel
	 */
	public GamePanel()
	{
		// panel that game will be in
		JPanel gamePanel = new JPanel();
		setFocusable(true);
		addKeyListener(this);
		requestFocusInWindow();
		
		// add lizard to game panel
		Lizard lizard = new Lizard(400, 590);
		gamePanel.add(lizard.getLizard());
		
		// add health to game panel
		gamePanel.add(lizard.getHealthPanel());
	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		// Draw the lizard as a rectangle for now
//		g.setColor(Color.GREEN);
//		g.fillRect(lizard.getX(), lizard.getY(), 40, 40);
//	}

	/**
	 * Method that listens to keystrokes to move Lizard
	 * @param e event object
	 */
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) 
		{
			lizard.move(-5); // left
		} 
		else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) 
		{
			lizard.move(5); // right
		}
		else if (key == KeyEvent.VK_SPACE)
		{
			lizard.eat(); // eat
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}