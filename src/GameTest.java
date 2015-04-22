import java.util.HashSet;

import junit.framework.TestCase;


public class GameTest extends TestCase {
	
	public void testEndGame() {
		//Creating required objects and setting them up for testing.
		Game game = new Game(5, "");
		
		//Method being tested
		game.endGame();
		
		//Check outcome;
		MasterShip expectedPlayer = null;
		MasterShip actualPlayer = game.getPlayer();
		
		Grid expectedGrid = null;
		Grid actualGrid = game.getTheGrid();
		
		HashSet<EnemyShip> actualEnemys = game.getAllEnemys();
		
		assertTrue(expectedPlayer == actualPlayer && expectedGrid == actualGrid && actualEnemys.isEmpty());
		
	}

	public void testGo() {
		//Creating required objects and setting them up for testing.
		Game game = new Game(5, "");
		Movement move = Movement.SE;
		Square playerStart = game.getPlayer().getPosition();
				
		//Method being tested
		game.go(move);
		
		//Check outcome; this method carries out many actions, the outcomes of which will be tested below
		//We will check one outcome here
		Square actual = game.getPlayer().getPosition();
		
		assertFalse(actual.equals(playerStart));
	}

	public void testCheckPlrSquare() {
		//Creating required objects and setting them up for testing.
		Game game = new Game(5, "");
		//Will create 3 enemyShips and retrieve test values after each one is added and method run
		BattleStar b1 = new BattleStar(game.getTheGrid());
		BattleStar b2 = new BattleStar(game.getTheGrid());
		BattleStar b3 = new BattleStar(game.getTheGrid());
		
		//Case: 2
		game.getTheGrid().put(0, 0, b1);
		game.getAllEnemys().add(b1);
		game.checkPlrSquare();
		boolean case2expected = game.getAllEnemys().contains(b1);
		
		//default: (i.e. more than two enemy ships)
		game.getTheGrid().put(0, 0, b2);
		game.getTheGrid().put(0, 0, b3);
		game.checkPlrSquare();
		boolean actualDefault = game.isGameOver(); 
		
		//Check outcome; Ideally more scenarios would be tested
		assertTrue(actualDefault && !case2expected);
	}

	public void testNewBattleStar() {
		//Creating required objects and setting them up for testing.
		Game game = new Game(5, "");
		
		//Method being tested
		game.newBattleStar();
		
		//Check outcome; 
		EnemyShip actual = game.getAllEnemys().iterator().next();
		BattleStar expected = new BattleStar(game.getTheGrid());
		
		assertTrue(actual.getClass() == expected.getClass());
	}

	public void testNewBattleCruiser() {
		//Creating required objects and setting them up for testing.
		Game game = new Game(5, "");
		
		//Method being tested
		game.newBattleCruiser();
		
		//Check outcome; 
		EnemyShip actual = game.getAllEnemys().iterator().next();
		BattleCruiser expected = new BattleCruiser(game.getTheGrid());
		
		assertTrue(actual.getClass() == expected.getClass());
	}

	public void testNewBattleShooter() {
		//Creating required objects and setting them up for testing.
		Game game = new Game(5, "");
		
		//Method being tested
		game.newBattleShooter();
		
		//Check outcome; 
		EnemyShip actual = game.getAllEnemys().iterator().next();
		BattleShooter expected = new BattleShooter(game.getTheGrid());
		
		assertTrue(actual.getClass() == expected.getClass());
	}

}
