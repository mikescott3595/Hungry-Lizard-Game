import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lizard extends JLabel
{
    private int x, y;
    private int speed;
    private int width;
    private int height;
    private ImageIcon lizardImage = new ImageIcon("lizard.png");
    private JLabel lizardLabel;
    private Health health; // has-a health
    private Tongue tongue; // has-a tongue
    private GamePanel gamePanel;


    /**
     * Constructor for a Lizard
     * @param startX starting x coordinate for the Lizard
     * @param startY starting y coordinate for the Lizard
     */
    public Lizard(int startX, int startY, GamePanel panel)
    {
        //super();
        this.x = startX;
        this.y = startY;
        this.speed = 15;
        this.gamePanel =  panel;
        this.tongue = new Tongue(x,y, gamePanel);
        this.setIcon(lizardImage);
        width = lizardImage.getIconWidth();
        height = lizardImage.getIconHeight();
        this.setBounds(x, y, width, height);
        this.health = new Health(); // gives lizard health starting at 3 hearts
    }
    
    /**
     * Method that moves the lizard
     * @param dx where the lizard will move in the x direction
     */
    public void move(int dx) 
    {
    	x += dx;                      // 1️⃣ update x position
    	this.setLocation(x, y);       // 2️⃣ update JLabel position
    	this.repaint();               // 3️⃣ repaint the component
    }
    
    public Rectangle getBounds() 
    {
        return new Rectangle(getLizard().getX(), getLizard().getY(), 40, 40); // add the size of the actual sprite
    }


    public void eat()
    {
        tongue.extendedTongue(getX(), getY());
    }
    
    /**
     * Method that updates the hearts in the health panel
     */
    public void takeDamage()
    {
        health.damage();
    }

    /**
     * Method that returns the JPanel displaying the heart containers
     * @return the panel displaying Lizard's health
     */
    public JPanel getHealthPanel()
    {
        return health.getPanel();
    }
    
    /**
     * Method that returns the current health of the lizard
     * @return the number of hearts
     */
    public int getHealth()
    {
        return health.getHearts();
    }
    
    /**
     * Method that returns the Lizard label which contains icon
     * @return lizardLabel lizard icon
     */
    public JLabel getLizard()
    {
        return lizardLabel;
    }
    
    public int getSpeed()
    {
    	return speed;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    /// Getters ///
    public Tongue getTongue()
    {
        return tongue;
    }
    
    //@Override
    //public void startGame() {
    // Initialize or reset specific things for the lizard
//        this.x = 300;
//        this.y = 500; //test positions
//    }
//
//    @Override
//     public void updateGameState() {
//     // Update the lizard's state or check for collisions with bees or flies
//     }
//
//    @Override
//    public void endGame() {
//    // Handle what happens when the game ends 
//    }
}