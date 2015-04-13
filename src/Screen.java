import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Screen extends JFrame {
	private Game newGame;
	private JSplitPane splitPane;
	private JPanel gridPane;
	private JPanel buttonsPane;
	private JLabel bg = new JLabel(new ImageIcon("bgspace.png"));
	private ScreenSquare squares[][];
	
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
		setBounds(100, 100, 300, 400);
		
		newGame = new Game();
		
		splitPane.setLeftComponent(getGridPane(newGame.getSize()));
		splitPane.setRightComponent(getButtonPane());
		splitPane.setDividerLocation(250);
		
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
					squares[x][y] = new ScreenSquare(x, y, newGame.getTheGrid());
					gridPane.add(squares[x][y]);
				}
			}//end for, creating grid
		}
		return gridPane;
	}
	
	private JPanel getButtonPane(){
		if(buttonsPane == null){
			buttonsPane = new JPanel();
			buttonsPane.setLayout(new GridLayout(3, 3));
			for(Movement move : Movement.values()){
				buttonsPane.add(getMoveButton(move));
			}
			
		}
		return buttonsPane;
	}
	
	private JButton getMoveButton(final Movement move) {
		JButton button = new JButton(move.name());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//here's the action; move the player
				newGame.go(move);
				/*after the movement, we then refresh. When movement is done at time intervals, 
				this for loop will will have to be done elsewhere, in the game...
				but not nessecarily*/ 
				//lets include a random movement for the enemy, Bob
				for(int y = 0; y < newGame.getSize(); y++){
					for(int x = 0; x < newGame.getSize(); x++){
						squares[x][y].update();
					}
				}
			}
		});
		//button.setSize(10, 10);
		return button;
	}
	
}
