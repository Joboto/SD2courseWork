import java.util.ArrayList;


public class MasterShip extends Ship implements Observable {
	public static MasterShip uniqueInstance;
	public int score;
	public ArrayList<EnemyShip> watchers = new ArrayList<EnemyShip>();

	//implementing singleton design pattern
	private MasterShip(Grid grid, String name) {
		super(grid, name);
		setScore(0);
	}
	
	public static synchronized MasterShip getInstance(Grid grid, String name){
		if(uniqueInstance == null){
			uniqueInstance = new MasterShip(grid, name);
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
		for(EnemyShip s : this.watchers){
			s.update(this.getPosition());
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
