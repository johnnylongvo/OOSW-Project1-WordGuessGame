package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordguessGame {

    private char guess;
    private String answer;
    private int lives;


     public WordguessGame(){
        lives = 5;
        answer = generateSolution();
    }

    private String generateSolution(){
        Random r = new Random();
        int solution = r.nextInt(32);
        return solutions.get(solution);
    }

    // public void setGuess(int pos, int value) {
    //     assert 0 <= pos && pos < 10: "setGuess out of range in position";
    //     guess[pos] = value;
    // }
    
    public ArrayList<String> solutions = new ArrayList<String>(Arrays.asList("communication", "science", "programming"
        , "language", "difficulty", "artificial", "intelligence", "attempts", "screenshot", "baseball", "windows"
        , "learning", "electronics", "beautiful", "internet", "database", "organization", "application", "network"
        , "friendly", "validation", "attempts", "statistics", "physics", "chemistry", "engineering", "school", "industry"
        , "revolution", "progress", "characters", "heavily", "graphics"));
    // public ArrayList<String> solutions = new ArrayList<String>();
 
    // public void WordGuessGame() {
    //     solutions.add("communication");
    //     solutions.add("science");
    //     solutions.add("programming");
    //     solutions.add("language");
    //     solutions.add("difficulty");
    //     solutions.add("artificial");
    //     solutions.add("intelligence");
    //     solutions.add("attempts");
    //     solutions.add("screenshot");
    //     solutions.add("baseball");
    //     solutions.add("windows");
    //     solutions.add("learning");
    //     solutions.add("electronics");
    //     solutions.add("beautiful");
    //     solutions.add("internet");
    //     solutions.add("database");
    //     solutions.add("organization");
    //     solutions.add("application");
    //     solutions.add("network");
    //     solutions.add("friendly");
    //     solutions.add("validation");
    //     solutions.add("attempts");
    //     solutions.add("statistics");
    //     solutions.add("physics");
    //     solutions.add("chemistry");
    //     solutions.add("engineering");
    //     solutions.add("school");
    //     solutions.add("industry");
    //     solutions.add("revolution");
    //     solutions.add("progress");
    //     solutions.add("characters");
    //     solutions.add("heavily");
    //     solutions.add("graphics");
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

    public int getLives(){
        return lives;
    }

}