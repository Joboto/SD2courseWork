import processing.core.*;

public class TestSketch extends PApplet {
	private Game game;
	private int sketchSize; 
	private PImage bg;
	
	public TestSketch(Game game){
		setGame(game);
		setSketchSize((game.getSize() * 50));
		this.init();
	}
	
	public void setup(){
		size(getSketchSize(), getSketchSize());
		this.bg = loadImage("bgspace.png");
		this.bg.resize(sketchSize, sketchSize);
		noLoop();
	}
	
	public void draw(){
		image(this.bg, 0, 0);
		
		int Px = this.game.getPlayer().getPosition().getX() * 50;
		int Py = this.game.getPlayer().getPosition().getY() * 50;
		noStroke();
		fill(255, 0, 0);
		ellipse(Px + 25, Py + 25, 25, 25);
		
		for(EnemyShip dave : game.enemys()){
			int Dx = dave.getPosition().getX();
			int Dy = dave.getPosition().getY();
			noStroke();
			fill(0, 255, 0);
			ellipse(Dx + 20, Dy + 20, 25, 25);
		}
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getSketchSize() {
		return sketchSize;
	}

	public void setSketchSize(int sketchSize) {
		this.sketchSize = sketchSize;
	}
}
