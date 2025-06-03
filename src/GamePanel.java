import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This is a Project called Hungry Lizard Game. It's based off of the game Galaga
 * Authors: Michael Scott, Olivia Tom
 * Date: 05/14/2025
 */

public class GamePanel extends JPanel implements KeyListener 
{
    // I created this to handle some of the stuff that happens within the game play
    // GUI which includes movement for lizard

    // fields
    private Lizard lizard; // has-a lizard
    private Gang gang;
    private Snackaroo snackaroo;
    private int score;
    private JLabel scoreLabel;
    private Image backgroundImage;

     
    /**
     * Constructor for a GamePanel
     */
    public GamePanel()
    {
        // panel that game will be in
        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();
        setLayout(null);
        
        backgroundImage = new ImageIcon("dmv.png").getImage();
        
        MusicSound music = new MusicSound();
        music.playLoop("Fushigi Ball Commercial music.wav");
        
        // add lizard to game panel
        this.lizard = new Lizard(400, 550, this);
        this.add(lizard);
        this.add(lizard.getTongue());
        
        // add health to game panel
        this.add(lizard.getHealthPanel());
        this.setComponentZOrder(lizard.getTongue(), 0); // tongue at front
        
        this.gang = new Gang();
        this.snackaroo = new Snackaroo();
        
     // Bee adding mechanism
        Timer beeAdder = new Timer(50, new ActionListener() {
            private int lastCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Bee> currentBees = gang.getBees();

                // Add new bees to panel
                while (lastCount < currentBees.size()) {
                    add(currentBees.get(lastCount));
                    lastCount++;
                    repaint();
                }

                // Check tongue collision with bees
                if (lizard.getTongue() != null) {
                    lizard.getTongue().checkBeeCollision(currentBees);
                }

                revalidate();
                repaint();
            }
        });
        beeAdder.start();
        
     // Fly adding mechanism
        Timer flyAdder = new Timer(100, new ActionListener() {
            private int lastCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Fly> currentFlies = snackaroo.getFlies();
                while (lastCount < currentFlies.size()) {
                    add(currentFlies.get(lastCount));
                    lastCount++;
                    repaint();
                    
                    ArrayList<Fly> currentFlies1 = snackaroo.getFlies(); 
                    for (Fly fly : currentFlies1) {
                        lizard.getTongue().eatFly(fly);
                    }

                }
                revalidate(); 
                repaint();
            }
        });
        flyAdder.start();
        
        score = 0; // start at zero

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBounds(10, 10, 100, 30); // adjust size and position
        this.add(scoreLabel);

        
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
     	   Graphics2D g2d = (Graphics2D) g.create();

             // Set transparency (0.0 = fully transparent, 1.0 = fully opaque)
             float alpha = 0.3f;
             g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

             // Draw the image with transparency
             g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

             g2d.dispose(); // clean up
        }
        
    }
    
    //getter for lizard 
    public Lizard getLizard() {
        return lizard;
    }


    
    /**
     * handles the score 
     * @param amount
     */
    public void increaseScore(int amount) {
        score += amount;
        scoreLabel.setText("Score: " + score);
    }
    
 // Save score
    public void saveScoreToFile() {
        try (java.io.FileWriter writer = new java.io.FileWriter("score.txt")) {
            writer.write(String.valueOf(score));
            System.out.println("Score saved!");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    // Load score
    public void loadScoreFromFile() {
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File("score.txt"))) {
            if (scanner.hasNextInt()) {
                score = scanner.nextInt();
                scoreLabel.setText("Score: " + score);
                System.out.println("Score loaded!");
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("No previous score found.");
        }
    }

    
    /**
     * Method that listens to keystrokes to move Lizard
     * @param e event object
     */
    @Override
    public void keyPressed(KeyEvent e) 
    {

        int key = e.getKeyCode();
        System.out.println("Key pressed: " + key);


        // Move left
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) 
        {
            lizard.move(-lizard.getSpeed());
        } 
        // Move right
        else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) 
        {
            lizard.move(lizard.getSpeed());
        } 
        // Fire the tongue
        else if (key == KeyEvent.VK_SPACE) 
        {
            lizard.eat(); // Extend the tongue
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}