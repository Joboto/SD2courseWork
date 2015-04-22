import java.util.HashSet;

public class Square {
	private int x;
	private int y;
	private Grid gameGrid;
	private HashSet<Ship> ships = new HashSet<Ship>();
	
	public Square(){}
	
	public Square(int x, int y){
		setX(x);
		setY(y);
	}
	
	public String description(){
		if(this.ships.isEmpty()){
			return null;
		} else {
			String output = "";
			for(Ship tempShip : this.ships) {
				output = output +"\n" +tempShip.getName();
			}
			return output;
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

	public void addShip(Ship newShip) {
		newShip.setPosition(this);
		this.ships.add(newShip);
	}
	
	public HashSet<Ship> getShips() {
		return ships;
	}

	public void removeShip(Ship oldShip) {
		this.ships.remove(oldShip);
	}

	
}
