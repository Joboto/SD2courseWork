import junit.framework.TestCase;


public class BattleStarTest extends TestCase {

	public void testCharacteristicMove() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid();
		BattleStar bs = new BattleStar(g);
		g.initializeGrid(5);
		g.put(2, 2, bs);
		Square initialPosition = bs.getPosition();
		
		//Method being tested
		bs.characteristicMove();
		
		//Check outcome; bs moves randomly
		//The true randomness would be difficult to test, so in this case we make sure that bs has moved
		Square actual = bs.getPosition();
		Square notExpected = initialPosition;
		
		assertFalse(actual.equals(notExpected));
	}

}
