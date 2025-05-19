import java.awt.Rectangle;

public class Lizard extends HungryLizardGame
{
	private int x, y;
	private int speed;
	private int width = 40;
	private int height = 40;

	
	
	public Lizard(int startX, int startY) {
		super();
		this.x = startX;
	    this.y = startY;
	    this.speed = 5;
	    this.hearts = 3;
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
	    	updateScore(10);
	    	snack.setEaten(true);
	     }
	}
	
	public void takeDamage()
	{
		super.takeDamage();
	}

	@Override
	public void startGame() {
	// Initialize or reset specific things for the lizard
		this.x = 300;
		this.y = 500; //test positions
	}

    @Override
	 public void updateGameState() {
	 // Update the lizard's state or check for collisions with bees or flies
	 }

	@Override
	public void endGame() {
    // Handle what happens when the game ends 
	}
}

