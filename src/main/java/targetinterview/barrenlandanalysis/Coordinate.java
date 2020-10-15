package targetinterview.barrenlandanalysis;

public class Coordinate {
	
	private int x;
	private int y;
	
	private boolean visited = false;
	private boolean barren = false;
	
	public Coordinate(int x, int y, boolean barren) {
		this.x = x;
		this.y = y;
		this.barren = barren;
	}
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isBarren() {
		return this.barren;
	}
	
	public void setBarren(boolean barren ) {
		this.barren = barren;
	}
	
}
