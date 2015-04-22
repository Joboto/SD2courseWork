import junit.framework.TestCase;


public class MasterShipTest extends TestCase {

	public void testGetInstance() {
		Ship ms;
		ms = MasterShip.getInstance(new Grid(), "test");
		
		assertTrue(ms.getClass() == MasterShip.class);
	}

	public void testAddObserver() {
		MasterShip ms = MasterShip.getInstance(new Grid(), "test");
		EnemyShip es = new BattleCruiser(new Grid());
		
		ms.addObserver(es);
		
		EnemyShip actual = ms.getWatchers().get(0);
		EnemyShip expected = es;
		
		assertTrue(actual == expected);
	}

	public void testRemoveObserver() {
		MasterShip ms = MasterShip.getInstance(new Grid(), "test");
		EnemyShip es = new BattleCruiser(new Grid());
		ms.addObserver(es);
		
		ms.removeObserver(es);
		
		assertTrue(ms.getWatchers().isEmpty());
	}

	public void testNotifyObservers() {
		MasterShip ms = MasterShip.getInstance(new Grid(), "test");
		BattleCruiser es = new BattleCruiser(new Grid());
		ms.addObserver(es);
		ms.getGameGrid().initializeGrid(5);
		ms.getGameGrid().put(0, 0, ms);
		
		ms.notifyObservers();
		
		Square actual = ms.getPosition();
		Square expected = es.getMasterPosition();
		
		assertTrue(actual.equals(expected));
		
	}

	public void testAddPoints() {
		MasterShip ms = MasterShip.getInstance(new Grid(), "test");
		int points = 10;
		
		ms.addPoints(points);
		
		int actual = ms.getScore();
		int expected = points;
		
		assertTrue(actual == expected);
	}
}
