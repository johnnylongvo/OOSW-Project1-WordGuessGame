package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.WordguessGame;
import view.WordguessPanel;

public class WordguessKeyListener implements ActionListener {

    //private WordguessPanel panel;
    private WordguessPanel panel;
    private WordguessGame wordguess;

    //private int clicks = 0;
    private char[] letters;
    private String guess;
    private int health;

    //define constructor
    public WordguessKeyListener(WordguessPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getNewButton()) {
            //var Wordguess  = new WordguessGame();
            wordguess = new WordguessGame();
            // panel.setBaseball(new BaseballGame());
            // panel.setGameState(BaseballGamePanel.GameState.PLAYING);
            panel.setWordguessGame(wordguess);
            panel.setGameState(WordguessPanel.GameState.PLAYING);

            //String keyString = "" + keys[0] + keys[1] + keys[2];
            String keyWord = wordguess.getSolution();

            int words = keyWord.length();
            guess = "";
            for (int i = 0; i < words; i++) {
                guess += '.';

            }

            letters = new char[words];
            letters = guess.toCharArray();

            panel.getGuessField().setText(guess);
            panel.getGuessField().setFont(new Font("Courier New", Font.BOLD, 20));
            panel.getgamekeyField().setText(keyWord);
            panel.getgamekeyField().setFont(new Font("Courier New", Font.BOLD, 20));
            panel.getgamekeyField().setForeground(Color.orange);
            for (var b : panel.getLetterButtons()) {
                b.setEnabled(true);
            }

            health = wordguess.getHealth();

            panel.getCanvas().setLives(health);
            panel.getCanvas().repaint();

        } else {
            button.setEnabled(false);
            wordguess.setGuess(button.getText().charAt(0));
            boolean correct = false;
            for (int i = 0; i < wordguess.getSolution().length(); i++) {
                if (wordguess.getSolution().charAt(i) == wordguess.getGuess()) {
                    letters[i] = wordguess.getGuess();
                    correct = true;
                }
            }

            if (correct) {
                guess = String.valueOf(letters);
                panel.getGuessField().setText(guess);
                if (!guess.contains(".")) {
                    panel.setGameState(WordguessPanel.GameState.GAMEOVER);
                    panel.getCanvas().repaint();
                }
            } else {
                health--;
                panel.getCanvas().setLives(health);
                if (health == 0) {
                    for (var b : panel.getLetterButtons()) {
                        b.setEnabled(false);
                    }
                    panel.setGameState(WordguessPanel.GameState.GAMEOVER);

                    panel.getCanvas().repaint();

                } else {
                    panel.getCanvas().repaint();
                }
            }
        }

    }

}