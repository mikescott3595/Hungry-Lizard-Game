import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Object;

public class Bee extends JLabel
{
	private int x, y;
	private boolean isDead;
	private ImageIcon beeImage;
	private int moveCount;
	private Direction currDir;
	JLabel label;
	Random rand = new Random();
	
	///Constructors///
	public Bee(int x, int y)
	{
		beeImage = new ImageIcon("bee.png");
		label = new JLabel(beeImage);
		label.setBounds(x, y, beeImage.getIconWidth(), beeImage.getIconHeight());
		this.setLayout(null);
		this.setBounds(x, y, beeImage.getIconWidth(), beeImage.getIconHeight()); // Ensures bee JPanel has correct bounds
	     this.add(label);
		
		this.x = x;
		this.y = y;
		this.isDead = false;
		this.currDir = Direction.WEST; // defsult direction
		this.repaint();
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
			this.y += 5;
		}
		if (directionNumber == 1)
		{
			currDir = Direction.EAST;
			this.x += 5;
		}
		if (directionNumber == 2)
		{
			currDir = Direction.SOUTH;
			this.y -= 5;
		}
		else
		{
			currDir = Direction.WEST;
			this.x -= 10;
		}

		label.setLocation(x, y);
		label.repaint();
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
	
//	public Rectangle getBounds()
//	{
//		return new Rectangle(x, y, width, height);
//	}
	
	public int getX() 
	{ 
		return x; 
	}
	public int getY() 
	{ 
		return y; 
	}
}
