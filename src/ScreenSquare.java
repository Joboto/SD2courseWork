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
	ImageIcon bg;
	
	public ScreenSquare(int gridX, int gridY, Grid gameGrid){
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.setSize(50, 50);
		x = gridX;
		y = gridY;
		grid = gameGrid;
		bg = new ImageIcon(this.getClass().getResource("bgSpc.PNG"));
		update();
		}
	
	public void update(){
		Square position = grid.whatsAt(x, y);
		if(position.getShips().isEmpty()){
			this.setIcon(bg);
		} else {
			try {
				String path = position.getShips().iterator().next().imagePath();
				this.setIcon(new ImageIcon(this.getClass().getResource(path)));
			} catch (NullPointerException e){
				System.out.println(e.toString());
			}
		}
		//this.setIcon(image);
	}
}
