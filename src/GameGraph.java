import processing.core.PApplet;


public class GameGraph extends PApplet{
	final int scale = 50;
	int size;
	Game g;
	MasterGraphic master;
	
	public GameGraph(Game game){
		g = game;
		size = g.getSize() * scale;
		this.init();
	}
	
	public void setup(){
		size(size, size);
		master = new MasterGraphic(this, g.getPlayer(), scale);
		noLoop();
	}
	
	public void draw(){
		master.display();
	}

}
