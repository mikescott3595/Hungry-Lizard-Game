import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class MainMenu extends JFrame implements ActionListener
{
	// fields
	final int WINDOW_WIDTH = 200;
	final int WINDOW_HEIGHT = 200;
	//private HungryLizardGame game;  // commented this out for right now to test some things
	
	/**
	 * Constructor for a MainMenu
	 */
	public MainMenu()
	{
		super("Hungry Lizard - Main Menu");
		// new frame
		//JFrame frame = new JFrame("Main menu"); // commented this out for right now 
		// window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// set to end when the window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// lays out all components and resizes window
		pack();
		
		/***********************************************************************/
		
		// adds border layout to the main JFrame
		setLayout(new BorderLayout()); 
		
		/***********************************************************************/
		
		// title //
		
		JPanel menuTitlePanel = new JPanel();
		JLabel menuTitleLabel = new JLabel("Main menu");
		menuTitlePanel.add(menuTitleLabel);
		this.add(menuTitlePanel, BorderLayout.NORTH);
		
		/***********************************************************************/
		
		// buttons //
		
		// panel
		JPanel menuButtonsPanel = new JPanel();
		menuButtonsPanel.setLayout(new GridLayout(3, 1));
		// grid for button organization
		//GridLayout buttonGrid = new GridLayout(1, 3); // commented this out for right now
		//menuButtonsPanel.setLayout(buttonGrid); // commented this out for right now

		
		// three buttons
		JButton startButton = new JButton("Start");
		startButton.setPreferredSize(new Dimension(80, 80));

		JButton exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(80, 80));

		
		JButton optionsButton = new JButton("Options");
		optionsButton.setPreferredSize(new Dimension(80, 80));
		
		// listeners
		startButton.addActionListener(this);
		exitButton.addActionListener(this);
		optionsButton.addActionListener(this);
		
		// action commands
		startButton.setActionCommand("Start");
		exitButton.setActionCommand("Exit");
		optionsButton.setActionCommand("Options");
		
		// add buttons
		menuButtonsPanel.add(startButton);
		menuButtonsPanel.add(exitButton);
		menuButtonsPanel.add(optionsButton);
		
		add(menuButtonsPanel, BorderLayout.CENTER);
		
		pack();
		
		// display window
		setVisible(true);
		
				
		
	}
	
	public static void main(String[] args)
	{
		new MainMenu();
	}

	/**
	 * Method that listens to event objects
	 * @param e event object
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand();
		
		switch(command)
		{
			case "Start":
				this.dispose(); // closes the menu
				JFrame gameFrame = new JFrame("Hungry Lizard Game");
				GamePanel gamePanel = new GamePanel(); // launches the game
				gameFrame.add(gamePanel);
		          gameFrame.setSize(800, 600);
		          gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		          gameFrame.pack();   // sizes to GamePanel’s preferred size
		          gameFrame.setLocationRelativeTo(null);
		          gameFrame.setVisible(true);
				break;
				
			case "Exit":
				System.exit(0);
				break;
					
			case "Options":
				JOptionPane.showMessageDialog(this, "Options coming soon!");
	            break;
		}
	}
	
	
}
