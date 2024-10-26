package Drivers;

public class LifeManager {
    private int lives;

    public LifeManager() {
        this.lives = 3; //Número inicial de vidas
    }
    
    public int getLives() {
        return lives;
    }

    public void loseLife() {
        if (lives > 0) {
            lives--;
        }
    }

    public boolean hasLives() {
        return lives > 0;
    }

    public void resetLives() {
        lives = 3; //Reinicia las vidas si es necesario
    }
}