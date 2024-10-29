package Objects;

import java.awt.*;
import javax.swing.*;

public class Images {
	
	public static final Image ALIEN_1 = loadImage("C:/Users/Adrian/workspace/Imagenes/ALIEN 1.png");
	public static final Image ALIEN_2 = loadImage("C:/Users/Adrian/workspace/Imagenes/ALIEN 2.png");
	public static final Image BLACK_HOLE = loadImage("C:/Users/Adrian/workspace/Imagenes/BLACK HOLE.png");
	public static final Image SNAKE_HEAD_RIGHT = loadImage("C:/Users/Adrian/workspace/Imagenes/SNAKE HEAD RIGHT.png");
	public static final Image SNAKE_HEAD_LEFT = loadImage("C:/Users/Adrian/workspace/Imagenes/SNAKE HEAD LEFT.png");
	public static final Image SNAKE_HEAD_UP = loadImage("C:/Users/Adrian/workspace/Imagenes/SNAKE HEAD UP.png");
	public static final Image SNAKE_HEAD_DOWN = loadImage("C:/Users/Adrian/workspace/Imagenes/SNAKE HEAD DOWN.png");
	public static final Image SNAKE_BODY_RIGHT = loadImage("C:/Users/Adrian/workspace/Imagenes/SNAKE BODY RIGTH.png");
	public static final Image SNAKE_BODY_LEFT = loadImage("C:/Users/Adrian/workspace/Imagenes/SNAKE BODY LEFT.png");
	public static final Image SNAKE_BODY_UP = loadImage("C:/Users/Adrian/workspace/Imagenes/SNAKE BODY UP.png");
	public static final Image SNAKE_BODY_DOWN = loadImage("C:/Users/Adrian/workspace/Imagenes/SNAKE BODY DOWN.png");
	public static final Image HEART = loadImage("C:/Users/Adrian/workspace/Imagenes/HEART.png"); 
	public static final Image FONDO = loadImage("C:/Users/Adrian/workspace/Imagenes/FONDO.png"); 
	
	private static Image loadImage(String path) {
		return new ImageIcon(path).getImage();
	}
}