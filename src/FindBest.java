import java.awt.Color;
import java.util.ArrayList;

public class FindBest {
	
	private final int ROWS = 3;
	private final int COLUMNS = 3;

	ArrayList<State> states = new ArrayList<State>();
	ArrayList<State> visited = new ArrayList<State>();
	Cube cube;
	
	
	/**
	 * Creates an object which is used to solve the cube
	 * @param c 3d array representing a cube
	 */
	public FindBest(Color[][][] c) {
		cube = new Cube(c);
	}
	
	/**
	 * Checks if a specific state has been produced again
	 * @param st The state to be checked
	 */
	public boolean visited(State st) {
		boolean found = true;
		Color[][][] c = st.getCube();
		for (State s: visited) {
			Color[][][] cb = s.getCube();
			for (int i=0; i<6; i++) {
				for (int j=0; j<ROWS; j++) {
					for (int k=0; k<COLUMNS; k++) {
						if (c[j][k][i]!=cb[j][k][i]) {
							found = false;
							break;
						} else found = true;
					}
					if (!found) break;
				}
				if (!found) break;
			}
			if (found) break;
		}
		return found;
	}
	
}
