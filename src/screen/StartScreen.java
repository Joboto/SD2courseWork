package screen;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StartScreen extends JPanel {
	private JLabel title;
	private JLabel lblSize;
	private JComboBox<Integer> sizeSelect;
	private JLabel lblName;
	private JTextField nameField;
	
	public StartScreen() {
		setSize(400, 400);
		setLayout(null);
		add(getTitle());
		add(getLblSize());
		add(getSizeSelect());
		add(getLblName());
		add(getNameField());
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

	public String playerName(){
		return nameField.getText();
	}
	
	public int gridSize(){
		return (int) sizeSelect.getSelectedItem();
	}

}
