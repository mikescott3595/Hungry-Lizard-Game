/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class Tongue 
{
	private Boolean isTongueExtended;
	private ImageIcon tongue = new ImageIcon("tongue.png");
	
	public Tongue(int startX, int startY) {
		this.isTongueExtended = false;
	}
	
	
	public void extendedTongue()
	{
		isTongueExtended = true;
	}
	
	public void retractedTongue()
	{
		isTongueExtended = false;
	}

	// method for eating flies and updating score
	public void eatFly(Snackaroo snack) {
		if (isTongueExtended && !snack.isEaten())
		{
			snack.setEaten(true);
		}
	        
	 }
}

