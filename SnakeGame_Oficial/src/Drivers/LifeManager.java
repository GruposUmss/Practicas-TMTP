package Drivers;

public class LifeManager {
    private int lives;
    private boolean visible;

    public LifeManager() {
    	this.visible = true;
        this.lives = 3;
    }
    
    public int getLives() {
    	if (!this.visible) {
    		this.lives = 0;
    	}
        return lives;
    }
    
    public void setVisible (boolean visible) {
    	this.visible = visible;
    }

    public void loseLife() {
        if (lives > 0) {
            lives--;
        }
    }

    public boolean hasLives() {
        return lives > 0;
    }

   
}