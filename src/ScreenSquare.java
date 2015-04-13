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
	ImageIcon bg, bStar, master;
	
	public ScreenSquare(int gridX, int gridY, Grid gameGrid){
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.setSize(50, 50);
		x = gridX;
		y = gridY;
		grid = gameGrid;
		bg = new ImageIcon(this.getClass().getResource("bgSpc.PNG"));
		bStar = new ImageIcon(this.getClass().getResource("enemy1.PNG"));
		master = new ImageIcon(this.getClass().getResource("master.PNG"));
		update();
		}
	
	public void update(){
		String description = grid.whatsAt(x, y).description();
		//this.setText(description);
		if(description != null){
			this.setIcon(master);
		} else {
			this.setIcon(bg);
		}
		//this.setIcon(image);
	}
}
