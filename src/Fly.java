import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Fly extends JLabel
{
    private int x, y;
    private int width, height;
    private boolean isEaten;
    private ImageIcon flyImage = new ImageIcon("fly.png");;
    private Direction currDir;
    Random rand = new Random();

    public Fly(int x, int y) 
    {
        this.x = x;
        this.y = y;
        this.isEaten = false;
        width =  flyImage.getIconWidth();
        height = flyImage.getIconHeight();
        this.setIcon(flyImage);
        this.setBounds(x, y, width, height);
        this.currDir = Direction.WEST; // default direction
    }
    

	/**
	 * this method handles fly movement 
	 */
	public void move()
	{
		int directionNumber = rand.nextInt(4);
		
		if (directionNumber == 0)
		{
			currDir = Direction.NORTH;
			this.y += 7;
		}
		if (directionNumber == 1)
		{
			currDir = Direction.EAST;
			this.x += 7;
		}
		if (directionNumber == 2)
		{
			currDir = Direction.SOUTH;
			this.y -= 7;
		}
		else
		{
			currDir = Direction.WEST;
			this.x -= 10;
		}

		this.setLocation(x, y);
		this.repaint();
		
		if (x < 800)
		{
			Timer t = new Timer(50, e -> move());
			t.setRepeats(false);
			t.start();
		}
		else
		{
			setVisible(false);
		}
	}

    public boolean isEaten() {
        return isEaten;
    }


//    public void setEaten(boolean eaten) {
//        this.isEaten = eaten;
//        flyLabel.setVisible(!eaten);
//    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    public int getX() { return x; }
    public int getY() { return y; }
}

