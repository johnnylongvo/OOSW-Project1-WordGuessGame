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

    private int health = 0;
    private int livestrikes = 0;

    private WordguessPanel panel;

    // define constructor method
    public WordguessCanvas(WordguessPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // custom drawing

        Graphics2D g2 = (Graphics2D) g;

        // ready to play game
        WordguessPanel.GameState state = panel.getGameState();
        if (state == WordguessPanel.GameState.READY) {
            // displaying word
            g2.setColor(Color.cyan);
            // setting font size
            g2.setFont(new Font("Courier", Font.BOLD, 30));
            g2.drawString("Click ~Play~ to Start", 68, 150);
        } else {

            // display msg for GAMEOVER
            if (state == WordguessPanel.GameState.GAMEOVER) {
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier", Font.BOLD, 30));
                g2.drawString("Game Over", 150, 160);
            }

            g2.setColor(Color.cyan);
            g2.setFont(new Font("Courier", Font.BOLD, 14));
            // draw ball
            g2.drawString("Health: " + health, 20, 100);
            for (int i = 0; i < 3; i++) {
                if (i < health)
                    g2.fillOval(i * 140 + 100, 80, 50, 50);
                else
                    g2.drawOval(i * 140 + 100, 80, 50, 50);
            }
            // draw Strikes
            g2.drawString("Strikes: " + livestrikes, 20, 200);
            for (int i = 0; i < 3; i++) {
                if (i < livestrikes)
                    g2.fillOval(i * 140 + 100, 180, 50, 50);
                else
                    g2.drawOval(i * 140 + 100, 180, 50, 50);
            }
        }

    }

    public void setHealthStrikeCount(int health, int livestrikes) {
        this.health = health;
        this.livestrikes = livestrikes;
    }

}
