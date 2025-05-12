
public class Snackaroo extends HungryLizardGame
{
	private int x, y;
    private boolean isEaten;

    public Snackaroo(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.isEaten = false;
    }

    @Override
    public void startGame() {
        // Position flies in a grid
    }

    @Override
    public void updateGameState() {
        // Update fly behavior, check if eaten, etc.
    }

    @Override
    public void endGame() {
        // Remove fly if eaten
    }

	public boolean isEaten()
	{
		// TODO Auto-generated method stub
		return isEaten;
	}

	public void setEaten(boolean eaten)
	{
		// TODO Auto-generated method stub
		isEaten = eaten;
	}


}
