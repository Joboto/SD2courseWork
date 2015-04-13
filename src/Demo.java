import java.util.Random;


public class Demo {

	public static void main(String[] args) {
		Grid grid = new Grid();
		EnemyShip enemy = new EnemyShip(grid, "foo");
		MasterShip masterShip = MasterShip.getInstance(grid, "bar");
		
		System.out.println(masterShip.getClass());
		System.out.println(enemy.getClass());
		
		
	}

}
