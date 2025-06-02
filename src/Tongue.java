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
    private GamePanel gamePanel;

    public Tongue(int startX, int startY, GamePanel panel) {
        this.isTongueExtended = false;
        this.bounds = new Rectangle(startX, startY - 40, 10, 40);
        this.gamePanel = panel; // 💡 Store the reference to update score
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
            
            if (gamePanel != null) {
                gamePanel.increaseScore(10);
            }
            return true;
        }
        return false;
    }


    public boolean isExtended()
    {
        return isTongueExtended;
    }

}