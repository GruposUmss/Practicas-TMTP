package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Interfaces.SnakeGame;
import Objects.*;
import Drivers.GameEngine;

class SGTestObjects {
	
	private SnakeGame game = new SnakeGame();
	private GameEngine gameEngine = new GameEngine(game);
	private Apple apple = new Apple(game.getWidth(), game.getHeight(), gameEngine.getPositionManager());
	private Snake snake = new Snake(5);
	private Orange orange = new Orange(game.getWidth(), game.getHeight(), gameEngine.getPositionManager());
	private BlackHole blackHole = new BlackHole(game.getWidth(), game.getHeight(), gameEngine.getPositionManager());
	
	@Test
	public void testSnakeInitial() {
		assertEquals(5, snake.getSnakeSize());
	}
	
	@Test
	public void testSnakeValidateSides() {
	    snake.setDirection(Directions.RIGTH);
	    snake.move();
	    assertEquals(80, snake.getSnakePosX(0));
	}
	
	@Test
	public void testSnakeValidateUpDown() {
	    snake.setDirection(Directions.DOWN);
	    snake.move();
	    assertEquals(80, snake.getSnakePosY(0));
	}
	
	@Test
	public void testSnakeSegmentFollowHead() {
		snake.setDirection(Directions.RIGTH);
		snake.move();
		assertEquals(60, snake.getSnakePosX(1));
	}
	
	@Test
	public void testMovingAllDirections() {
		snake.setDirection(Directions.RIGTH);
		assertTrue(snake.movingRigth());
		
		snake.setDirection(Directions.LEFT);
		assertTrue(snake.movingLeft());
		
		snake.setDirection(Directions.UP);
		assertTrue(snake.movingUp());
		
		snake.setDirection(Directions.DOWN);
		assertTrue(snake.movingDown());
	}
	
	@Test
	public void testSnakeIncrement() {
		snake.setSnakeSize(snake.getSnakeSize() + 1);
		assertEquals(6, snake.getSnakeSize());
	}
	
	@Test
	public void testAppleLimits() {
        assertTrue(apple.getY() > 0 && apple.getY() <= (game.getHeight()) - apple.getSize());
        assertTrue(apple.getX() > 0 && apple.getX() <= (game.getWidth()) - apple.getSize());
	}
	
	@Test
	public void testAppleRandom() {
		assertNotNull(apple.getX());
		assertNotNull(apple.getY());
	}
	
	@Test
	public void testOrangeLimits() {
		assertTrue(orange.getX() > 0 && orange.getX() <= (game.getWidth() - orange.getSize()));
		assertTrue(orange.getY() > 0 && orange.getY() <= (game.getHeight() - orange.getSize()));
	}
	
	@Test
	public void testBlackHoleLimits() {
		assertTrue(blackHole.getX() > 0 && blackHole.getX() <= (game.getWidth() - blackHole.getSize()));
		assertTrue(blackHole.getY() > 0 && blackHole.getY() <= (game.getHeight() - blackHole.getSize()));
	}
}
