import java.util.ArrayList;


public class MasterShip extends Ship implements Observable {
	public static MasterShip uniqueInstance;
	private int score;
	private ArrayList<EnemyShip> watchers = new ArrayList<EnemyShip>();

	//implementing singleton design pattern
	private MasterShip(Grid grid) {
		super(grid);
		setScore(0);
	}
	
	public static synchronized MasterShip getInstance(Grid grid, String name){
		if(uniqueInstance == null){
			uniqueInstance = new MasterShip(grid);
			uniqueInstance.setName(name);
		}
		return uniqueInstance;
	}

	@Override
	public void addObserver(EnemyShip s) {
		this.watchers.add(s);
	}

	@Override
	public void removeObserver(EnemyShip s) {
		this.watchers.remove(s);
	}

	@Override
	public void notifyObservers() {
		/*for(EnemyShip s : this.watchers){ //Yet to make subclass of enemy ship and observer.
			s.update(this.getPosition());
		}*/
	}
	
	public void addPoints(int points){
		this.score = this.score + points;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
