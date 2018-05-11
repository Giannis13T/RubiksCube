import java.awt.Color;

public class Cube {

	
	private final int ROWS = 3;
	private final int COLUMNS = 3;
	
	// Array representing a cube. Dimensions are [rows][columns][sides] where sides={front,right,back,left,up,down}
	private Color[][][] cube = new Color[ROWS][COLUMNS][6];
	
	
	public Cube(Color[][][] c) {
		cube = c;
	}
	
	
	public void rotateClockwise() {
		
	}
	
	public void rotateCounterClockwise() {
		
	}
	
	public void rotateUp() {
		
	}
	
	public void rotateDown() {
		
	}
}
