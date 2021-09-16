package model;

import java.util.ArrayList;
import java.util.Random;

public class WordguessGame {

    private char guess;
    private String answer;
    private int health;

    //Define an ArrayList<String> to hold the game keys (a word pool).
    private ArrayList<String> solutions = new ArrayList<String>();
    public WordguessGame() {

        solutions.add("communication");
        solutions.add("science");
        solutions.add("programming");
        solutions.add("language");
        solutions.add("difficulty");
        solutions.add("artificial");
        solutions.add("intelligence");
        solutions.add("attempts");
        solutions.add("screenshot");
        solutions.add("baseball");
        solutions.add("windows");
        solutions.add("learning");
        solutions.add("electronics");
        solutions.add("beautiful");
        solutions.add("internet");
        solutions.add("database");
        solutions.add("organization");
        solutions.add("application");
        solutions.add("network");
        solutions.add("friendly");
        solutions.add("validation");
        solutions.add("attempts");
        solutions.add("statistics");
        solutions.add("physics");
        solutions.add("chemistry");
        solutions.add("engineering");
        solutions.add("school");
        solutions.add("industry");
        solutions.add("revolution");
        solutions.add("progress");
        solutions.add("characters");
        solutions.add("heavily");
        solutions.add("graphics");
    
        health = 5;
        answer = generateSolution();
    }

    private String generateSolution(){
        Random r = new Random();
        int solution = r.nextInt(32);
        return solutions.get(solution);
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
   
    public String getSolution(){
        return answer;
    }

    public void setGuess(char c){
        guess = c;
    }

    public char getGuess(){
        return guess;
    }

    public int getHealth(){
        return health;
    }

    // public int[] getKey() {
    //     return key;
    // }

}