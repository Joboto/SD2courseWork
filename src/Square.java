
public class Square {
	private int x;
	private int y;
	private Grid gameGrid;
	private Ship currentShip;
	
	public Square(){}
	
	public Square(int x, int y){
		setX(x);
		setY(y);
	}
	
	public void printCoords(){
		System.out.println("("+getX()+","+getY()+")");
	}
	
	public String getCoords(){
		return "("+getX()+","+getY()+")";
	}
	
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Grid getGameGrid() {
		return this.gameGrid;
	}
	public void setGameGrid(Grid gameGrid) {
		this.gameGrid = gameGrid;
	}

	public Ship getCurrentShip() {
		return this.currentShip;
	}

	public void setCurrentShip(Ship currentShip) {
		this.currentShip = currentShip;
	}
	
	
}
