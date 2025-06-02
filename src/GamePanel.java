import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

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
        
        // add lizard to game panel
        this.lizard = new Lizard(400, 550);
        this.add(lizard);
        
        // add health to game panel
        this.add(lizard.getHealthPanel());
        
        this.gang = new Gang();
        
     // Bee adding mechanism
        Timer beeAdder = new Timer(50, new ActionListener() {
            private int lastCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Bee> currentBees = gang.getBees();
                while (lastCount < currentBees.size()) {
                    add(currentBees.get(lastCount));
                    lastCount++;
                    repaint();
                }
                revalidate(); // make sure Swing re-lays out components
                repaint();
            }
        });
        beeAdder.start();
        
        
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