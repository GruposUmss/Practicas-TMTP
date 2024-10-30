package Objects;

import Drivers.PositionManager;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Entity {
    protected int ENTITY_SIZE = 40;
    protected int posX;
    protected int posY;
    protected boolean visible;
    protected PositionManager posMan;

    public Entity(int width, int height, PositionManager posMan) {
        this.posMan = posMan;
        this.visible = true;
        location(width, height); 
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getSize() {
        return ENTITY_SIZE;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void location(int width, int height) {
        posX = ThreadLocalRandom.current().nextInt((width / ENTITY_SIZE) - 1) * ENTITY_SIZE;
        posY = ThreadLocalRandom.current().nextInt((height / ENTITY_SIZE) - 1) * ENTITY_SIZE;
        if (posMan.overlay(posX, posY, ENTITY_SIZE)) {
            location(width, height);  // Evita superposición
        }
    }

    
    public abstract void draw(Graphics g);
    
}