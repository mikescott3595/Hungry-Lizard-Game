/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public abstract class HungryLizardGame
{
	private Lizard lizard;
	protected Gang gang; // bees
	private Snackaroo snackaroo; // flies
	private Health health;
	protected int hearts;
	private ScoreBoard scoreboard;
     protected int score;
     protected boolean isGameOver;
	    
	public abstract void startGame();
	public abstract void updateGameState();
	public abstract void endGame();
	    
	   
	
	//// Constructor ////
	public HungryLizardGame()
	{
		lizard = new Lizard(hearts, hearts);
		gang = new Gang();
		snackaroo = new Snackaroo(5,5); //creates grid of flies that is 5x5
		health = new Health();
		scoreboard = new ScoreBoard();
	}
	
	/**
	 *  resets the game takes the score and brings it back to zero
	 *  returns hearts to 3
	 */
	 public void resetGame() {
	        score = 0;
	        hearts = 3;
	        isGameOver = false;
	    }
	
	 /**
	  * updates the score
	  * @param points 
	  */
	 public void updateScore(int points)
	 {
		 score += points;
	 }
	 
	 
	 /**
	  * this method handles the damage. If your hearts are > than zero you can take damage 
	  * if your hearts == 0 then it's gameover
	  */
	 public void takeDamage()
	 {
		 if (hearts > 0)
		 {
			 hearts --;
		 }
		 
	 if (hearts == 0)
	 {
		 isGameOver = true;
	  }
	 }
}


