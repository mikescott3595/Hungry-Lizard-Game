
public class HungryLizardGame
{
	private Lizard lizard;
	private Gang gang; // bees
	private Snackaroo snackaroo; // flies
	private Health health;
	private ScoreBoard scoreboard;
	
	public HungryLizardGame()
	{
		lizard = new Lizard();
		gang = new Gang();
		snackaroo = new Snackaroo(5,5); //creates grid of flies that is 5x5
		health = new Health();
		scoreboard = new ScoreBoard();
	}
	
}
