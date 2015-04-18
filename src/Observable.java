
public interface Observable {
	public void addObserver(EnemyShip s);
	public void removeObserver(EnemyShip s);
	public void notifyObservers();
}
