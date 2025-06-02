import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOverPanel extends JPanel {
    private JButton restartButton;
    private JButton exitButton;
    private JLabel gameOverLabel;

    public GameOverPanel(GamePanel gamePanel, JFrame mainFrame) {
        setLayout(new BorderLayout());

        // Game over message
        gameOverLabel = new JLabel("Game Over!", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(gameOverLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Restart button
        restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose(); 
                JFrame newFrame = new JFrame("Hungry Lizard Game");
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.setSize(900, 700);
                newFrame.setLocationRelativeTo(null);

                GamePanel newGamePanel = new GamePanel();
                newFrame.add(newGamePanel);

                newFrame.setVisible(true);
            }
        });

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(restartButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);
    }
}

