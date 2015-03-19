import java.util.ArrayList;


public class MasterShip extends Ship implements Observable {
	public static MasterShip uniqueInstance;
	public int score;
	public ArrayList<Ship> watchers = new ArrayList<Ship>();

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
	public void addObserver(Ship s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(Ship s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
