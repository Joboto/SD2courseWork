import junit.framework.TestCase;


public class BattleCruiserTest extends TestCase {

	public void testUpdate() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid(); 
		MasterShip ms = MasterShip.getInstance(g, "");
		BattleCruiser bs = new BattleCruiser(g);
		g.initializeGrid(5);
		g.put(0, 0, ms);
		g.put(0, 0, bs);
		ms.addObserver(bs);
		
		//Method being tested
		bs.update(ms.getPosition());
		
		//Check outcome; BattleCruiser should 'know' where the MasterShip is
		Square actual = bs.getMasterPosition();
		Square expected = ms.getPosition();
		
		assertTrue(actual.equals(expected));
		
	}

	public void testCharacteristicMove() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid(); 
		MasterShip ms = MasterShip.getInstance(g, "");
		BattleCruiser bs = new BattleCruiser(g);
		g.initializeGrid(5);
		g.put(1, 1, ms);
		g.put(0, 0, bs);
		ms.addObserver(bs);
		bs.notify();
		
		//Method being tested
		bs.characteristicMove();
		
		//Check outcome; bs should move towards ms and therefore now be in the same position as they were adjacent
		//Ideally, we would test for all directions.
		Square actual = bs.getPosition();
		Square expected = ms.getPosition();
		
		assertTrue(actual.equals(expected));
		
	}

	public void testMove() {
		//This method belongs to all Ships, but is only being tested for this subclass
		//Creating required objects and setting them up for testing.
		Grid g = new Grid(); 
		BattleCruiser bs = new BattleCruiser(g);
		g.initializeGrid(5);
		g.put(3, 3, bs);
		
		//Method being tested
		bs.move(Movement.E);
		
		//Check outcome
		//Again, we would ideally check for all movements
		Square actual = bs.getPosition();
		Square expected = g.whatsAt(4, 3);
		
		assertTrue(actual.equals(expected));
	}

	public void testImagePath() {
		//This method belongs to all Ships, but is only being tested for this subclass
		//Creating required objects and setting them up for testing.
		BattleCruiser bs = new BattleCruiser(new Grid());
		
		//Method being tested
		String path = bs.imagePath();
		
		//Check outcome; 
		String actual = path;
		String expected = "BattleCuiser.PNG";
		
		assertTrue(actual.equals(expected));
	}

}
