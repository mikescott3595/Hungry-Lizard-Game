import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Fly {
    private int x, y;
    private int width = 20, height = 20;
    private boolean isEaten;
    private JLabel flyLabel;
    //private ImageIcon flyImage = new ImageIcon(); // add fly image please

    public Fly(int x, int y) {
        this.x = x;
        this.y = y;
        this.isEaten = false;

        //flyLabel = new JLabel(flyImage); uncomment this and replace fly image with the actual picture 
        flyLabel.setBounds(x, y, width, height);
    }

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        this.isEaten = eaten;
        flyLabel.setVisible(!eaten);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public JLabel getFlyLabel() {
        return flyLabel;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

