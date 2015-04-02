import java.util.HashSet;
import java.util.Random;


public class Game {
	private Grid theGrid;
	private int size;
	private MasterShip player;
	//let's instantiate an enemy ship for the time being and try to move him randomly
	private Random random = new Random();
	private HashSet<EnemyShip> allEnemys = new HashSet<EnemyShip>();
	
	public Game(){
		setSize(4);
		setTheGrid(new Grid());
		this.theGrid.initializeGrid(this.size);
		setPlayer(MasterShip.getInstance(this.theGrid, "Me"));
		this.theGrid.put(0, 0, getPlayer());
		newEnemy("Bob");
		newEnemy("Al");
	}
	
	public void moveEnemys(){
		for(Ship ship : this.allEnemys){
			randomMove(ship);
		}
	}
	
	public void randomMove(Ship ship){
		Movement randomMove = Movement.values()[random.nextInt(Movement.values().length)];
		ship.move(randomMove);
	}
	
	public void newEnemy(String name){
		EnemyShip grrr = new EnemyShip(this.theGrid, name);
		this.allEnemys.add(grrr);
		this.theGrid.put(0, 0, grrr);
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
