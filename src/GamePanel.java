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
	private Lizard lizard; // has-a lizard

	/**
	 * Constructor for a GamePanel
	 */
	public GamePanel()
	{
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		addKeyListener(this);
		requestFocusInWindow();

		int startX = (getWidth() - 60) / 2; // center horizontally
		int startY = getHeight() - 60 - 10; // 10px up from bottom
		
		// add lizard to game panel
		this.lizard = new Lizard(startX, startY);
		JLabel lizLabel = lizard.getLizard();
		lizLabel.setBounds(startX, startY, 60, 60);
		add(lizLabel);
		// add health to game panel
		JPanel hp = lizard.getHealthPanel();
		hp.setBounds(10, 10, hp.getPreferredSize().width, hp.getPreferredSize().height);
		    add(hp);
	}
	
//	@Override
//	public void paintComponent(Graphics g) 
//	{
//	    super.paintComponent(g);
//	    lizard.draw(g);
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