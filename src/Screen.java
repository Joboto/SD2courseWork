import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Screen extends JFrame {
	private JPanel contentPane;
	private JPanel buttonsPane;
	private Grid grid = new Grid();
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
		int size = 4;
		grid.initializeGrid(size);
		squares = new ScreenSquare[size][size];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(size, size, 0, 0));
		for(int y = 0; y < size; y++){
			for(int x = 0; x < size; x++){
				squares[x][y] = new ScreenSquare(x, y, grid);
				contentPane.add(squares[x][y]);
			}
		}//end for, creating grid
		buttonsPane = new JPanel();
		buttonsPane.add(getActionButton());
		
	}//end Screen
	
	private JButton getActionButton() {
		if (actionButton == null) {
			actionButton = new JButton("Hazza!");
			actionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			actionButton.setSize(10, 10);
		}//end if
		return actionButton;
	}

}
