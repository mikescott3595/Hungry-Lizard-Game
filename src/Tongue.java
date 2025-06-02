import javax.swing.ImageIcon;
import java.awt.Rectangle;

/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
public class Tongue 
{
    private Boolean isTongueExtended;
    private ImageIcon tongue = new ImageIcon("tongue.png");
    private Rectangle bounds;
    private int x;
    private int y;
    
    public Tongue(int startX, int startY) {
        this.isTongueExtended = false;
        
        this.bounds = new Rectangle(x,y - 40, 10, 40); // these are just tests we need to figure out how to have the tongue go up
    }
    
    
    public void extendedTongue(int lizardx, int lizardy)
    {
        isTongueExtended = true;
        this.x = lizardx;
        this.y = lizardy;
        bounds.setLocation(x + 15, y - 40); // this is just a test point 
    }
    
    public void retractedTongue()
    {
        isTongueExtended = false;
    }
    public Rectangle getBounds()
    {
        return bounds;
    }

    // method for eating flies
    public boolean eatFly(Fly fly) {
        if (isTongueExtended && !fly.isEaten() && bounds.intersects(fly.getBounds())) {
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