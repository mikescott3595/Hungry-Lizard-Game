import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class Health extends JPanel
{
	// fields
	private int hearts; // keeps track of how many hearts there should be
	private ImageIcon heartImage = new ImageIcon("heart.png"); // imports heart image
	private ImageIcon damageImage= new ImageIcon("damage.png"); // imports damage image
	private JPanel healthPanel;
	
	/**
	 * Constructor for a Health
	 * @param panel
	 */
	public Health()
	{
		
		hearts = 3; // sets starting number of hearts to three
		
		// transparent panel to store hearts
		healthPanel = new JPanel();
		healthPanel.setLayout(new GridLayout(1, 3));
		healthPanel.setOpaque(false); // transparent background
		healthPanel.setBounds(600, 0, 200, 60); // location and size of panel
		// add PNGs
		for (int i = 0; i < hearts; i++)
		{
			JLabel label = new JLabel(heartImage);
			healthPanel.add(label);
		}
		
	}
	
	/**
	 * Method that updates hearts and panel if Lizard takes damage
	 */
	public void damage()
	{
		hearts--;
		
		// updates health panel
		if (hearts == 2)
		{
			JLabel target = (JLabel) healthPanel.getComponent(2);
			target.setIcon(damageImage); // sets the last heart to empty
		}
		if (hearts == 1)
		{
			for (int i = 1; i < 3; i++)
			{
				JLabel target = (JLabel) healthPanel.getComponent(i);
				target.setIcon(damageImage); // sets last two hearts to empty
			}
		}
		if (hearts == 0)
		{
			for (int i = 0; i < 3; i++)
			{
				JLabel target = (JLabel) healthPanel.getComponent(i);
				target.setIcon(damageImage);
			}
		}
	}
	
	/**
	 * Method that returns the health panel
	 * @return healthPanel panel containing heart containers
	 */
	public JPanel getPanel()
	{
		return healthPanel;
	}
	
	/**
	 * Method that returns current number of hearts
	 * @return hearts current number of hearts
	 */
	public int getHearts()
	{
		return hearts;
	}
}
