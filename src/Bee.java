import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;

public class Bee
{
	private int x, y;
	private boolean isDead;
	private int width = 30;
	private int height = 30;
	
	///Constructors///
	public Bee(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isDead = false;
	}
	
	
	/**
	 * this method handles bee movement 
	 */
	public void move()
	{
		x -= 2;
	}
	
	public boolean collidesWith(Lizard lizard)
	{
		return getBounds().intersects(lizard.getBounds());
	}
	
	public boolean isDead()
	{
		return isDead;
	}
	
	public void setDead(boolean dead)
	{
		isDead = dead;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, width, height);
	}
	
	public int getX() 
	{ 
		return x; 
	}
	public int getY() 
	{ 
		return y; 
	}
}
