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

    private JFrame window;
    //instance member for canvas 
    //private BaseballCanvas canvas;
    private WordguessCanvas canvas;
    // top of screen dislaying Game
    // private JTextField gameKeyField = new JTextField();
    // private JTextField guessField = new JTextField();
    private JTextField gamekeyField = new JTextField();
    private JTextField guessField = new JTextField();
    // private JButton[] digitButtons;
    private JButton[] letterButtons;

    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
   
    // private JButton playButton = new JButton("Play Ball~~");
    // private JButton exitButton = new JButton("Exit");
    private JButton newButton = new JButton("New");
    private GameState gameState = GameState.READY;

    private WordguessGame wordguessgame;

    public WordguessPanel(JFrame window){
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        JPanel northPanel = new JPanel();
        // northPanel.setLayout(new GridLayout(2,2));
        northPanel.setLayout(new GridLayout(2, 1)); 
        // northPanel.add(new JLabel("Secret Game Key: "));
        //northPanel.add(gameKeyField);
        northPanel.add(gamekeyField);
        gamekeyField.setEditable(false);
        // northPanel.add(new JLabel("Your Guess: "));
        // northPanel.add(guessField);
        northPanel.add(guessField);
        guessField.setEditable(false);
        cp.add(BorderLayout.NORTH, northPanel);

        // canvas = new BaseballCanvas(this);
        // cp.add(BorderLayout.CENTER, canvas);
        canvas = new WordguessCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        //add buttons on S of content panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));
        ButtonGroup letterGroup = new ButtonGroup();
        WordguessKeyListener listener = new WordguessKeyListener(this);

        letterButtons = new JButton[26];
        for(int i = 0; i < 26; i++){
            letterButtons[i] = new JButton("" + letters[i]);
            letterButtons[i].setEnabled(false);

        // int i = 0;
        // for (char letter 'a'; letter <= 'Z'; letter++, i++) {
        //     letterButtons[i] = new JButton("" + letter);
        //     southPanel.add(letterButtons[i]);
        // }

            letterButtons[i].addActionListener(listener);
            letterGroup.add(letterButtons[i]);
            southPanel.add(letterButtons[i]);
        }
        newButton.addActionListener(listener);
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);


        //disable digit buttons S
        //   for (var b: digitButtons) {
        //     b.setEnabled(false);

    }

    public WordguessGame getWordguessGame(){
        return wordguessgame;
    }

    public JFrame getWindow(){
        return window;
    }

    public WordguessCanvas getCanvas(){
        return canvas;
    }

    public JTextField getgamekeyField(){
        return gamekeyField;
    }

    public JTextField getGuessField(){
        return guessField;
    }

    public JButton[] getLetterButtons(){
        return letterButtons;
    }

    public JButton getNewButton(){
        return newButton;
    }

    public GameState getGameState(){
        return gameState;
    }

    // public WordguessGame getWordguess() {
    //     return wordguess;
    // }

    public void setGameState(GameState state){
        this.gameState = state;
    }

    public void setWordguessGame(WordguessGame game){
        this.wordguessgame = game;
    }
}