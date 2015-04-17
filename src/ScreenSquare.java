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
		String description = grid.whatsAt(x, y).description();
		//this.setText(description);
		if(description != null){
			String path = description+".PNG";
			try {
				this.setIcon(new ImageIcon(this.getClass().getResource(path.trim())));
			} catch (NullPointerException e){
				System.out.println(e.toString());
			}
			
		} else {
			this.setIcon(bg);
		}
		//this.setIcon(image);
	}
}
