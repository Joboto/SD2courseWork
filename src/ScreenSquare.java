import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ScreenSquare extends JLabel {
	int x, y;
	Grid grid;
	
	public ScreenSquare(int gridX, int gridY, Grid gameGrid){
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		x = gridX;
		y = gridY;
		grid = gameGrid;
		update();
		}
	
	public void update(){
		Square position = grid.whatsAt(x, y);
		String path;
		switch(position.getShips().size()){
		case 0:
			path = "bgSpc.PNG";
			break;
		case 1:
			path = position.getShips().iterator().next().imagePath();
			break;
		default:
			path = "Fleet.PNG";
			break;
				
		}
		this.setIcon(new ImageIcon(this.getClass().getResource(path)));
	}
}
