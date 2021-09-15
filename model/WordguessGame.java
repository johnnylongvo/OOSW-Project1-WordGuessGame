package model;

import java.util.ArrayList;
import java.util.Random;

public class WordguessGame {

    private String[] key;
    private int healthCount = 0;
    private int livestrikeCount = 0;
    private String[] guess;

    public WordguessGame() {
        generateWord();
    }

    private void generateWord() {
    }

    private String getKey() {
        Random r = new Random();

        String wordKey = wordPool.get(r.nextInt(wordPool.size()));
        return wordKey;
    }

    private ArrayList<String> wordPool = new ArrayList<String>();

    public void WordGuessGame() {
        wordPool.add("communication");
        wordPool.add("science");
        wordPool.add("programming");
        wordPool.add("language");
        wordPool.add("difficulty");
        wordPool.add("artificial");
        wordPool.add("intelligence");
        wordPool.add("attempts");
        wordPool.add("screenshot");
        wordPool.add("baseball");
        wordPool.add("windows");
        wordPool.add("learning");
        wordPool.add("electronics");
        wordPool.add("beautiful");
        wordPool.add("internet");
        wordPool.add("database");
        wordPool.add("organization");
        wordPool.add("application");
        wordPool.add("network");
        wordPool.add("friendly");
        wordPool.add("validation");
        wordPool.add("attempts");
        wordPool.add("statistics");
        wordPool.add("physics");
        wordPool.add("chemistry");
        wordPool.add("engineering");
        wordPool.add("school");
        wordPool.add("industry");
        wordPool.add("revolution");
        wordPool.add("progress");
        wordPool.add("characters");
        wordPool.add("heavily");
        wordPool.add("graphics");
    }

    public int getHealthCount() {
        return healthCount;
    }

    public int getLiveStrikeCount() {
        return livestrikeCount;
    }

    public void setGuess(int clicks, int i) {
    }

    public String[] getKey() {
        return key;
    }

    public WordguessGame(String[] key) {
        this.key = key;
    }

    public void computeHealthStrikes() {
        livestrikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (key[i] == guess[i]) ++livestrikeCount;
        } 

        healthCount = 0;
        for (int i = 0; i < 5; i++) {
            for (int n = 0; n < 5; n++) {
                if (i == n) continue;
                if (key[i] == guess[i]) healthCount++;
            }
        }
    }
}
