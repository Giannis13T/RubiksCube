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
	 * Solves the cube using BFS algorithm
	 * @return The cube solved or null if it can't solve the cube
	 */
	public Color[][][] solve() {
		State st = new State(cube.getCube());
		states.add(st);
		while (!states.isEmpty()) {
			st = states.get(0);
			states.remove(0);
			if (st.isFinal()) return st.getCube();
			if (visited(st)) {
				continue;
			} else {
				visited.add(st);
			}
			addChildren(st);
		}
		return null;
	}
	
	// Produces the state's children and adds them to the states queue
	private void addChildren(State st) {
		Cube cb = new Cube(st.getCube());
		Color[][][] c = cb.getCube();
		State s;
		for (int i=0; i<ROWS; i++) {
			s = new State(c);
			cb.rotateClockwise(i, s.getCube());
			states.add(s);
			s = new State(c);
			cb.rotateCounterClockwise(i, s.getCube());
			states.add(s);
			s = new State(c);
			cb.topRotateClockwise(i, s.getCube());
			states.add(s);
			s = new State(c);
			cb.topRotateCounterClockwise(i, s.getCube());
			states.add(s);
		}
		for (int i=0; i<COLUMNS; i++) {
			s = new State(c);
			cb.rotateDown(i, s.getCube());
			states.add(s);
			s = new State(c);
			cb.rotateUp(i, s.getCube());
			states.add(s);
		}
		
	}
	
	/**
	 * Checks if a specific state has been produced again
	 * @param st The state to be checked
	 * @return True if the state has been produced again, false otherwise
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
