import processing.core.*;

public class TestSketch extends PApplet {
	
	public void setup(){
		size(400, 400);
		background(0);
	}
	
	public void draw(){
		noStroke();
		fill(255, 0, 0);
		ellipse(400, 400, 50, 50);
	}
}
