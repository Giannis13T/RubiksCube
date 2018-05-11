import java.awt.Color;

public class Cube {

	
	private final int ROWS = 3;
	private final int COLUMNS = 3;
	
	// Array representing a cube. Dimensions are [rows][columns][sides] where sides={front,right,back,left,up,down}
	private Color[][][] cube = new Color[ROWS][COLUMNS][6];
	
	/**
	 * Creates a Cube object with a Rubik's cube as an argument
	 * @param c A 3-dimensional array representing a Rubik's cube
	 */
	public Cube(Color[][][] c) {
		cube = c;
	}
	
	/**
	 * Rotates the cube clockwise
	 * @param row The row of the cube to rotate
	 */
	public void rotateClockwise(int row) {
		if (row==1) {
			
		} else if (row==2) {
			
		} else if (row==3) {
			
		}
	}
	
	/**
	 * Rotates the cube counterclockwise
	 * @param row The row of the cube to rotate
	 */
	public void rotateCounterClockwise(int row) {
		
	}
	
	/**
	 * Rotates the cube upwards
	 * @param column The column of the cube to rotate
	 */
	public void rotateUp(int column) {
		
	}
	
	/**
	 * Rotates the cube downwards
	 * @param column The column of the cube to rotate
	 */
	public void rotateDown(int column) {
		
	}
	
	// Rotates a row, clockwise if c==0, counterclockwise if c==1
	private void rotateRow(int c, int row, int side) {
		Color[] temp = new Color[ROWS];
		if (c==0) {
			for (int i=2; i>=0; i--) {
				for (int j=0; j<temp.length; j++) {
					temp[j] = cube[row][j][i];
					cube[row][j][i] = cube[row][j][3];
					cube[row][j][3] = temp[j];
				}
			}
		} else if (c==1) {
			for (int i=0; i<3; i++) {
				for (int j=0; j<temp.length; j++) {
					temp[j] = cube[row][j][i];
					cube[row][j][i] = cube[row][j][3];
					cube[row][j][3] = temp[j];
				}
			}
		}
	}
	
}
