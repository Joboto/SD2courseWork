import java.util.Random;


public class Demo {

	public static void main(String[] args) {
		/*Grid g = new Grid();
		g.initializeGrid(4);
		
		Ship dave = new Ship(g, "Dave");
		
		Square box = new Square();
		
		box.setX(1);
		box.setY(1);
		box.addShip(dave);
		
		g.put(1, 1, dave);
		
		g.print();*/
		
		Random random = new Random();
		Movement randomMove = Movement.values()[random.nextInt(Movement.values().length)];
		System.out.println(randomMove);
		
	}

}
