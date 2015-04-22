import junit.framework.TestCase;


public class BattleShooterTest extends TestCase {

	public void testCharacteristicMove() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid();
		BattleShooter bs = new BattleShooter(g);
		MasterShip ms = MasterShip.getInstance(g, "");
		g.initializeGrid(5);
		g.put(1, 1, bs);
		g.put(2, 2, ms);
		
		//Method being tested
		bs.characteristicMove();
		
		//Check outcome; bs should move away from ms
		//Ideally this would be tested for all directions and for when bs against left or upper boarder, when it should move away from the boarder
		Square actual = bs.getPosition();
		Square expected = g.whatsAt(0, 0);
		
		assertTrue(actual.equals(expected));
	}

	public void testUpdate() {
		//Creating required objects and setting them up for testing.
		Grid g = new Grid(); 
		MasterShip ms = MasterShip.getInstance(g, "");
		BattleShooter bs = new BattleShooter(g);
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

}
