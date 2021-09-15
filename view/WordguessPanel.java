package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.WordguessKeyListener;
import model.WordguessGame;

public class WordguessPanel {

    public enum GameState {
        READY, PLAYING, GAMEOVER
    }

    private JFrame window;
    private WordguessCanvas canvas;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private JButton[] letterButtons;
    private JButton playButton = new JButton("Play Game");
    private JButton newButton = new JButton("New");
    private GameState gameState = GameState.READY;

    private WordguessGame wordguess;

    public WordguessPanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("KeyWord: "));
        northPanel.add(gameKeyField);
        northPanel.add(new JLabel("YourGuess: "));
        northPanel.add(guessField);
        gameKeyField.setEditable(false);
        guessField.setEditable(false);

        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new WordguessCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        // add buttons on S of content panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        // add button listener
        WordguessKeyListener keyListener = new WordguessKeyListener(this); 

        letterButtons = new JButton[26];
        // assign buttons in each element
        int i = 0;
        for (char letter = 'A'; letter <= 'Z'; letter++, i++) {
            letterButtons[i] = new JButton("" + letter);
            southPanel.add(letterButtons[i]);
            // adding keylistener JButtons
            letterButtons[i].addActionListener(keyListener);

        }

        playButton.addActionListener(keyListener);
        newButton.addActionListener(keyListener);

        southPanel.add(playButton);
        southPanel.add(newButton);
        // add content pane
        cp.add(BorderLayout.SOUTH, southPanel);

        // disable buttons
        for (var b : letterButtons) {
            b.setEnabled(false);
        }
    }

    public WordguessGame getWordguessGame() {
        return wordguess;
    }

    public JFrame getWindow() {
        return window;
    }

    public WordguessCanvas getCanvas() {
        return canvas;
    }

    public JTextField getGameKeyField() {
        return gameKeyField;
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public JButton[] getLetterButtons() {
        return letterButtons;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState state) {
        this.gameState = state;
    }

    public WordguessGame getWordguess() {
        return wordguess;
    }

    public void setWordguess(WordguessGame wordguess) {
        this.wordguess = wordguess;
    }

    public void setwordguess(WordguessGame wordguessGame) {
    }
}