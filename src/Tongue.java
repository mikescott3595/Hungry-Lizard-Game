
public class Tongue extends Lizard
{
	private Boolean isTongueExtended;
	
	public Tongue(int startX, int startY) {
		super(startX, startY);
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
			updateScore(15);
			snack.setEaten(true);
		}
	        
	 }
}

