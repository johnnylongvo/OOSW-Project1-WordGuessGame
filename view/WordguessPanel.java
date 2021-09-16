package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.WordguessKeyListener;
import model.WordguessGame;

public class WordguessPanel {
    
    public enum GameState {
        READY, PLAYING, GAMEOVER
    }

    private GameState gameState = GameState.READY;

    private WordguessCanvas canvas;

    private WordguessGame wordguessgame;

    char[] letters;

    private JButton[] guessButtons;
    private JButton newButton = new JButton("New");

    // private JTextField gameKeyField = new JTextField();
    // private JTextField guessField = new JTextField();

    private JFrame window;
    private JTextField solutionField = new JTextField();
    private JTextField answerField = new JTextField();

    public WordguessPanel(JFrame window){
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(solutionField);
        solutionField.setEditable(false);
        northPanel.add(answerField);
        answerField.setEditable(false);
        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new WordguessCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));
        ButtonGroup letterGroup = new ButtonGroup();
        WordguessKeyListener listener = new WordguessKeyListener(this);
        guessButtons = new JButton[26];
        for(int i = 0; i < 26; i++){
            guessButtons[i] = new JButton("" + letters[i]);
            guessButtons[i].setEnabled(false);
            guessButtons[i].addActionListener(listener);
            letterGroup.add(guessButtons[i]);
            southPanel.add(guessButtons[i]);
        }
        newButton.addActionListener(listener);
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);

    }

    public WordguessGame getWordguessGame(){
        return wordguessgame;
    }

    public void setWordguessGame(WordguessGame game){
        this.wordguessgame = game;
    }

    public JFrame getWindow(){
        return window;
    }

    public WordguessCanvas getCanvas(){
        return canvas;
    }

    public JTextField getSolutionField(){
        return solutionField;
    }

    public JTextField getGuessField(){
        return answerField;
    }

    public JButton[] getGuessButtons(){
        return guessButtons;
    }

    public JButton getNewButton(){
        return newButton;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState state){
        this.gameState = state;
    }
}