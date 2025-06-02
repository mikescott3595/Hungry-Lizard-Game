import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinPanel extends JPanel {
    private JButton mainMenuButton;
    private JButton exitButton;
    private JLabel winLabel;

    public WinPanel(JFrame mainFrame) {
        setLayout(new BorderLayout());

        // Win message
        winLabel = new JLabel("You Win!", SwingConstants.CENTER);
        winLabel.setFont(new Font("Arial", Font.BOLD, 40));
        add(winLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Main Menu button
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Return to the main menu
                mainFrame.dispose();
                JFrame menuFrame = new JFrame("Hungry Lizard - Main Menu");
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setSize(400, 400);
                menuFrame.setLocationRelativeTo(null);
                menuFrame.add(new MainMenu());
                menuFrame.setVisible(true);
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

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);
    }
}

