package Objects;

import java.awt.*;
import javax.swing.*;

public class Images {
	
	public static final Image ALIEN_1 = loadImage("ResourcesImages/ALIEN 1.png");
	public static final Image ALIEN_2 = loadImage("ResourcesImages/ALIEN 2.png");
	public static final Image BLACK_HOLE = loadImage("ResourcesImages/BLACK HOLE.png");
	public static final Image SNAKE_HEAD_RIGHT = loadImage("ResourcesImages/SNAKE HEAD RIGHT.png");
	public static final Image SNAKE_HEAD_LEFT = loadImage("ResourcesImages/SNAKE HEAD LEFT.png");
	public static final Image SNAKE_HEAD_UP = loadImage("ResourcesImages/SNAKE HEAD UP.png");
	public static final Image SNAKE_HEAD_DOWN = loadImage("ResourcesImages/SNAKE HEAD DOWN.png");
	public static final Image SNAKE_BODY_RIGHT = loadImage("ResourcesImages/SNAKE BODY RIGTH.png");
	public static final Image SNAKE_BODY_LEFT = loadImage("ResourcesImages/SNAKE BODY LEFT.png");
	public static final Image SNAKE_BODY_UP = loadImage("ResourcesImages/SNAKE BODY UP.png");
	public static final Image SNAKE_BODY_DOWN = loadImage("ResourcesImages/SNAKE BODY DOWN.png");
	public static final Image HEART = loadImage("ResourcesImages/HEART.png"); 
	public static final Image FONDO = loadImage("ResourcesImages/FONDO.png"); 
	
	private static Image loadImage(String path) {
		return new ImageIcon(Images.class.getResource(path)).getImage();
	}
}