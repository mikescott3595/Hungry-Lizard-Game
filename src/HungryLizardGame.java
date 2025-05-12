
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
	    
	public abstract void startGame()
	public abstract void updateGameState();
	public abstract void endGame();
	    
	   
	
	
	public HungryLizardGame()
	{
		lizard = new Lizard(hearts, hearts);
		gang = new Gang();
		snackaroo = new Snackaroo(5,5); //creates grid of flies that is 5x5
		health = new Health();
		scoreboard = new ScoreBoard();
	}
	
	 public void resetGame() {
	        score = 0;
	        hearts = 3;
	        isGameOver = false;
	    }
	
	 
	 public void updateScore(int points)
	 {
		 score += points;
	 }
	 
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


