import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Screen extends JFrame {
	private StartScreen startScreen;
	private Game newGame;
	private JSplitPane splitPane;
	private JSplitPane subSplit;
	private JPanel gridPane;
	private JPanel buttonsPane;
	private JPanel infoPane;
	private JLabel titeLabel;
	private JLabel nameLabel;	
	private JLabel scoreLabel;
	private JLabel eventLabel;
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
		
		newGame = new Game();
		int frameSize = newGame.getSize() * 100;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, frameSize, frameSize + 50);
		
		setContentPane(getSplitPane());
		setBackground(new Color(0, 0, 0));
		add(getStartScreen());
		startScreen.setVisible(true);
		
	}//end Screen
	
	private StartScreen getStartScreen(){
		if(startScreen == null){
			startScreen = new StartScreen();
		}
		return startScreen;
	}
	
	private JSplitPane getSplitPane(){
		if(splitPane == null){
			splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			splitPane.setLeftComponent(getGridPane(newGame.getSize()));
			splitPane.setRightComponent(getSubSplit());
			//splitPane.setDividerLocation(250);
			splitPane.setBackground(Color.BLACK);
		}
		return splitPane;
	}
	
	private JSplitPane getSubSplit(){
		if(subSplit == null){
			subSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			subSplit.setLeftComponent(getInfoPane());
			subSplit.setRightComponent(getButtonPane());
		}
		return subSplit;
	}
		
 	private JPanel getGridPane(int size) {
		if(gridPane == null){
			gridPane = new JPanel();
			gridPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			gridPane.setSize(400, 400);
			gridPane.setLayout(new GridLayout(size, size, 0, 0));
			gridPane.setOpaque(false);
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
 	
 	private JPanel getInfoPane(){
		if(infoPane == null){
			infoPane = new JPanel();
			infoPane.setLayout(new GridLayout(5, 1));
			infoPane.add(getTitleLabel());
			infoPane.add(getNameLabel());
			infoPane.add(getEventLabel());
			infoPane.add(getScoreLabel());
			updateInfo();
		}
		return infoPane;
	}
 	
 	private JLabel getTitleLabel(){
 		if (titeLabel == null) {
 			titeLabel = new JLabel("****SKY WARS****");
 		}
 		return titeLabel;
 	}
 	
 	private JLabel getNameLabel(){
 		if (nameLabel == null){
 			nameLabel = new JLabel("Player: "+newGame.getPlayer().getName());
 		}
 		return nameLabel;
 	}
	
	private JLabel getScoreLabel() {
		if (scoreLabel == null) {
			scoreLabel = new JLabel("Score: "+this.newGame.getPlayer().getScore());
			//scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
			//scoreLabel.setFont(new Font("Papyrus", Font.PLAIN, 22));
			scoreLabel.setBounds(10, 11, 199, 41);
		}
		return scoreLabel;
	}
	
	private JLabel getEventLabel() {
		if(eventLabel == null){
			eventLabel = new JLabel();
		}
		return eventLabel;
	}
	
	private void updateInfo(){
		scoreLabel.setText("Score: "+this.newGame.getPlayer().getScore());
		eventLabel.setText(this.newGame.getNews());
	}
	
	private JPanel getButtonPane(){
		if(buttonsPane == null){
			buttonsPane = new JPanel();
			buttonsPane.setLayout(new GridLayout(3, 3));
			buttonsPane.setMaximumSize(new Dimension(100, 100));
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
				newGame.go(move);
				for(int y = 0; y < newGame.getSize(); y++){
					for(int x = 0; x < newGame.getSize(); x++){
						squares[x][y].update();
					}
				}
				updateInfo();
			}
		});
		//button.setSize(10, 10);
		return button;
	}
	
	
}
