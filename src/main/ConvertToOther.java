package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

public class ConvertToOther extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int radix;
	private int sourceNumber;
	private String resultString = "";
	
	public ConvertToOther(int sourceNumber, int radix) {
		this.sourceNumber = sourceNumber;
		this.radix = radix;
		doSomething();
	}
	
	public void doSomething() {
		
		setLayout(null);
		setBackground(Color.white);
	
		JLabel banner = new JLabel("Chuyển từ 10 sang " + Integer.toString(radix) + ": ");
		banner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		banner.setBounds(0, 0, 330, 19);
		add(banner);
		
		final Integer width = 40;
		final Integer height = 32;
		
		Integer x = 0;
		Integer y = 32;
		Integer count = 0;
		Integer surplus;
		Integer number = sourceNumber;
		
		List<BasePanel> basePanel = new ArrayList<>();
		
		while (number != 0) {
			surplus = number % radix;
			resultString = getChar(surplus) + resultString;
			basePanel.add(new BasePanel(number, surplus));
			number = number / radix;
			Integer space = number;
			while (space > 0) {
				x += 4;
				space = space / 10;
			}
			
			basePanel.get(count).setLocation(x, y);
			
			x += width;
			y += height;
			count += 1;
		}
		
		basePanel.get(count - 1).setLast();
		
		for (int index = count - 1; index >= 0; index--) {
			add(basePanel.get(index));
		}
		
		Conclude conclude = new Conclude(Integer.toString(sourceNumber), 10, resultString, radix);
		conclude.setLocation(0, y + 40);
		add(conclude);
		
		setSize(2000, y + 80);
	}
	
	public String getResult() {
		return this.resultString;
	}
	
	
	private class BasePanel extends JPanel {

		private static final long serialVersionUID = 1L;
		
		JLabel quotientLabel;
		
		public BasePanel(int divisor, int surplus) {
			
			setSize(200, 60);
			setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
			setBackground(Color.white);
			
			JPanel leftPanel = new JPanel();
			add(leftPanel);
			leftPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
			leftPanel.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel divisorPanel = new JPanel();
			leftPanel.add(divisorPanel);
			divisorPanel.setBackground(Color.white);
			
			JLabel divisorLabel = new JLabel((divisor >= 100)? Integer.toString(divisor) : (Integer.toString(divisor) + "  "));
			divisorLabel.setHorizontalAlignment(SwingConstants.LEFT);
			divisorLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			divisorPanel.add(divisorLabel);
			
			JPanel surplusPanel = new JPanel();
			leftPanel.add(surplusPanel);
			surplusPanel.setBackground(Color.white);
			
			JLabel surplusLabel = new JLabel(Integer.toString(surplus));
			surplusLabel.setHorizontalAlignment(SwingConstants.CENTER);
			surplusLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			surplusPanel.add(surplusLabel);
			
			JPanel rightPanel = new JPanel();
			rightPanel.setBackground(Color.white);
			add(rightPanel);
			rightPanel.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel radixPanel = new JPanel();
			radixPanel.setBackground(Color.white);
			radixPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			rightPanel.add(radixPanel);
			
			JLabel radixLabel = new JLabel(Integer.toString(radix));
			radixLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			radixLabel.setHorizontalAlignment(SwingConstants.CENTER);
			radixPanel.add(radixLabel);
			
			JPanel quotientPanel = new JPanel();
			quotientPanel.setBackground(Color.white);
			rightPanel.add(quotientPanel);
			
			quotientLabel = new JLabel("     ");
			quotientLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			quotientLabel.setHorizontalAlignment(SwingConstants.CENTER);
			quotientPanel.add(quotientLabel);
			
			revalidate();
			repaint();
		}
		
		public void setLast() {
			quotientLabel.setText("  0  ");
		}
	}
	
	private char getChar(int surplus) {
		switch (surplus) {
		case 0:
			return '0';
		case 1:
			return '1';
		case 2:
			return '2';
		case 3:
			return '3';
		case 4:
			return '4';
		case 5:
			return '5';
		case 6:
			return '6';
		case 7:
			return '7';
		case 8:
			return '8';
		case 9:
			return '9';
		case 10:
			return 'A';
		case 11:
			return 'B';
		case 12:
			return 'C';
		case 13:
			return 'D';
		case 14:
			return 'E';
		default:
			return 'F';
		}
	}
}
