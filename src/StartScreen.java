import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;


public class StartScreen extends JPanel {
	private Screen parent;
	private String playerName;
	private int gridSize;
	private boolean startClicked;	
	private JLabel title;
	private JLabel lblSize;
	private JComboBox<Integer> sizeSelect;
	private JLabel lblName;
	private JTextField nameField;
	//private JButton startButton;

	public StartScreen(Screen theScreen) {
		setParent(theScreen);
		setStartClicked(false);
		setSize(400, 400);
		setLayout(null);
		add(getTitle());
		add(getLblSize());
		add(getSizeSelect());
		add(getLblName());
		add(getNameField());
		//add(getStartButton());
	}

	/*public StartScreen(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public StartScreen(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public StartScreen(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}*/

	public Screen getParent() {
		return parent;
	}

	public void setParent(Screen parent) {
		this.parent = parent;
	}

	private JLabel getTitle() {
		if(title == null){
			title = new JLabel();
			title.setText("Welcome to Sky Wars");
			title.setBounds(100, 10, 200, 15);
		}
		return title;
	}

	private JLabel getLblSize() {
		if(lblSize == null){
			lblSize = new JLabel();
			lblSize.setText("Select Grid size");
			lblSize.setBounds(20, 80, 100, 15);
		}
		return lblSize;
	}

	private JComboBox<Integer> getSizeSelect() {
		if(sizeSelect == null){
			sizeSelect = new JComboBox<Integer>();
			sizeSelect.setBounds(130, 80, 40, 15);
			for(int loop = 0; loop < 6; loop++){
				sizeSelect.addItem(loop + 4);
			}
		}
		return sizeSelect;
	}

	private JLabel getLblName() {
		if(lblName == null){
			lblName = new JLabel("Input your name");
			lblName.setBounds(20, 50, 100, 15);
		}
		return lblName;
	}

	private JTextField getNameField() {
		if(nameField == null){
			nameField = new JTextField();
			nameField.setBounds(130, 50, 130, 15);
		}
		return nameField;
	}

	/*private JButton getStartButton() {
		System.out.println("getting start button");
		if(startButton == null){
			startButton = new JButton("Start");
			startButton.setBounds(100, 110, 100, 20);
			startButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("something");
				}
			});
		}
		return startButton;
	}*/

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getGridSize() {
		return this.gridSize;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	public boolean isStartClicked() {
		return this.startClicked;
	}

	public void setStartClicked(boolean startClicked) {
		this.startClicked = startClicked;
	}

}
