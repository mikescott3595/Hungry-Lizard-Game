import java.util.ArrayList;
import java.util.List;

public class Snackaroo
{
	private Fly[][] flies;
	private int rows;
	private int col;

    /**
     * Constructor for Snackaroo
     * @param rows number of rows in the fly grid
     * @param col number of columns in the fly grid
     */
    public Snackaroo(int rows, int col) {
        this.rows = rows;
        this.col = col;
        flies = new Fly[rows][col];

        // Create flies in a grid with spacing
        int spacingX = 40;
        int spacingY = 40;
        int startX = 100;
        int startY = 100;

        for (int row = 0; row < rows; row++) {
            for (int cols = 0; col < col; col++) {
                int x = startX + col * spacingX;
                int y = startY + row * spacingY;
                flies[row][col] = new Fly(x, y);
            }
        }
    }

    /**
     * Returns a list of all Fly objects (for drawing/collision)
     */
    public List<Fly> getAllFlies() {
        List<Fly> allFlies = new ArrayList<>();
        for (Fly[] row : flies) {
            for (Fly f : row) {
                allFlies.add(f);
            }
        }
        return allFlies;
    }
       
    /**
     * Checks if all flies have been eaten
     */
    public boolean allFliesEaten() {
        for (Fly[] row : flies) {
            for (Fly fly : row) {
                if (!fly.isEaten()) return false;
            }
        }
        return true;
    }
}



