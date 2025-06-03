import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

public class Snackaroo
{
	private ArrayList<Fly> flies = new ArrayList<Fly>(); // has flies
     Random random = new Random();
	 private int flyCounter;
	 private Fly f;

    /** 
     * Constructor for Snackaroo
     * @param rows number of rows in the fly grid
     * @param col number of columns in the fly grid
     */
    public Snackaroo() 
    {
       makeFlies();
       Timer t = new Timer(1000, e -> makeFlies());
       t.setRepeats(true);
       t.start();
       flyCounter = 0;
    }

    public void makeFlies()
    {
	    f = new Fly(800, random.nextInt(400 - 0 + 1));
	    flies.add(f);
	    f.move();
	    flyCounter++;
    }
    
    public ArrayList<Fly> getFlies()
    {
	    return flies;
    }
    
    
    
    
//    /**
//     * Returns a list of all Fly objects (for drawing/collision)
//     */
//    public List<Fly> getAllFlies() {
//        List<Fly> allFlies = new ArrayList<>();
//        for (Fly[] row : flies) {
//            for (Fly f : row) {
//                allFlies.add(f);
//            }
//        }
//        return allFlies;
//    }
//       
//    /**
//     * Checks if all flies have been eaten
//     */
//    public boolean allFliesEaten() {
//        for (Fly[] row : flies) {
//            for (Fly fly : row) {
//                if (!fly.isEaten()) return false;
//            }
//        }
//        return true;
//    }
}