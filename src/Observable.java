
public interface Observable {
	public void addObserver(BattleCruiser s);
	public void removeObserver(BattleCruiser s);
	public void notifyObservers();
}
