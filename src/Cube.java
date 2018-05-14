import java.awt.Color;

public class Cube {

	
	private final int ROWS = 3;
	private final int COLUMNS = 3;
	
	// Array representing a cube. Dimensions are [rows][columns][sides] where sides={front,right,back,left,top,bottom}
	private Color[][][] cube = new Color[ROWS][COLUMNS][6];
	
	/**
	 * Creates a Cube object with a Rubik's cube as an argument
	 * @param c A 3-dimensional array representing a Rubik's cube
	 */
	public Cube(Color[][][] c) {
		cube = c;
	}
	
	/**
	 * Rotates a front side's row clockwise
	 * @param row The row of the cube to rotate
	 */
	public void rotateClockwise(int row) {
		if (row==1) {
			
		} else if (row==2) {
			
		} else if (row==3) {
			
		}
	}
	
	/**
	 * Rotates a front side's row counterclockwise
	 * @param row The row of the cube to rotate
	 */
	public void rotateCounterClockwise(int row) {
		
	}
	
	/**
	 * Rotates a front side's column upwards
	 * @param column The column of the cube to rotate
	 */
	public void rotateUp(int column) {
		
	}
	
	/**
	 * Rotates a front side's column downwards
	 * @param column The column of the cube to rotate
	 */
	public void rotateDown(int column) {
		
	}
	
	/**
	 * Rotates a top side's row clockwise
	 * @param row The row of the cube to rotate
	 */
	public void topRotateClockwise(int row) {
		
	}
	
	/**
	 * Rotates a top side's row counterclockwise
	 * @param row The row of the cube to rotate
	 */
	public void topRotateCounterClockwise(int row) {
		
	}
	
	// Rotates a front side's row, clockwise if c==0, counterclockwise if c==1
	private void rotateRow(int c, int row) {
		Color[] temp = new Color[COLUMNS];
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
	
	// Rotates a front side's column, upwards if c==0, downwards if c==1
	private void rotateColumn(int c, int column) {
		Color[] tempf = new Color[ROWS];
		Color[] tempb = new Color[ROWS];
		Color[] tempu = new Color[ROWS];
		Color[] tempd = new Color[ROWS];
		for (int i=0; i<ROWS; i++) {
			tempf[i] = cube[i][column][0];
			tempb[i] = cube[i][column][2];
			tempu[i] = cube[i][column][4];
			tempd[i] = cube[i][column][5];
		}
		if (c==0) {
			for (int i=0; i<ROWS; i++) {
				cube[i][column][0] = tempd[i];
				cube[i][column][2] = tempu[i];
				cube[i][column][4] = tempf[i];
				cube[i][column][5] = tempb[i];
			}
		} else if (c==1) {
			for (int i=0; i<ROWS; i++) {
				cube[i][column][0] = tempu[i];
				cube[i][column][2] = tempd[i];
				cube[i][column][4] = tempb[i];
				cube[i][column][5] = tempf[i];
			}
		}
	}
	
}
