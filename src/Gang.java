import java.util.ArrayList;
import java.util.List;


/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class Gang 
{
	private List<Bee> bees;
	
	 public Gang() {
	        bees = new ArrayList<>();
	        for (int i = 0; i < 5; i++)
	        {
	        	bees.add(new Bee(600 + i * 50, 100, 30, 30));
	        }
	 }
	
	public void moveGang(){
		for (Bee bee : bees) {
			bee.move();
		}
	}
	
	public void checkCollision(Lizard lizard)
	{
		for (Bee bee : bees)
		{
			if(!bee.isDead() && bee.collidesWith(lizard))
			{
				lizard.takeDamage();
				bee.setDead(true);
			}
		}
	}
	

	public List<Bee> getBees()
	{
		return bees;
	}

}
