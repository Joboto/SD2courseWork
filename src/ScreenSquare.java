import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;


public class ScreenSquare extends JLabel /*implements ActionListener*/ {
	/*int x, y;
	byte value = 0;
	Grid grid;*/
	
	public ScreenSquare(int gridX, int gridY, Grid gameGrid){
		/*x = gridX;
		y = gridY;
		grid = gameGrid;*/
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setText(gameGrid.whatsAt(gridX, gridY).description());
		/*X = new ImageIcon(this.getClass().getResource("X.jpg"));
		O = new ImageIcon(this.getClass().getResource("O.jpg"));*/
		//this.addActionListener(this);
	}
	
	/*public void actionPerformed(ActionEvent e){
		value++;
		value %= 3;
		switch(value){
		case 0:
			this.setText(grid.whatsAt(x, x).description());
			break;
		case 1:
			Ship s = new Ship(grid, "Dave");
			grid.put(x, y, s);
			this.setText(grid.whatsAt(x, x).description());
			break;
		case 2:
			grid.whatsAt(x, y).getShip().move(Movement.N);
			this.setText(grid.whatsAt(x, x).description());
			break;
		}
	}*/
}
