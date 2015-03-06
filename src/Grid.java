
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
			}
		}
	}
	
	
	
	public void print(){
		String output = "";
		for(int y = 0; y < this.size; y++){
			for(int x = 0; x < this.size; x++){
				output = output + this.gameGrid[x][y].getCoords() + " ";
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
