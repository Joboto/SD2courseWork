import processing.core.*;

public class MasterGraphic {
	int scale;
	MasterShip ship;
	PApplet parent;
	
	public MasterGraphic(PApplet p, MasterShip s, int theScale){
		parent = p;
		ship = s;
		scale = theScale;
		}
	
	public void display(){
		int x = (ship.getPosition().getX() * scale) + (scale / 2);
		int y = (ship.getPosition().getY() * scale) + (scale / 2);
		parent.noStroke();
		parent.fill(255, 0, 0);
		parent.ellipse(x, y, scale/2 , scale/2);
	}
}
