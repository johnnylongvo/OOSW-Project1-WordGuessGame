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
            g2.setFont(new Font("Courier New", Font.BOLD, 35));
            g2.drawString("Press <New> to Start", 80, 80);
        } else {
            //display msg for GAMEOVER
            if (state == WordguessPanel.GameState.GAMEOVER) {
                g2.clearRect(4, 50, WIDTH, HEIGHT);
                g2.setColor(Color.cyan);
                g2.setFont(new Font("Courier New", Font.BOLD, 32));
                if (healthCount == 0) {
                    displaymessage = "Sorry, You Lost!";
                } else if (healthCount != 0) {
                    displaymessage = "Congratulations, You Won!";
                }
                g2.setColor(Color.red);
                g2.drawString(displaymessage, 90, 40);
                g2.setFont(new Font("Courier New", Font.BOLD, 32));
                g2.drawString("Press <New> to Start", 100, 100);
                setBackground(Color.black);
            } else {
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier", Font.BOLD, 45));
                g2.drawString("Health Level", 25, 155);
                for (int i = 0; i < healthCount; i++) {
                    g2.fillRect(i * 85 + 25, 180, 50, 85);
                    setBackground(Color.black);
                }
            }
        }
    }

    public void setLives(int lifeCount) {
        this.healthCount = lifeCount;
    }
}