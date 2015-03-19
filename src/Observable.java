
public interface Observable {
	public void addObserver(Ship s);
	public void removeObserver(Ship s);
	public void notifyObservers();
}
