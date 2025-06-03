import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

/**
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Shows the total amount of points accrued
 *         in the game.
 */
public class ScoreBoard
{
	// fields
	private int score;
	private JLabel scoreLabel;
	private JPanel scorePanel;

	/*************************************** constructors **************************************/
	
	/**
	 * Constructor for the ScoreBoard. Initializes the score to 0 and sets up the
	 * display panel.
	 */
	public ScoreBoard()
	{
		score = 0;
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 16)); // we can change the font went with Arial just as a
													// placeholder

		scorePanel = new JPanel();
		scorePanel.add(scoreLabel);
	}

	/*************************************** methods **************************************/
	
	/**
	 * Updates the score value and refreshes the label text to show the new score.
	 * 
	 * @param score the new score value to set
	 */
	public void setScore(int score) {
		this.score = score;
		scoreLabel.setText("Score: " + score);
	}

	/**
	 * Returns the current score value (useful for tracking or saving).
	 * 
	 * @return the current score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Returns the panel containing the score label. This can be added to a JFrame
	 * or JPanel in the UI.
	 * 
	 * @return JPanel with the score label
	 */
	public JPanel getPanel() {
		return scorePanel;
	}
}