import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;


public class Screen extends JFrame {
	private JPanel contentPane;
	private Grid grid = new Grid(); 

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
		ScreenSquare square[][] = new ScreenSquare[size][size];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 0, 0));
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				square[x][y] = new ScreenSquare();
				contentPane.add(square[x][y]);
			}
		}
		
	}

}
