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
	ImageIcon image;
	
	public ScreenSquare(int gridX, int gridY, Grid gameGrid){
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.setSize(50, 50);
		x = gridX;
		y = gridY;
		grid = gameGrid;
		image = new ImageIcon(this.getClass().getResource("bgSpc.PNG"));
		update();
		}
	
	public void update(){
		String description = grid.whatsAt(x, y).description();
		/*if(description != null){
			this.setText(description);
		} else {
			this.setIcon(image);
		}*/
		this.setIcon(image);
	}
}
