import javax.swing.SwingUtilities;

/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class HungryLizardView
{
	//// Main Method ////
	public static void main(String[] args)
	{
		
		SwingUtilities.invokeLater(() -> new MainMenu());
	}
}
