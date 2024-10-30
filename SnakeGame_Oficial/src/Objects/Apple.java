package Objects;

import Drivers.PositionManager;
import java.awt.*;

public class Apple extends Entity{

    public Apple(int width, int height, PositionManager posMan) {
    	super(width, height, posMan);
    }
    
    @Override
    public void draw(Graphics g) {
    	g.drawImage(Images.ALIEN_1, this.posX, this.posY, this.ENTITY_SIZE, this.ENTITY_SIZE, null);
    }
}