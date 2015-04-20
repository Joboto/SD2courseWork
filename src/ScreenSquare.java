import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//import javax.swing.JButton;


public class ScreenSquare extends JLabel {
	int x, y;
	Grid grid;
	//ImageIcon bg;
	BgSketch bg;
	
	public ScreenSquare(int gridX, int gridY, Grid gameGrid){
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.setSize(50, 50);
		x = gridX;
		y = gridY;
		grid = gameGrid;
		//bg = new ImageIcon(this.getClass().getResource("bgSpc.PNG"));
		//update();
		bg = new BgSketch();
		bg.init();
		}
	
	public void update(){
		Square position = grid.whatsAt(x, y);
		String path;
		switch(position.getShips().size()){
		case 0:
			this.add(bg);
			bg.draw();
			//path = "bgSpc.PNG";
			break;
		case 1:
			path = position.getShips().iterator().next().imagePath();
			this.setIcon(new ImageIcon(this.getClass().getResource(path)));
			break;
		default:
			path = "Fleet.PNG";
			this.setIcon(new ImageIcon(this.getClass().getResource(path)));
			break;
				
		}
		
		//this.setIcon(new ImageIcon(this.getClass().getResource(path)));
	}
}
