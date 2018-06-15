import java.awt.Color;
import java.util.ArrayList;

public class FindBest {

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
	
}
