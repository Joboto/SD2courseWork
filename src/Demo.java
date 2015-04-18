import java.util.Random;


public class Demo {

	public static void main(String[] args) {
		Grid grid = new Grid();
		/*EnemyShip enemy = new EnemyShip(grid);
		MasterShip masterShip = MasterShip.getInstance(grid, "bar");
		
		grid.initializeGrid(8);
		grid.put(1, 1, masterShip);
		grid.put(8, 8, enemy);
		
		System.out.println(masterShip.getScore());
		masterShip.addPoints(5);
		System.out.println(masterShip.getScore());*/
		
		
		EnemyShip generic;
		BattleCruiser cruise = new BattleCruiser(grid);
		
		generic = cruise;
		
		System.out.println(generic.getClass());
		System.out.println(BattleCruiser.class);
		
		
	}

}
