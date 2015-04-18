import java.util.ArrayList;


public class MasterShip extends Ship implements Observable {
	public static MasterShip uniqueInstance;
	private int score;
	private ArrayList<BattleCruiser> watchers = new ArrayList<BattleCruiser>();

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
	public void addObserver(BattleCruiser s) {
		this.watchers.add(s);
	}

	@Override
	public void removeObserver(BattleCruiser s) {
		this.watchers.remove(s);
	}

	@Override
	public void notifyObservers() {
		for(BattleCruiser s : this.watchers){
			s.update(this.getPosition());
		}
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
