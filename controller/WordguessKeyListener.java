package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.WordguessGame;
import view.MenuScreen;
import view.WordguessPanel;

public class WordguessKeyListener implements ActionListener {

    private WordguessPanel panel;
    private int clicks = 0;

    public WordguessKeyListener(WordguessPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getNewButton()) {
            var Wordguess  = new WordguessGame();
            panel.setWordguess(new WordguessGame());
            panel.setGameState(WordguessPanel.GameState.PLAYING);

            String keyString = "" + keys[0] + keys[1] + keys[2];
            panel.getGameKeyField().setText(KeyString);
            panel.getGuessField().setText("");
            String wordguess = "_ _ _ _ _ _";

            String keyString = "" + wordguess;
            panel.getGameKeyField().setText(keyString);
            panel.getGuessField().setText(wordguess);
            // enabling letterbuttons
            for (var b : panel.getLetterButtons()) {
                b.setEnabled(true);
            }
            panel.getCanvas().repaint();

            panel.getCanvas().setHealthStrikeCount(0, 0);

            // ask graphics to refresh screen
            panel.getCanvas().repaint();
        } else if (button == panel.getNewButton()) {
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();

        } else {
            // digit button 0 - 9 one of button is clicked
            button.setEnabled(false);

            JTextField guessField = panel.getGuessField();
            if (clicks == 0)
                guessField.setText("");

            WordguessGame wordguess = panel.getWordguess();
            // which button has been clicked, read label
            String n = button.getText();
            guessField.setText(guessField.getText() + n);
            wordguess.setGuess(clicks, n.charAt(0) - '0'); // digit 0 - 0
            clicks++;

            if (clicks == 3) {
                wordguess.computeHealthStrikes();
                int health = wordguess.getHealthCount();
                int livestrikes = wordguess.getLiveStrikeCount();
                panel.getCanvas().setHealthStrikeCount(health, livestrikes);

                // then game over, else continue to play game
                if (livestrikes == 5) {
                    panel.setGameState(WordguessPanel.GameState.GAMEOVER);
                    for (var b : panel.getLetterButtons()) {
                        b.setEnabled(false);
                    }
                } else { // if not gameover, enable all digitButtons
                    for (var b : panel.getLetterButtons()) {
                        b.setEnabled(true);
                    }

                }

                clicks = 0; // another round
                panel.getCanvas().repaint(); // update canvas display

            }

        }
    }
}
