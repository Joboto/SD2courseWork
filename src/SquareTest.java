import junit.framework.TestCase;


public class SquareTest extends TestCase {

	public void testAddShip() {
		//Creating required objects and setting them up for testing.
		Square s = new Square();
		BattleStar bs = new BattleStar(new Grid());
		
		//Method being tested
		s.addShip(bs);
		
		//Check outcome; ideally we would test for more types of ship
		assertTrue(s.getShips().contains(bs));
	}

	public void testRemoveShip() {
		//Creating required objects and setting them up for testing.
		Square s = new Square();
		BattleStar bs = new BattleStar(new Grid());
		s.addShip(bs);
		
		//Method being tested
		s.removeShip(bs);
		
		//Check outcome; ideally we would test for more types of ship
		assertFalse(s.getShips().contains(bs)); 
	}

}
