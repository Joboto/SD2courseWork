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

	public void testGetScore() {
		fail("Not yet implemented");
	}

	public void testSetScore() {
		fail("Not yet implemented");
	}

	public void testShip() {
		fail("Not yet implemented");
	}

	public void testMove() {
		fail("Not yet implemented");
	}

	public void testLeaveCurrentPos() {
		fail("Not yet implemented");
	}

	public void testPrintCoords() {
		fail("Not yet implemented");
	}

	public void testGetPosition() {
		fail("Not yet implemented");
	}

	public void testSetPosition() {
		fail("Not yet implemented");
	}

	public void testImagePath() {
		fail("Not yet implemented");
	}

	public void testGetName() {
		fail("Not yet implemented");
	}

	public void testSetName() {
		fail("Not yet implemented");
	}

	public void testGetGameGrid() {
		fail("Not yet implemented");
	}

	public void testSetGameGrid() {
		fail("Not yet implemented");
	}

}
