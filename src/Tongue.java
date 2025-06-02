import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.List;

public class Tongue extends JLabel
{
	private static final long serialVersionUID = 1L;

    private Boolean isTongueExtended;
    private ImageIcon tongue = new ImageIcon("tongue.png");
    private Rectangle bounds;
    private int x;
    private int y;
    private GamePanel gamePanel;

    public Tongue(int startX, int startY, GamePanel panel) {
        this.isTongueExtended = false;
        this.bounds = new Rectangle(startX + 15, startY - 40, 10, 40);
        this.gamePanel = panel;

        //  Make this JLabel visible
        this.setIcon(tongue);
        this.setBounds(startX + 15, startY - 40, 10, 40);
        this.setVisible(false); // hidden initially
        System.out.println("Tongue image width: " + tongue.getIconWidth());
    }

    public void extendedTongue(int lizardx, int lizardy)
    {
    	isTongueExtended = true;
        this.x = lizardx;
        this.y = lizardy;

        int tongueX = x + (40 / 2) - (10 / 2); 
        int tongueY = y - 10; 

        bounds.setLocation(tongueX, tongueY);
        this.setLocation(tongueX, tongueY);

        this.setVisible(true);
        System.out.println("Tongue positioned at: " + tongueX + ", " + tongueY);
    }

    public void retractedTongue()
    {
        isTongueExtended = false;
        this.setVisible(false); //  hide it
    }

    public Rectangle getBounds()
    {
        return bounds;
    }

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

    public void checkBeeCollision(List<Bee> bees) {
        if (isTongueExtended) {
            for (Bee bee : bees) {
                if (bounds.intersects(bee.getBounds())) {
                    if (gamePanel != null && gamePanel.getLizard() != null) {
                        gamePanel.getLizard().takeDamage();
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
