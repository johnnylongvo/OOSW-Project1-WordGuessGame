package model;

import java.util.ArrayList;
import java.util.Random;

public class WordguessGame {

    private String answer;
    private char guessword;
    private int health;

    //Define an ArrayList<String> to hold the game keys (a word pool).
    private ArrayList<String> wordpool = new ArrayList<String>();
    public WordguessGame() {

        wordpool.add("communication");
        wordpool.add("science");
        wordpool.add("programming");
        wordpool.add("language");
        wordpool.add("difficulty");
        wordpool.add("artificial");
        wordpool.add("intelligence");
        wordpool.add("attempts");
        wordpool.add("screenshot");
        wordpool.add("baseball");
        wordpool.add("windows");
        wordpool.add("learning");
        wordpool.add("electronics");
        wordpool.add("beautiful");
        wordpool.add("internet");
        wordpool.add("database");
        wordpool.add("organization");
        wordpool.add("application");
        wordpool.add("network");
        wordpool.add("friendly");
        wordpool.add("validation");
        wordpool.add("attempts");
        wordpool.add("statistics");
        wordpool.add("physics");
        wordpool.add("chemistry");
        wordpool.add("engineering");
        wordpool.add("school");
        wordpool.add("industry");
        wordpool.add("revolution");
        wordpool.add("progress");
        wordpool.add("characters");
        wordpool.add("heavily");
        wordpool.add("graphics");
    
        health = 5;
        answer = generateWordpool();
    }

    private String generateWordpool(){
        Random r = new Random();
        int wordPool = r.nextInt(32);
        return wordpool.get(wordPool);
    }    
    
    // private void generateKey() {
    //     //random number generator
    //     Random r = new Random();
    //     key[0] = r.nextInt(10); //int from 0-9 upperbound
    //     //do while
    //     do {
    //         key[1] = r.nextInt(10);
    //     } while (key[1] == key[0]);

    //     do {
    //         key[2] = r.nextInt(10);
    //     } while (key[2] == key[0] || key[2] == key[1]);
    // }

    // public void setGuess(int pos, int value) {
    //     assert 0 <= pos && pos < 10: "setGuess out of range in position";
    //     guess[pos] = value;
    // }
   
    public String getWordpool(){
        return answer;
    }

    public void setGuess(char guessing){
        guessword = guessing;
    }

    public char getGuessWord(){
        return guessword;
    }

    public int getHealth(){
        return health;
    }

    // public int[] getKey() {
    //     return key;
    // }

}