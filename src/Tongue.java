import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.Rectangle;

/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class Tongue extends JLabel
{
    private Boolean isTongueExtended;
    private ImageIcon tongueImage = new ImageIcon("tongue.png");
    private int x;
    private int y;
    private int width, height;
    private Rectangle bounds;

    public Tongue(int x, int y) 
    {
	   width = tongueImage.getIconWidth();
	   height = tongueImage.getIconHeight();
	   this.x = x;
	   this.y = y;
	   bounds = new Rectangle(x, y, width, height);
	   this.setIcon(tongueImage);
	   this.setBounds(x, y, width, height);
        this.isTongueExtended = false;
        this.setVisible(false);
    }

    
    
    public void extendedTongue(int lizardx, int lizardy)
    {
	    isTongueExtended = true;
	    this.setLocation(lizardx, lizardy);
	    this.setVisible(true);

	    Timer retract = new Timer(150, e -> {
	        isTongueExtended = false;
	        this.setVisible(false);
	    });
	    retract.setRepeats(false);
	    retract.start();
    }
    
    public void setTongueLocation(int x, int y)
    {
        this.setLocation(x, y);
        this.repaint();
    }
    public Rectangle getBounds()
    {
        return bounds;
    }

    public boolean eatFly(Fly fly) {
     	if (isTongueExtended && !fly.isEaten() && getBounds().intersects(fly.getBounds())) {
     	        fly.setEaten(true);
     	        return true;
     	    }
     	    return false;
    }


    public boolean isExtended()
    {
        return isTongueExtended;
    }

}