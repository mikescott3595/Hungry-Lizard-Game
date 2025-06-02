import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Object;

public class Bee extends JLabel
{
	private int x, y;
	private boolean isDead;
	private ImageIcon beeImage = new ImageIcon("bee.png");;
	private int moveCount;
	private Direction currDir;
	JLabel label;
	Random rand = new Random();
	private int width, height;
	
	///Constructors///
	public Bee(int x, int y)
	{
		width = beeImage.getIconWidth();
		height = beeImage.getIconHeight();
		this.x = x;
		this.y = y;
		this.setIcon(beeImage);
		this.setBounds(x, y, width, height);
		this.isDead = false;
		this.currDir = Direction.WEST; // default direction
	}
	
	
	/**
	 * this method handles bee movement 
	 */
	public void move()
	{
		int directionNumber = rand.nextInt(4);
		 
		if (directionNumber == 0)
		{
			currDir = Direction.NORTH;
			this.y += 15;
		}
		if (directionNumber == 1) 
		{
			currDir = Direction.EAST;
			this.x += 15;
		}
		if (directionNumber == 2)
		{
			currDir = Direction.SOUTH;
			this.y -= 15;
		}
		else
		{
			currDir = Direction.WEST;
			this.x -= 20;
		}

		this.setLocation(x, y);
		this.repaint();
		
		if (x < 800)
		{
			Timer t = new Timer(100, e -> move());
			t.setRepeats(false);
			t.start();
		}
		else
		{
			setVisible(false);
		}
	}
	
	private boolean hasDamaged = false;

	public boolean hasDamagedLizard() {
	    return hasDamaged;
	}

	public void setHasDamaged(boolean damaged) {
	    this.hasDamaged = damaged;
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
