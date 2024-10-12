package Drivers;

import java.util.ArrayList;
import java.util.List;

public class PositionManager {
	
	private List<int []> occupiedPositions;
	
	public PositionManager() {
		this.occupiedPositions = new ArrayList<>();
	}
	
	public void addPosition(int x, int y, int size) {
		occupiedPositions.add(new int[] {x, y, size});
	}
	
	public void removePosition(int x, int y, int size) {
        for (int i = 0; i < occupiedPositions.size(); i++) {
            int[] posit = occupiedPositions.get(i);
            if (posit[0] == x && posit[1] == y && posit[2] == size) {
                occupiedPositions.remove(i);
            }
        }
    }
	
	public boolean overlay(int x, int y, int size) {
		for(int [] posit: occupiedPositions) {
			if(calculateZone(x , y, size, posit[0], posit[1], posit[2]) < 0) {
				return true;
			}
		}
		return false;
	}
	
	private int calculateZone(int x1, int y1, int size1, int x2, int y2, int size2) {
		int distanceX = x1 - x2;
        int distanceY = y1 - y2;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        return (int) (distance - (size1 + size2) / 2);
	}
	
	// Método para limpiar posiciones cuando se reinicia el juego
    public void clearPositions() {
        occupiedPositions.clear();
    }
}
