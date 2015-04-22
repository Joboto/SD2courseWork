
public class Grid {
	private int size;
	private Square[][] gameGrid;
	
	public Grid(){}
	
	public void initializeGrid(int chosenSize){
		setSize(chosenSize);
		this.gameGrid = new Square[chosenSize][chosenSize];
		for(int x = 0; x < chosenSize; x++){
			for(int y = 0; y < chosenSize; y++){
				this.gameGrid[x][y] = new Square(x, y);
				this.gameGrid[x][y].setGameGrid(this);
			}
		}
	}
	
	public Square whatsAt(int x, int y){// could change to 'public Ship whatsAt' and return target.getCurrentShip()
		return this.gameGrid[x][y];
	}
	
	public void put(int x, int y, Ship ship){
		x = keepInBounds(x);
		y = keepInBounds(y);
		this.gameGrid[x][y].addShip(ship);
	}
	
	private int keepInBounds(int coord){
		if(coord < 0){
			coord = 0;
		}
		if(coord >= this.size){
			coord = this.size - 1;
		}
		return coord;
	}
	
	public void clear(int x, int y){
		this.gameGrid[x][y].getShips().clear();
	}
	
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public Square[][] getGameGrid() {
		return gameGrid;
	}

}
