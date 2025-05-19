import javax.swing.JFrame;


/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class GameFrame extends JFrame 
	{ //still need to add to this but created this to be the game play gui
	
		// Game play GUI
		public GameFrame()
		{
			setSize(800, 600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			add(new GamePanel());
			setVisible(true);
		}
	}
