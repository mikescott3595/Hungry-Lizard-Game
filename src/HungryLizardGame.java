import javax.swing.JComponent;

/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class HungryLizardGame
{
	private Lizard lizard;
	protected Gang gang; // bees
	private Snackaroo snackaroo; // flies
	private ScoreBoard scoreboard;
     protected int score;
     protected boolean isGameOver;
	    
	public  void startGame()
	{
		
	}
	public  void endGame()
	{
		
	}
	    
	   
	
	//// Constructor ////
	public HungryLizardGame()
	{
		this.lizard = new Lizard(400, 500); // starting position
		this.gang = new Gang();
		this.snackaroo = new Snackaroo(5,5); //creates grid of flies that is 5x5
		this.scoreboard = new ScoreBoard();
		this.isGameOver = false;
		this.score = 0;
	}
	
	public void updateGameState()
	{
		gang.moveGang(); // moves enemies
		gang.checkCollision(lizard); // checks collisions
		
		if (lizard.getHealth() <= 0) // checks if the lizard is dead
		{
			isGameOver = true;
		}
		
		if (lizard.getTongue().isExtended()) // check if tongue has eaten flies
		{
			for (Fly fly : snackaroo.getAllFlies()) // need to create a Fly class like I did with the bees
			{
				if (lizard.getTongue().eatFly(fly))
				{
					updateScore(10);
				}
			}
		}
	}
	
	/**
	 *  resets the game takes the score and brings it back to zero
	 *  returns hearts to 3
	 */
	 public void resetGame() {
	        score = 0;
	        isGameOver = false;
	        lizard = new Lizard(400, 500);
	        gang = new Gang();
	        snackaroo = new Snackaroo(5, 5);
	    }
	
	 /**
	  * updates the score
	  * @param points 
	  */
	 public void updateScore(int points)
	 {
		 score += points;
		 scoreboard.setScore(score); // need to work on set Score
	 }
	 
	/// Getters ///
	public Lizard getLizard()
	{
		return lizard;
	}
	
	public Gang getGang()
	{
		return gang;
	}
	
	public Snackaroo getSnackaroo()
	{
		return snackaroo;
	}
	
	public ScoreBoard getScoreBoard()
	{
		return scoreboard;
	}
	
	public boolean isGameOver()
	{
		return isGameOver;
	}
	
	public int getScore()
	{
		return score;
	}
}


