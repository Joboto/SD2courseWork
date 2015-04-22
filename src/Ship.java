
public class Ship {
	private Square position;
	private String name;
	private Grid gameGrid;
	
	public Ship(Grid grid){
		setGameGrid(grid);
	}
	
	public void move(Movement move){
		Square oldPosition = leaveCurrentPos();
		int newX = oldPosition.getX() + move.xChange();
		int newY = oldPosition.getY() + move.yChange();
		this.gameGrid.put(newX, newY, this);
		
	}
	
	private Square leaveCurrentPos(){
		Square oldPosition = this.position;
		this.position = null;
		oldPosition.removeShip(this);
		return oldPosition;
	}

	/*public void printCoords(){
		String output;
		output = this.name+"'s coords: ("+this.position.getX()+","+this.position.getY()+")";
		System.out.println(output);
	}*/

	public Square getPosition() {
		return position;
	}

	public void setPosition(Square position) {
		this.position = position;
	}
	
	public String imagePath(){
		return this.getClass().getName().trim()+".PNG";
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
