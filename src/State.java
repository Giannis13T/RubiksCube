import java.awt.Color;

public class State {

	private final int ROWS = 3;
	private final int COLUMNS = 3;
	
	// Array representing a cube. Dimensions are [rows][columns][sides] where sides={front,right,back,left,top,bottom}
	private Color[][][] cube = new Color[ROWS][COLUMNS][6];
	
	
	public State(Color[][][] c) {
		cube = c;
	}
	
	public Color[][][] getCube() {
		return cube;
	}
	
}
