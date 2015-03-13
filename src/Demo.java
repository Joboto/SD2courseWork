
public class Demo {

	public static void main(String[] args) {
		Grid g = new Grid();
		Ship s1 = new Ship(g, "Dave");
		g.initializeGrid(7);
		g.put(3, 3, s1);
		g.print();
		for(Movement move : Movement.values()){
			s1.move(move);
			//g.print();
		}
		g.print();
		g.whatsAt(4, 2);
		g.whatsAt(6, 3);
		
		/*g.clear(3, 3);
		g.print();
		System.out.println(s1.printCoords());
		g.put(5, 5, s1);
		g.print();
		g.clear(5, 5);
		g.put(2, 2, s1);
		System.out.println(s1.printCoords());
		g.print();*/
		
	}

}
