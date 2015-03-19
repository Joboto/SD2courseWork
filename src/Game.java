
public class Game {
	private Grid theGrid;
	private int size;
	private MasterShip player;
	
	public Game(){
		setSize(4);
		setTheGrid(new Grid());
		this.theGrid.initializeGrid(this.size);
		setPlayer(MasterShip.getInstance(this.theGrid, "Me"));
		this.theGrid.put(0, 0, getPlayer());
	}
	
	public Grid getTheGrid() {
		return this.theGrid;
	}
	public void setTheGrid(Grid theGrid) {
		this.theGrid = theGrid;
	}
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public MasterShip getPlayer() {
		return this.player;
	}
	public void setPlayer(MasterShip player) {
		this.player = player;
	}
	
	

}
