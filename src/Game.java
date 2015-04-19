import java.util.HashSet;
import java.util.Random;


public class Game {
	private Grid theGrid;
	private int size;
	private MasterShip player;
	private String news;
	private final Random random = new Random();
	private HashSet<EnemyShip> allEnemys = new HashSet<EnemyShip>();
	
	public Game(){
		setSize(6);
		setTheGrid(new Grid());
		this.theGrid.initializeGrid(this.size);
		setPlayer(MasterShip.getInstance(this.theGrid, "Me"));
		this.theGrid.put(0, 0, getPlayer());
	}
	
	public void go(Movement plrInput){
		setNews(null);
		this.player.notifyObservers();
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
		default: //ie 3 or more. game over
			setNews("GAME OVER!");
			System.out.println("GAME OVER!");
			break;
		}
	}
	
	public void killEnemy(){
		Square position = this.player.getPosition();
		EnemyShip enemy;
		
		position.removeShip(this.player);
		enemy = (EnemyShip) position.getShips().iterator().next();
		position.getShips().remove(enemy);
		
		this.player.addPoints(enemy.getPoints());
		position.addShip(this.player);
		System.out.println("Score now "+this.player.getScore());
		
		setNews(enemy.getName()+" destroyed!");
	}
	
	public void moveEnemys(){
		for(EnemyShip ship : this.allEnemys){
			ship.characteristicMove();
		}
	}
	
	public void newBattleStar(){
		BattleStar bs = new BattleStar(this.theGrid);
		this.allEnemys.add(bs);
		this.theGrid.put(0, 0, bs);
	}
	
	public void newBattleCruiser(){
		BattleCruiser bc = new BattleCruiser(this.theGrid);
		this.player.addObserver(bc);
		this.allEnemys.add(bc);
		this.theGrid.put(0, 0, bc);
	}

	public void newBattleShooter(){
		BattleShooter bs = new BattleShooter(this.theGrid);
		this.player.addObserver(bs);
		this.allEnemys.add(bs);
		this.theGrid.put(0, 0, bs);
	}
	
	public void probNewEnemy(){
		int chance = random.nextInt(12);
		switch(chance){
		case 0:
		case 1:
			newBattleStar();
		case 2:
			newBattleCruiser();
		case 3:
			newBattleShooter();
		break;
		}
	}
	
	public HashSet<EnemyShip> enemys() {
		return this.allEnemys;
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

	public String getNews() {
		return this.news;
	}

	public void setNews(String news) {
		this.news = news;
	}

}
