import java.awt.Rectangle;

public class Lizard
{
	private int x, y;
	private int speed;
	private int width = 40;
	private int height = 40;
	private int hearts;
	private HungryLizardGame hungryLizardGame;
	private Tongue tongue;
	
	
	public Lizard(int startX, int startY, HungryLizardGame hungryLizardGame) {
		this.x = startX;
	    this.y = startY;
	    this.speed = 5;
	    this.hearts = 3;
	    this.hungryLizardGame = hungryLizardGame;
	    }
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, width, height);
	}

	public void moveLeft() {
	    x -= speed;
	}

	public void moveRight() {
	    x += speed;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	public void eatFly(Snackaroo snack) {
	    if (!snack.isEaten()) {
	    	hungryLizardGame.updateScore(10);
	    	snack.setEaten(true);
	     }
	}
	
	public void takeDamage()
	{
		hungryLizardGame.takeDamage();
	}

}

