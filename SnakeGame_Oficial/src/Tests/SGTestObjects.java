package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Objects.*;
import Drivers.*;

class SGTestObjects  {
	private final int WIDTH = 1340;
	private final int HEIGHT = 1340;
	private PositionManager posMan = new PositionManager();
	private Entity apple = new Apple(this.WIDTH, this.HEIGHT, posMan);
	private Snake snake = new Snake(5);
	private Entity orange = new Orange(this.WIDTH, this.HEIGHT, posMan);
	private Entity blackHole = new BlackHole(this.WIDTH, this.HEIGHT, posMan);
	
	@Test
	public void testSnakeInitial() {
		assertEquals(5, snake.getSnakeSize());
	}
	
	@Test
	public void testSnakeValidateSides() {
	    snake.setDirection(GameSettings.Directions.RIGHT);
	    snake.move();
	    assertEquals(80, snake.getSnakePosX(0));
	}
	
	@Test
	public void testSnakeValidateUpDown() {
	    snake.setDirection(GameSettings.Directions.DOWN);
	    snake.move();
	    assertEquals(80, snake.getSnakePosY(0));
	}
	
	@Test
	public void testSnakeSegmentFollowHead() {
		snake.setDirection(GameSettings.Directions.RIGHT);
		snake.move();
		assertEquals(60, snake.getSnakePosX(1));
	}
	
	@Test
	public void testMovingAllDirections() {
		snake.setDirection(GameSettings.Directions.RIGHT);
		assertTrue(snake.movingRight());
		
		snake.setDirection(GameSettings.Directions.LEFT);
		assertTrue(snake.movingLeft());
		
		snake.setDirection(GameSettings.Directions.UP);
		assertTrue(snake.movingUp());
		
		snake.setDirection(GameSettings.Directions.DOWN);
		assertTrue(snake.movingDown());
	}
	
	@Test
	public void testSnakeIncrement() {
		snake.setSnakeSize(snake.getSnakeSize() + 1);
		assertEquals(6, snake.getSnakeSize());
	}
	
	@Test
	public void testSnakeSegmentDirectionAfterMove() {
	    snake.setDirection(GameSettings.Directions.UP);
	    snake.move();
	    assertEquals(GameSettings.Directions.UP, snake.getDirection(0));
	    snake.move();
	    assertEquals(GameSettings.Directions.UP, snake.getDirection(1));  
	}
	
	
	@Test
	public void testHeadImage() {
	    assertNotNull(snake.getHeadImage(GameSettings.Directions.RIGHT));
	    assertNotNull(snake.getHeadImage(GameSettings.Directions.LEFT));
	    assertNotNull(snake.getHeadImage(GameSettings.Directions.UP));
	    assertNotNull(snake.getHeadImage(GameSettings.Directions.DOWN));
	}

	@Test
	public void testBodyImage() {
	    assertNotNull(snake.getBodyImage(GameSettings.Directions.RIGHT));
	    assertNotNull(snake.getBodyImage(GameSettings.Directions.LEFT));
	    assertNotNull(snake.getBodyImage(GameSettings.Directions.UP));
	    assertNotNull(snake.getBodyImage(GameSettings.Directions.DOWN));
	}
	
	@Test
	public void testAppleLimits() {
        assertTrue(apple.getY() > 0 && apple.getY() <= (this.HEIGHT) - apple.getSize());
        assertTrue(apple.getX() > 0 && apple.getX() <= (this.WIDTH) - apple.getSize());
	}
	
	@Test
	public void testAppleRandom() {
		assertNotNull(apple.getX());
		assertNotNull(apple.getY());
	}
	
	@Test
	public void testOrangeLimits() {
		assertTrue(orange.getX() > 0 && orange.getX() <= (this.WIDTH - orange.getSize()));
		assertTrue(orange.getY() > 0 && orange.getY() <= (this.WIDTH - orange.getSize()));
	}
	
	@Test
    public void testAOrangectionPerformed() {
        boolean initialVisibility =  orange.getVisible();
        Orange orange = (Orange)this.orange;
        orange.actionPerformed(null);  
        assertNotEquals(initialVisibility, orange.getVisible());
    }
	
	
	@Test
	public void testBlackHoleLimits() {
		assertTrue(blackHole.getX() > 0 && blackHole.getX() <= (this.WIDTH - blackHole.getSize()));
		assertTrue(blackHole.getY() > 0 && blackHole.getY() <= (this.WIDTH - blackHole.getSize()));
	}
	
	@Test
    public void testBlackHoleActionPerformed() {
		boolean initialVisibility =  blackHole.getVisible();
        BlackHole blackHole = (BlackHole)this.blackHole;
        blackHole.actionPerformed(null);  
        assertNotEquals(initialVisibility, blackHole.getVisible());
    }

}
