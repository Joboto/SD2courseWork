import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Screen extends JFrame {
	private int size = 4;
	private Grid grid = new Grid();
	private Ship ship;
	private JSplitPane splitPane;
	private JPanel gridPane;
	private JPanel buttonsPane;
	private ScreenSquare squares[][];
	private JButton actionButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Screen() {
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		grid.initializeGrid(size);
		ship = new Ship(grid, "Dave");
		grid.put(0, 0, ship);
		
		splitPane.setLeftComponent(getGridPane(size));
		splitPane.setRightComponent(getButtonPane());
		
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new BorderLayout());
		setContentPane(splitPane);
		
	}//end Screen
	
	private JPanel getGridPane(int size) {
		if(gridPane == null){
			gridPane = new JPanel();
			gridPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			gridPane.setSize(400, 400);
			gridPane.setLayout(new GridLayout(size, size, 0, 0));
			squares = new ScreenSquare[size][size];
			for(int y = 0; y < size; y++){
				for(int x = 0; x < size; x++){
					squares[x][y] = new ScreenSquare(x, y, grid);
					gridPane.add(squares[x][y]);
				}
			}//end for, creating grid
		}
		return gridPane;
	}
	
	private JPanel getButtonPane(){
		if(buttonsPane == null){
			buttonsPane = new JPanel();
			buttonsPane.add(getActionButton(), BorderLayout.CENTER);
		}
		return buttonsPane;
	}
	
	private JButton getActionButton() {
		if (actionButton == null) {
			actionButton = new JButton("Northwards");
			actionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ship.move(Movement.N);
					for(int y = 0; y < size; y++){
						for(int x = 0; x < size; x++){
							squares[x][y].update();
						}
					}
				}
			});
			actionButton.setSize(10, 10);
		}//end if
		return actionButton;
	}

}
