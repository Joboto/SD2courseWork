import junit.framework.TestCase;


public class GridTest extends TestCase {

	public void testInitializeGrid() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid();
		int size = 6;
		
		//Method being tested
		g.initializeGrid(size);
		
		//Check outcome; 
		Square[][] expectedArray = new Square[size][size];
		Square[][] actualArray = g.getGameGrid();
		
		assertTrue(expectedArray.getClass() == actualArray.getClass() && expectedArray.length == actualArray.length);
	}

	public void testWhatsAt() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid();
		g.initializeGrid(5);
				
		//Method being tested
		Square actual = g.whatsAt(0, 0);
		
		//Check outcome; ideally we would check all points in the grid and for different sizes
		Square expected = new Square();
		
		assertTrue(actual.getClass() == expected.getClass());
	}

	public void testPut() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid();
		BattleStar bs = new BattleStar(g);
		g.initializeGrid(5);
		
		//Method being tested
		g.put(0, 0, bs);
		
		//Check outcome; ideally we would check for all ships and all squares on different sizes of grids
		assertTrue(g.whatsAt(0, 0).getShips().contains(bs));
		
	}

	public void testClear() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid();
		BattleStar bs = new BattleStar(g);
		g.initializeGrid(5);
		g.put(0, 0, bs);
		
		//Method being tested
		g.clear(0, 0);
		
		//Check outcome; ideally we would check for all ships and all squares on different sizes of grids
		assertFalse(g.whatsAt(0, 0).getShips().contains(bs)); 
	}

	
}
