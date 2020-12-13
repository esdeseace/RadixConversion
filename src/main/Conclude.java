package main;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class Conclude extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel decudeLabel;
	
	public Conclude(String sourceString, int sourceRadix, String resultString, int resultRadix) {
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setSize(900, 29);
		setBackground(Color.white);
		
		decudeLabel = new JLabel("-> ");
		decudeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(decudeLabel);
		
		JLabel sourceNumberLabel = new JLabel(sourceString);
		sourceNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(sourceNumberLabel);
		
		JLabel sourceRadixLabel = new JLabel("<html><br>(" + Integer.toString(sourceRadix) + ")</html>");
		sourceRadixLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		add(sourceRadixLabel);
		
		JLabel equalLabel = new JLabel(" = ");
		equalLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(equalLabel);
		
		JLabel resultNumberLabel = new JLabel(resultString);
		resultNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(resultNumberLabel);
		
		JLabel resultRadixLbael = new JLabel("<html><br>(" + Integer.toString(resultRadix) + ")</html>");
		resultRadixLbael.setFont(new Font("Tahoma", Font.PLAIN, 10));
		add(resultRadixLbael);
		
	}
	
	public void setConclude() {
		decudeLabel.setText("Kết luận: ");
	}

}
