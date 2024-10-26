package Drivers;

public class ScoreManager {
    private int score;
    private int highScore;

    public ScoreManager() {
        this.score = 0;
        this.highScore = 0;
    }

    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }
    
    public void increaseScore(int amount) {
        this.score += amount;
        if (score > highScore) {
            highScore = score; 
        }
    }

    public void resetScore() {
        score = 0; 
    }
}