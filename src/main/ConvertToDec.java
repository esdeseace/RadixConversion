package main;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class ConvertToDec extends JPanel {

	private static final long serialVersionUID = 1L;
	private String string;
	private int radix;
	private int result = 0;
	
	public ConvertToDec(String string, int radix) {
		this.string = string;
		this.radix = radix;
		doSomething();
	}
	
	public int getResult() {
		return this.result;
	}
	
	private void doSomething() {
		
		setSize(2000, 160);
		setLayout(null);
		setBackground(Color.white);
		JLabel label = new JLabel("Chuyển từ " + Integer.toString(radix) + " sang 10:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(0, 0, 162, 19);
		add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel basePanel = new JPanel();
		basePanel.setBackground(Color.white);
		basePanel.setBounds(0, 32, 2000, 32);
		add(basePanel);
		basePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JLabel sourceNumberLabel = new JLabel(string);
		sourceNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		basePanel.add(sourceNumberLabel);
		
		JLabel sourceRadixLabel = new JLabel("<html><br>("+ Integer.toString(radix) +")</html>");
		sourceRadixLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		basePanel.add(sourceRadixLabel);

		JLabel equalLabel1 = new JLabel(" = ");
		equalLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		basePanel.add(equalLabel1);
		
		int pow, coeff;
		for (int i = string.length() - 1; i >= 0; i--) {
			pow = string.length() - 1 - i;
			coeff = getNumber(string.charAt(i));
			result += coeff * Math.pow(radix, pow);
			PlusPanel plusPanel = new PlusPanel(coeff, pow);
			if (i == 0)
				plusPanel.setPlusText();
			basePanel.add(plusPanel);
		}
		
		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(Color.white);
		resultPanel.setBounds(0, 77, 2000, 32);
		add(resultPanel);
		resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		JLabel tempLabel1 = new JLabel(string);
		tempLabel1.setForeground(Color.WHITE);
		tempLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resultPanel.add(tempLabel1);
		
		JLabel tempLabel2 = new JLabel("<html><br>("+ Integer.toString(radix) +")</html>");
		tempLabel2.setForeground(Color.WHITE);
		tempLabel2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		resultPanel.add(tempLabel2);
		
		JLabel equalLabel2 = new JLabel(" = ");
		equalLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resultPanel.add(equalLabel2);
		JLabel resultNumberLabel = new JLabel(Integer.toString(result));
		resultNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resultPanel.add(resultNumberLabel);
		
		JLabel resultRadixLabel = new JLabel("<html><br>(10)</html>");
		resultRadixLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		resultPanel.add(resultRadixLabel);
		
		Conclude conclude = new Conclude(string, radix, Integer.toString(result), 10);
		conclude.setLocation(0, 122);
		add(conclude);
		
	}
	
	
	private class PlusPanel extends JPanel {

		private static final long serialVersionUID = 1L;
		private JLabel plus;
		
		public PlusPanel(int coeff, int pow) {
			setSize(65, 32);
			setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
			setBackground(Color.WHITE);
			
			JLabel coeffLabel = new JLabel(Integer.toString(coeff) + " x " + Integer.toString(radix));
			coeffLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			add(coeffLabel);
			
			JLabel powLabel = new JLabel("<html>" + Integer.toString(pow) +"<br><br></html>");
			add(powLabel);
			
			plus = new JLabel("+ ");
			add(plus);
		}
		
		public void setPlusText() {
			this.plus.setText(null);
		}
	}
	
	private int getNumber(char sourceChar) {
		switch (sourceChar) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		default:
			return 15;
		}
	}
}
