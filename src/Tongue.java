import javax.swing.ImageIcon;
import javax.swing.JLabel;
<<<<<<< HEAD
import javax.swing.Timer;

=======
>>>>>>> refs/remotes/origin/main
import java.awt.Rectangle;
import java.util.List;

<<<<<<< HEAD
/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */
=======
>>>>>>> refs/remotes/origin/main
public class Tongue extends JLabel
{
	private static final long serialVersionUID = 1L;

    private Boolean isTongueExtended;
    private ImageIcon tongueImage = new ImageIcon("tongue.png");
    private int x;
    private int y;
<<<<<<< HEAD
    private int width, height;
    private Rectangle bounds;
=======
    private GamePanel gamePanel;
    private boolean hasAlreadyHit = false;

>>>>>>> refs/remotes/origin/main

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
<<<<<<< HEAD
        this.setVisible(false);
=======
        this.bounds = new Rectangle(startX + 15, startY - 40, 10, 40);
        this.gamePanel = panel;

        //  Make this JLabel visible
        this.setIcon(tongue);
        this.setBounds(startX + 15, startY - 40, 10, 40);
        this.setVisible(false); // hidden initially
        System.out.println("Tongue image width: " + tongue.getIconWidth());
>>>>>>> refs/remotes/origin/main
    }

    public void extendedTongue(int lizardx, int lizardy)
    {
<<<<<<< HEAD
	    isTongueExtended = true;
	    this.setLocation(lizardx, lizardy);
	    this.setVisible(true);

	    Timer retract = new Timer(150, e -> {
	        isTongueExtended = false;
	        this.setVisible(false);
	    });
	    retract.setRepeats(false);
	    retract.start();
=======
        isTongueExtended = true;
        this.x = lizardx;
        this.y = lizardy;
        hasAlreadyHit = false; 

        
        int tongueX = x + (40 / 2) - (10 / 2);

       
        int tongueHeight = 550; 
        int tongueY = y - tongueHeight + 40; 

      
        bounds.setBounds(tongueX, tongueY, 10, tongueHeight);
        this.setBounds(tongueX, tongueY, 10, tongueHeight);

        this.setVisible(true);

        System.out.println("Tongue positioned at: " + tongueX + ", " + tongueY + ", height: " + tongueHeight);
>>>>>>> refs/remotes/origin/main
    }
<<<<<<< HEAD
    
    public void setTongueLocation(int x, int y)
=======

    public void retractedTongue()
>>>>>>> refs/remotes/origin/main
    {
<<<<<<< HEAD
        this.setLocation(x, y);
        this.repaint();
=======
        isTongueExtended = false;
        this.setVisible(false); //  hide it
>>>>>>> refs/remotes/origin/main
    }

    public Rectangle getBounds()
    {
        return bounds;
    }

    public boolean eatFly(Fly fly) {
<<<<<<< HEAD
     	if (isTongueExtended && !fly.isEaten() && getBounds().intersects(fly.getBounds())) {
     	        fly.setEaten(true);
     	        return true;
     	    }
     	    return false;
=======
        if (isTongueExtended && !fly.isEaten() && bounds.intersects(fly.getBounds())) {
            fly.setEaten(true);

            if (gamePanel != null) {
                gamePanel.increaseScore(10);
            }
            return true;
        }
        return false;
>>>>>>> refs/remotes/origin/main
    }

    public void checkBeeCollision(List<Bee> bees) {
        if (isTongueExtended && !hasAlreadyHit) {
            for (Bee bee : bees) {
                if (bounds.intersects(bee.getBounds())) {
                    if (gamePanel != null && gamePanel.getLizard() != null) {
                        gamePanel.getLizard().takeDamage();
                        gamePanel.checkGameOver();
                        bee.setHasDamaged(true);
                        hasAlreadyHit = true;
                        System.out.println("Ouch! The lizard took damage!");
                    }
                }
            }
        }
    }

    public boolean isExtended()
    {
        return isTongueExtended;
    }
}