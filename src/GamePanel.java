import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
	private Lizard lizard;
	private Image lizardImage;

	/// constructor///
	public GamePanel()
	{
		this.lizard = new Lizard(300, 500);
		lizardImage = new ImageIcon("lizard.png").getImage(); // imports our lizard
		
		setFocusable(true);
		addKeyListener(this);
		requestFocusInWindow();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw the lizard as a rectangle for now
		g.setColor(Color.GREEN);
		g.fillRect(lizard.getX(), lizard.getY(), 40, 40);
	}

	// KeyListener methods being able to move left and right
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			lizard.moveLeft();
		} else if (key == KeyEvent.VK_RIGHT) {
			lizard.moveRight();
		}

		repaint(); // Re-draw after moving
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}