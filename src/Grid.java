
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
	
	public void whatsAt(int x, int y){// could change to 'public Ship whatsAt' and return target.getCurrentShip()
		Square target;
		target = this.gameGrid[x][y];
		System.out.println(target.getShip());
	}
	
	public void put(int x, int y, Ship ship){
		this.gameGrid[x][y].setShip(ship);
	}
	
	public void clear(int x, int y){
		this.gameGrid[x][y].clear();
	}
	
	public void print(){
		String output = "";
		for(int y = 0; y < this.size; y++){
			for(int x = 0; x < this.size; x++){
				if(this.gameGrid[x][y].getShip() != null){
					output = output + this.gameGrid[x][y].getShip().getName() + " ";
				} else {
					output = output + this.gameGrid[x][y].getCoords() + " ";
				}
			}
			output = output + "\n";
		}
		System.out.println(output);
	}
	
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
