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
public class MainMenu extends JFrame
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
		menuButtonsPanel.setLayout(new GridLayout(1, 3));
		// grid for button organization
		//GridLayout buttonGrid = new GridLayout(1, 3); // commented this out for right now
		//menuButtonsPanel.setLayout(buttonGrid); // commented this out for right now
		
		// three buttons to be added with action listeners
		JButton playButton = new JButton("Play");
		playButton.setPreferredSize(new Dimension(80, 80));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// start main game here
				startGame();
			}
		});
		
		JButton exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension(80, 80));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton optionsButton = new JButton("Options");
		optionsButton.setPreferredSize(new Dimension(80, 80));
		optionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// open options menu
			}
		});
		
		// add buttons
		menuButtonsPanel.add(playButton);
		menuButtonsPanel.add(exitButton);
		menuButtonsPanel.add(optionsButton);
		
		add(menuButtonsPanel, BorderLayout.CENTER);
		
		// display window
		setVisible(true);
		
				
		
	}
	
	public void startGame() //starts the game
	{
		dispose();
		GameFrame gameFrame = new GameFrame();
	}
}
