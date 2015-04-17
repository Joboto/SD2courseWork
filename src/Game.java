import java.util.HashSet;
import java.util.Random;


public class Game {
	private Grid theGrid;
	private int size;
	private MasterShip player;
	private final Random random = new Random();
	private HashSet<EnemyShip> allEnemys = new HashSet<EnemyShip>();
	
	public Game(){
		setSize(4);
		setTheGrid(new Grid());
		this.theGrid.initializeGrid(this.size);
		setPlayer(MasterShip.getInstance(this.theGrid, "master"));
		this.theGrid.put(0, 0, getPlayer());
		//newEnemy("Bob");
		//newEnemy("Al");
	}
	
	public void go(Movement plrInput){
		this.player.move(plrInput);
		moveEnemys();
		checkPlrSquare();
		probNewEnemy();
	}
	
	public void checkPlrSquare(){
		int numOfShips;
		numOfShips = this.player.getPosition().getShips().size();
		switch(numOfShips){
		case 1: break;
		case 2: killEnemy();
			System.out.println("Dave dead.");
			break;
		case 3: //game over
			break;
		}
	}
	
	public void killEnemy(){
		Square position = this.player.getPosition();
		position.getShips().clear();
		position.addShip(this.player);
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
	
	public void probNewEnemy(){
		int chance = random.nextInt(3);
		switch(chance){
		case 0: newEnemy("battleStar");
		break;
		}
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
