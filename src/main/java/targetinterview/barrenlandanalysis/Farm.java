package targetinterview.barrenlandanalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Farm {

	private List<Integer> fertileLandAreas;
	private Coordinate[][] land;
	private int length;
	private int breadth;
	private String response;
	private String error;
	
	public Farm(int length, int breadth) {
		// Setup Farm
		fertileLandAreas = new ArrayList<>();
		this.length = length;
		this.breadth = breadth;
		land = new Coordinate[length][breadth];	
	}
	
	/**
	 * Print the land layout after setting up barren sections.
	 */
	public void printLand() {
		for (int j = this.breadth - 1; j >= 0; j--) {
			for (int i = 0; i < this.length; i++) {
				System.out.print(land[i][j].isBarren() ? "X" : "0");
			}
			System.out.println("");
		}
	};
	
	/**
	 * Set up barren sections in the farm
	 */
	public void setBarrenCoordinates(String[] coordinatesList) {
		this.initializeLand();
		// Mark Barren Areas
		for (String coordinates : coordinatesList) {
			if (this.error.isBlank() && !coordinates.isBlank()) {
				markAllBarrenSections(coordinates.trim());	
			}
		}
		this.startCalculation();
	}
	
	/***
	 * Start fertile area calculations
	 */
	private void startCalculation() {

		if (this.error.isBlank()) {
			// Find Fertile Areas from (0,0)
			this.findFertileAreas(0, 0);
			Collections.sort(fertileLandAreas);
		}
	}
	
	/**
	 * Get order list of areas calculated or an error if any.
	 * @return response
	 */
	public String getFertileLandAreas() {
		String response = this.error.isBlank() ? getFertileAreas() : this.error;
		return response;
	}

	private String getFertileAreas() {
		if (fertileLandAreas.isEmpty()) {
			this.response = "No Fertile Land Found";
		} else {
			StringBuilder sb = new StringBuilder(); 
			for (int area : fertileLandAreas) {
				sb.append(area);
				sb.append(" ");
			}
			this.response = sb.toString();
		}
		return this.response;
	}

	/**
	 * Mark off the barren sections (rectangles) as visted and marked.
	 **/
	private void markAllBarrenSections(String coordinates) {
		String[] x1y1x2y2 = coordinates.split(" ");
		this.error = ValidateFarmData.ValidateBarrenRaw(x1y1x2y2, length, breadth);
		if (this.error.isBlank()) {
			int x1 = Integer.parseInt(x1y1x2y2[0]);
			int y1 = Integer.parseInt(x1y1x2y2[1]);
			int x2 = Integer.parseInt(x1y1x2y2[2]);
			int y2 = Integer.parseInt(x1y1x2y2[3]);
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					land[i][j].setBarren(true);
					land[i][j].setVisited(true);
				}
			}	
		}
	}

	/**
	 * Initialize the farm land
	 **/
	private void initializeLand() {
		this.error = "";
		fertileLandAreas.clear();
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.breadth; j++) {
				if (land[i][j] == null) {
					land[i][j] = new Coordinate(i, j, false);					
				} else {
					land[i][j].setBarren(false);
					land[i][j].setVisited(false);
				}
			}
		}
	}

	/**
	 * Start calculating the areas and add them the list.
	 * 
	 * @param i - X postion in the farm
	 * @param j - Y position in the farm
	 */
	private void findFertileAreas(int i, int j) {
		for (int y = j; y < this.breadth; y++) {
			for (int x = i; x < this.length; x++) {
				Coordinate coordinate = land[x][y];
				if (!coordinate.isBarren() && !coordinate.isVisited()) {
					int totalFertileArea = accumulateAdjacentFertileAreas(x, y);
					fertileLandAreas.add(totalFertileArea);
					findFertileAreas(x, y);
				}
			}
		}
	}

	/**
	 * Get adjacent non visited and non barren areas and accumulate the area from
	 * farm land.
	 * 
	 * @param x - X postion in the farm land.
	 * @param y - Y postion in the farm land.
	 * @return area of the largest non-barren section.
	 */
	private int accumulateAdjacentFertileAreas(int x, int y) {
		int area = 0;
		Stack<Coordinate> stack = new Stack<Coordinate>();
		stack.push(land[x][y]);
		while (!stack.isEmpty()) {
			Coordinate c = stack.pop();
			if (!isBarrenOrVisted(c.getX(), c.getY())) {
				area++;
				if (c.getY() - 1 >= 0 && !land[c.getX()][c.getY() - 1].isVisited()) {
					stack.push(land[c.getX()][c.getY() - 1]);
				}
				if (c.getY() + 1 < this.breadth && !land[c.getX()][c.getY() + 1].isVisited()) {
					stack.push(land[c.getX()][c.getY() + 1]);
				}
				if (c.getX() - 1 >= 0 && !land[c.getX() - 1][c.getY()].isVisited()) {
					stack.push(land[c.getX() - 1][c.getY()]);
				}
				if (c.getX() + 1 < this.length && !land[c.getX() + 1][c.getY()].isVisited()) {
					stack.push(land[c.getX() + 1][c.getY()]);
				}
			}
		}
		return area;
	}

	/**
	 * Check if the Co-ordinate is either visited or barren. If unvisited sets the
	 * Co-ordinate as visited.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isBarrenOrVisted(int x, int y) {
		boolean barrenOrVisited = land[x][y].isVisited() || land[x][y].isBarren();
		land[x][y].setVisited(true);
		return barrenOrVisited;
	}

}
