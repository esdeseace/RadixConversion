package main;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorNotify extends JDialog {

	private static final long serialVersionUID = 1L;

	public ErrorNotify(String string) {
		
		setBounds(750, 100, 309, 163);
		setTitle("Error");
		getContentPane().setLayout(null);
		
		JButton button = new JButton("OK");
		button.setBounds(106, 70, 60, 33);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setActionCommand("OK");
		
		JLabel errorLabel = new JLabel(string);
		errorLabel.setBounds(0, 13, 291, 37);
		getContentPane().add(errorLabel);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
				
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
