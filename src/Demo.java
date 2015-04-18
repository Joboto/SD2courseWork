import java.util.Random;


public class Demo {

	public static void main(String[] args) {
		/*Grid grid = new Grid();
		EnemyShip enemy = new EnemyShip(grid);
		MasterShip masterShip = MasterShip.getInstance(grid, "bar");
		
		grid.initializeGrid(8);
		grid.put(1, 1, masterShip);
		grid.put(8, 8, enemy);
		
		System.out.println(masterShip.getScore());
		masterShip.addPoints(5);
		System.out.println(masterShip.getScore());*/
		
		
		Square start = new Square(4, 4);
		Square end = new Square(5, 5);
		System.out.println(Movement.O.xChange()+" "+Movement.O.yChange());
		Movement someMove = Movement.vector(start, end);
		
		System.out.println(someMove);
		System.out.println(Movement.O.xChange()+" "+Movement.O.yChange());
		//System.out.println(someMove.xChange()+""+someMove.yChange());
		
		
	}

}
