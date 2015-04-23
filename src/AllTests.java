import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BattleCruiserTest.class);
		suite.addTestSuite(BattleShooterTest.class);
		suite.addTestSuite(BattleStarTest.class);
		suite.addTestSuite(GameTest.class);
		suite.addTestSuite(GridTest.class);
		suite.addTestSuite(MasterShipTest.class);
		suite.addTestSuite(SquareTest.class);
		//$JUnit-END$
		return suite;
	}

}
