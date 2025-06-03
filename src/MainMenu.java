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
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Displays the game's main menu.
 */

public class MainMenu extends JFrame implements ActionListener
{

	// fields
	final int WINDOW_WIDTH = 900;
	final int WINDOW_HEIGHT = 700;

	/*************************************** constructors **************************************/
	
	/**
	 * Constructor for a MainMenu
	 */
	public MainMenu()
	{
		super("Hungry Lizard - Main Menu");

		// window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// set to end when the window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// lays out all components and resizes window
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

		setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null); // centers the window on screen
		setVisible(true);
		pack();

		// title
		JPanel menuTitlePanel = new JPanel();
		JLabel menuTitleLabel = new JLabel("Main menu");
		menuTitlePanel.add(menuTitleLabel);
		this.add(menuTitlePanel, BorderLayout.NORTH);

		// buttons
		JPanel menuButtonsPanel = new JPanel();
		menuButtonsPanel.setLayout(new GridLayout(3, 1));

		JButton startButton = new JButton("Start");
		startButton.setPreferredSize(new Dimension(150, 20));

		JButton exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(150, 20));

		JButton optionsButton = new JButton("Options");
		optionsButton.setPreferredSize(new Dimension(150, 20));

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

		// display window
		setVisible(true);
	}

	/*************************************** methods **************************************/
	
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MainMenu();
	}

	/**
	 * Method that listens to event objects
	 * 
	 * @param e event object
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command)
		{
		case "Start":
			// close the menu
			this.dispose();

			// create and show game window
			JFrame gameFrame = new JFrame("Hungry Lizard Game");
			GamePanel gamePanel = new GamePanel(); // launches the game

			gameFrame.add(gamePanel);
			gameFrame.setSize(900, 700);
			gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gameFrame.setLocationRelativeTo(null);

			gameFrame.setVisible(true);

			gamePanel.requestFocusInWindow(); // This ensures key input goes to the game

			break;

		case "Exit":
			System.exit(0);
			break;

		case "Options":
			JOptionPane.showMessageDialog(this, "Options menu coming soon!");
			break;
		}
	}
}
