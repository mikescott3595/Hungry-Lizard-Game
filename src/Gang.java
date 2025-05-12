import java.util.ArrayList;
import java.util.List;

public class Gang extends HungryLizardGame
{
	private List<Gang> bee;
	private boolean isDead;
	
	 public Gang() {
	        bee = new ArrayList<>();
	 }
	
	public void moveGang(){
		for (Gang bee : bee) {
			bee.moveGang();
		}
	}
	
	public void checkCollision(Lizard lizard)
	{
		for (Gang bee : bee)
		{
			if(bee.collidesWith(lizard))
			{
				lizard.takeDamage();
				bee.setDead(true);
			}
		}
	}
	

	public boolean isDead()
	{
		return isDead;
	}
	
	public void setDead(boolean dead)
	{
		// TODO Auto-generated method stub
		isDead = dead;
	}

	@Override
	public void startGame() {
        // Setup the bees
    }

    @Override
    public void updateGameState() {
        moveGang();
    }

    @Override
    public void endGame() {
        // Check if the lizard collided with a bee, end the game if so
    }
}
