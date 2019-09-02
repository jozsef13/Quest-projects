package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class HealthItem extends JFrame implements ItemTypeRole, Serializable {

	private int x;
	private int y;
	private int prizeValue;
	
	@Override
	public void set(int x1, int y1, GUIController controller) {
		x = x1;
		y = y1;
		setTitle("Add value to the prize");
		setBounds(300, 200, 500, 150);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();

		getContentPane().add(panel);

		JLabel setPrizeValue = new JLabel("Enter the health value : ");
		panel.add(setPrizeValue);

		JTextField prizeValueText = new JTextField("", 25);
		prizeValueText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(prizeValueText);
		
		JButton addValueButton = new JButton("Add");
		
		addValueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prizeValue = Integer.parseInt(prizeValueText.getText());
				prizeValueText.setText("");
				controller.addHealthAt(x, y, prizeValue);
				setVisible(false);
			}
		});
		
		panel.add(addValueButton);
		add(panel);
		setVisible(true);
	}

}
