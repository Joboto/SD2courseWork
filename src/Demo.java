
public class Demo {

	public static void main(String[] args) {
		Grid g = new Grid();
		Ship s1 = new Ship(g, "Dave");
		g.initializeGrid(7);
		g.put(3, 3, s1);
		g.print();
		for(Movement move : Movement.values()){
			s1.move(move);
			s1.printCoords();
		}
		g.print();
		
	}

}
