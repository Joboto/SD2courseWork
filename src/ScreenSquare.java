import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;


public class ScreenSquare extends JLabel {
	int x, y;
	Grid grid;
	
	public ScreenSquare(int gridX, int gridY, Grid gameGrid){
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setSize(50, 50);
		x = gridX;
		y = gridY;
		grid = gameGrid;
		update();
		}
	
	public void update(){
		this.setText(grid.whatsAt(x, y).description());
	}
}
