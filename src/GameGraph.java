import processing.core.PApplet;


public class GameGraph extends PApplet{
	int scale;
	int size;
	Game g;
	MasterGraphic master;
	
	/*public GameGraph(Game game){
		g = game;
		size = g.getSize() * scale;
		init();
		noLoop();
	}*/
	
	public void setup(){
		size(size, size);
		master = new MasterGraphic(this, g.getPlayer(), scale);
		//noLoop();
	}
	
	public void draw(){
		master.display();
		//noLoop();
	}

}
