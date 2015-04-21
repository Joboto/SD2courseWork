import processing.core.PApplet;


public class Graphics extends PApplet {
	int size = 500;
	Game game = new Game();
	MasterGraphic player = new MasterGraphic(this, game.getPlayer(), 50);
	
	public static void main(String args[]){
		PApplet.main(new String[] {"--present", "Graphics"});
	}
	
	public void setup(){
		size(size, size);
		background(0);
		//noLoop();
	}
	
	public void draw(){
		int x = game.getPlayer().getPosition().getX();
		int y = game.getPlayer().getPosition().getY();
		
		fill(255, 0, 0);
		ellipse(x + 50, y + 50, 50, 50);
		//player.display();
		
		if(keyPressed){
			System.out.println(key);
			int num = (int) key;
			System.out.println(Character.getNumericValue(key));
			if(num == 1){
				System.out.println(Movement.SW.name());
			} else {
				System.out.println(key);
			}
		}
		keyPressed = false;
	}

}
