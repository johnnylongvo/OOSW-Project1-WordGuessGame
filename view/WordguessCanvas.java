package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WordguessCanvas extends JPanel {

    // size of canvas panel
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    // private int health = 0;
    // private int livestrikes = 0;
    private int healthCount;
    private String displaymessage;

    private WordguessPanel panel;

    public WordguessCanvas(final WordguessPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        WordguessPanel.GameState state = panel.getGameState();
        if (state == WordguessPanel.GameState.READY) {
            // displaying word
            g2.setColor(Color.blue);
            // setting fontsize
            g2.setFont(new Font("Courier New", Font.BOLD, 40));
            g2.drawString("Press <New> to Start", 68, 150);
        } else {
            //display msg for GAMEOVER
            if (state == WordguessPanel.GameState.GAMEOVER) {
                g2.clearRect(5, 5, WIDTH, HEIGHT);
                g2.setColor(Color.cyan);
                g2.setFont(new Font("Courier New", Font.BOLD, 40));
                if (healthCount == 0) {
                    displaymessage = "Sorry, You Lost!";
                } else if (healthCount != 0) {
                    displaymessage = "Congratulations, You Won!";
                }
                g2.setColor(Color.red);
                g2.drawString(displaymessage, 90, 40);
                g2.setFont(new Font("Courier New", Font.BOLD, 40));
                g2.drawString("Press <New> to Start", 100, 100);
            } else {
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier", Font.BOLD, 45));
                g2.drawString("Health Level", 20, 150);
                for (int i = 0; i < healthCount; i++) {
                    g2.fillRect(i * 70 + 20, 190, 50, 50);
                    setBackground(Color.black);
                }
            }
        }
    }

    public void setLives(int lifeCount) {
        this.healthCount = lifeCount;
    }
}