import java.awt.Color;

public class State {

	private final int ROWS = 3;
	private final int COLUMNS = 3;
	
	// Array representing a cube. Dimensions are [rows][columns][sides] where sides={front,right,back,left,top,bottom}
	private Color[][][] cube = new Color[ROWS][COLUMNS][6];
	
	/**
	 * Creates a new object representing a cube's state
	 * @param c The current cube's state
	 */
	public State(Color[][][] c) {
		cube = c;
	}
	
	/**
	 * Get the cube's state
	 * @return The cube's state
	 */
	public Color[][][] getCube() {
		return cube;
	}
	
	/**
	 * Check if the cube has been solved
	 * @return True if the cube has been solved, false otherwise
	 */
	public boolean isFinal() {
		Color cl = null;
		for (int i=0; i<6; i++) {
			cl = cube[0][0][i];
			for (int j=0; j<ROWS; j++) {
				for (int k=0; k<COLUMNS; k++) {
					if (cube[j][k][i]!=cl) return false;
				}
			}
		}
		return true;
	}
	
}
