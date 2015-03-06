
public class Ship {
	private Square coords;
	
	public Ship(){}
	
	public void move(Movement move){
		
	}

	public Square getCoords() {
		return this.coords;
	}

	public void setCoords(Square coords) {
		this.coords = coords;
		this.coords.setCurrentShip(this);
	}
		
}
