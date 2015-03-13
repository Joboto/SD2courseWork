
public class Ship {
	//private Square position;
	private int xPos;
	private int yPos;
	private String name;
	private Grid gameGrid;
	
	public Ship(Grid grid, String name){
		setGameGrid(grid);
		setName(name);
	}
	
	public void move(Movement move){
		int newX = this.xPos + move.xChange();
		int newY = this.yPos + move.yChange();
		this.gameGrid.clear(xPos, xPos);
		this.gameGrid.put(newX, newY, this);
	}

	public String printCoords(){
		String output;
		output = this.name+"'s coords: ("+this.xPos+","+this.yPos+")";
		return output;
	}

	public int getxPos() {
		return this.xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grid getGameGrid() {
		return this.gameGrid;
	}

	public void setGameGrid(Grid gameGrid) {
		this.gameGrid = gameGrid;
	}
		
}
