
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
	 * Get the cube
	 * @return The cube
	 */
	public Color[][][] getCube() {
		return cube;
	}
	
	/**
	 * Rotates a front side's row clockwise
	 * @param row The row of the cube to rotate
	 * @param cube The cube to be rotated
	 */
	public void rotateClockwise(int row, Color[][][] cube) {
		if (row==0) {
			for (int i=0; i<3; i++) {
				Color[] rowOne = new Color[COLUMNS];
				Color[] rowTwo = new Color[COLUMNS];
				Color[] rowThree = new Color[COLUMNS];
				rowOne[i] = cube[0][i][4];
				rowTwo[i] = cube[1][i][4];
				rowThree[i] = cube[2][i][4];
				cube[i][2][4] = rowOne[i];
				cube[i][1][4] = rowTwo[i];
				cube[i][0][4] = rowThree[i];
			}
			rotateRow(0,row, cube);
		} else if (row==1) {
			rotateRow(0,row, cube);
		} else if (row==2) {
			for (int i=0; i<3; i++) {
				Color[] colOne = new Color[ROWS];
				Color[] colTwo = new Color[ROWS];
				Color[] colThree = new Color[ROWS];
				colOne[i] = cube[i][0][5];
				colTwo[i] = cube[i][1][5];
				colThree[i] = cube[i][2][5];
				cube[0][i][5] = colThree[i];
				cube[1][i][5] = colTwo[i];
				cube[2][i][5] = colOne[i];
			}
			rotateRow(0,row, cube);
		}
	}
	
	/**
	 * Rotates a front side's row counterclockwise
	 * @param row The row of the cube to rotate
	 * @param cube The cube to be rotated
	 */
	public void rotateCounterClockwise(int row, Color[][][] cube) {
		if (row==0) {
			for (int i=0; i<3; i++) {
				Color[] colOne = new Color[ROWS];
				Color[] colTwo = new Color[ROWS];
				Color[] colThree = new Color[ROWS];
				colOne[i] = cube[i][0][4];
				colTwo[i] = cube[i][1][4];
				colThree[i] = cube[i][2][4];
				cube[0][i][4] = colThree[i];
				cube[1][i][4] = colTwo[i];
				cube[2][i][4] = colOne[i];
			}
			rotateRow(1,row, cube);
		} else if (row==1) {
			rotateRow(1,row, cube);
		} else if (row==2) {
			for (int i=0; i<3; i++) {
				Color[] rowOne = new Color[COLUMNS];
				Color[] rowTwo = new Color[COLUMNS];
				Color[] rowThree = new Color[COLUMNS];
				rowOne[i] = cube[0][i][5];
				rowTwo[i] = cube[1][i][5];
				rowThree[i] = cube[2][i][5];
				cube[i][2][5] = rowOne[i];
				cube[i][1][5] = rowTwo[i];
				cube[i][0][5] = rowThree[i];
			}
			rotateRow(1,row, cube);
		}
	}
	
	/**
	 * Rotates a front side's column upwards
	 * @param column The column of the cube to rotate
	 * @param cube The cube to be rotated
	 */
	public void rotateUp(int column, Color[][][] cube) {
		if (column==0) {
			for (int i=0; i<3; i++) {
				Color[] colOne = new Color[ROWS];
				Color[] colTwo = new Color[ROWS];
				Color[] colThree = new Color[ROWS];
				colOne[i] = cube[i][0][3];
				colTwo[i] = cube[i][1][3];
				colThree[i] = cube[i][2][3];
				cube[0][i][3] = colThree[i];
				cube[1][i][3] = colTwo[i];
				cube[2][i][3] = colOne[i];
			}
			rotateColumn(0,column, cube);
		} else if (column==1) {
			rotateColumn(0,column, cube);
		} else if (column==2) {
			for (int i=0; i<3; i++) {
				Color[] rowOne = new Color[COLUMNS];
				Color[] rowTwo = new Color[COLUMNS];
				Color[] rowThree = new Color[COLUMNS];
				rowOne[i] = cube[0][i][1];
				rowTwo[i] = cube[1][i][1];
				rowThree[i] = cube[2][i][1];
				cube[i][2][1] = rowOne[i];
				cube[i][1][1] = rowTwo[i];
				cube[i][0][1] = rowThree[i];
			}
			rotateColumn(0,column, cube);
		}
	}
	
	/**
	 * Rotates a front side's column downwards
	 * @param column The column of the cube to rotate
	 * @param cube The cube to be rotated
	 */
	public void rotateDown(int column, Color[][][] cube) {
		if (column==0) {
			for (int i=0; i<3; i++) {
				Color[] rowOne = new Color[COLUMNS];
				Color[] rowTwo = new Color[COLUMNS];
				Color[] rowThree = new Color[COLUMNS];
				rowOne[i] = cube[0][i][3];
				rowTwo[i] = cube[1][i][3];
				rowThree[i] = cube[2][i][3];
				cube[i][2][3] = rowOne[i];
				cube[i][1][3] = rowTwo[i];
				cube[i][0][3] = rowThree[i];
			}
			rotateColumn(1,column, cube);
		} else if (column==1) {
			rotateColumn(1,column, cube);
		} else if (column==2) {
			for (int i=0; i<3; i++) {
				Color[] colOne = new Color[ROWS];
				Color[] colTwo = new Color[ROWS];
				Color[] colThree = new Color[ROWS];
				colOne[i] = cube[i][0][1];
				colTwo[i] = cube[i][1][1];
				colThree[i] = cube[i][2][1];
				cube[0][i][1] = colThree[i];
				cube[1][i][1] = colTwo[i];
				cube[2][i][1] = colOne[i];
			}
			rotateColumn(1,column, cube);
		}
	}
	
	/**
	 * Rotates a top side's row clockwise
	 * @param row The cube's top side row to rotate
	 * @param cube The cube to be rotated
	 */
	public void topRotateClockwise(int row, Color[][][] cube) {
		if (row==0) {
			for (int i=0; i<3; i++) {
				Color[] colOne = new Color[ROWS];
				Color[] colTwo = new Color[ROWS];
				Color[] colThree = new Color[ROWS];
				colOne[i] = cube[i][0][2];
				colTwo[i] = cube[i][1][2];
				colThree[i] = cube[i][2][2];
				cube[0][i][2] = colThree[i];
				cube[1][i][2] = colTwo[i];
				cube[2][i][2] = colOne[i];
			}
			topRotateRow(0,row, cube);
		} else if (row==1) {
			topRotateRow(0,row, cube);
		} else if (row==2) {
			for (int i=0; i<3; i++) {
				Color[] rowOne = new Color[COLUMNS];
				Color[] rowTwo = new Color[COLUMNS];
				Color[] rowThree = new Color[COLUMNS];
				rowOne[i] = cube[0][i][0];
				rowTwo[i] = cube[1][i][0];
				rowThree[i] = cube[2][i][0];
				cube[i][2][0] = rowOne[i];
				cube[i][1][0] = rowTwo[i];
				cube[i][0][0] = rowThree[i];
			}
			topRotateRow(0,row, cube);
		}
	}
	
	/**
	 * Rotates a top side's row counterclockwise
	 * @param row The cube's top side row to rotate
	 * @param cube The cube to be rotated
	 */
	public void topRotateCounterClockwise(int row, Color[][][] cube) {
		if (row==0) {
			for (int i=0; i<3; i++) {
				Color[] rowOne = new Color[COLUMNS];
				Color[] rowTwo = new Color[COLUMNS];
				Color[] rowThree = new Color[COLUMNS];
				rowOne[i] = cube[0][i][2];
				rowTwo[i] = cube[1][i][2];
				rowThree[i] = cube[2][i][2];
				cube[i][2][2] = rowOne[i];
				cube[i][1][2] = rowTwo[i];
				cube[i][0][2] = rowThree[i];
			}
			topRotateRow(1,row, cube);
		} else if (row==1) {
			topRotateRow(1,row, cube);
		} else if (row==2) {
			for (int i=0; i<3; i++) {
				Color[] colOne = new Color[ROWS];
				Color[] colTwo = new Color[ROWS];
				Color[] colThree = new Color[ROWS];
				colOne[i] = cube[i][0][0];
				colTwo[i] = cube[i][1][0];
				colThree[i] = cube[i][2][0];
				cube[0][i][0] = colThree[i];
				cube[1][i][0] = colTwo[i];
				cube[2][i][0] = colOne[i];
			}
			topRotateRow(1,row, cube);
		}
	}
	
	// Rotates a front side's row, clockwise if c==0, counterclockwise if c==1
	private void rotateRow(int c, int row, Color[][][] cube) {
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
	private void rotateColumn(int c, int column, Color[][][] cube) {
		int bColumn = 1;
		if (column==0) {
			bColumn = 2;
		} else if (column==2) {
			bColumn = 0;
		}
		Color[] tempf = new Color[ROWS];
		Color[] tempb = new Color[ROWS];
		Color[] tempu = new Color[ROWS];
		Color[] tempd = new Color[ROWS];
		for (int i=0; i<ROWS; i++) {
			tempf[i] = cube[i][column][0];
			tempb[i] = cube[i][bColumn][2];
			tempu[i] = cube[i][column][4];
			tempd[i] = cube[i][column][5];
		}
		if (c==0) {
			for (int i=0; i<ROWS; i++) {
				cube[i][column][0] = tempd[i];
				cube[i][bColumn][2] = tempu[i];
				cube[i][column][4] = tempf[i];
				cube[i][column][5] = tempb[i];
			}
		} else if (c==1) {
			for (int i=0; i<ROWS; i++) {
				cube[i][column][0] = tempu[i];
				cube[i][bColumn][2] = tempd[i];
				cube[i][column][4] = tempb[i];
				cube[i][column][5] = tempf[i];
			}
		}
	}
	
	// Rotates a top side's row, clockwise if c==0, counterclockwise if c==1
	private void topRotateRow(int c, int row, Color[][][] cube) {
		int topRow = row;
		int botRow = -1;
		int rColumn = -1;
		int lColumn = -1;
		if (row==0) {
			botRow = 2;
			rColumn = 2;
			lColumn = 0;
		} else if (row==1) {
			botRow = 1;
			rColumn = 1;
			lColumn = 1;
		} else if (row==2) {
			botRow = 0;
			rColumn = 0;
			lColumn = 2;
		}
		Color[] tempr = new Color[ROWS];
		Color[] templ = new Color[ROWS];
		Color[] tempu = new Color[COLUMNS];
		Color[] tempd = new Color[COLUMNS];
		for (int i=0; i<ROWS; i++) { // ROWS==COLUMNS
			tempr[i] = cube[i][rColumn][1];
			templ[i] = cube[i][lColumn][3];
			tempu[i] = cube[row][i][4];
			tempd[i] = cube[botRow][i][5];
		}
		if (c==0) {
			for (int i=0; i<ROWS; i++) { // ROWS==COLUMNS
				cube[i][rColumn][1] = tempu[i];
				cube[i][lColumn][3] = tempd[i];
				cube[row][i][4] = templ[i];
				cube[botRow][i][5] = tempr[i];
			}
		} else if (c==1) {
			for (int i=0; i<ROWS; i++) { // ROWS==COLUMNS
				cube[i][rColumn][1] = tempd[i];
				cube[i][lColumn][3] = tempu[i];
				cube[row][i][4] = tempr[i];
				cube[botRow][i][5] = templ[i];
			}
		}
	}
	
}
