
public class Square {
	private int x;
	private int y;
	private Grid gameGrid;
	private Ship ship;
	
	public Square(){}
	
	public Square(int x, int y){
		setX(x);
		setY(y);
	}
	
	public void printCoords(){
		System.out.println(getCoords());
	}
	
	public String getCoords(){
		return "("+getX()+","+getY()+")";
	}
	
	public String description(){
		if(this.ship != null){
			return this.ship.getName();
		} else {
			return null;
		}
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

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship newShip) {
		this.ship = newShip;
		this.ship.setPosition(this);
	}
	
	public void clear() {
		this.ship = null;
	}
	
	
}
