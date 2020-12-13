package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadixConvert {

	private JFrame frame;
	private QuestionPanel questionPanel;
	private JPanel mainPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					RadixConvert window = new RadixConvert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RadixConvert() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Base Number Convert");
		frame.setBounds(500, 0, 900, 1050);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		questionPanel = new QuestionPanel();
		questionPanel.setSize(474, 30);
		questionPanel.setLocation(48, 22);
		frame.getContentPane().add(questionPanel);
		
		mainPanel = new JPanel();
		mainPanel.setLocation(48, 60);
		mainPanel.setSize(2000, 1050);
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel);
		
		JButton covertButton = new JButton("Convert");
		covertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doSomething();
			}
		});
		covertButton.setBounds(547, 22, 83, 27);
		covertButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(covertButton);
		
	}
	
	private void doSomething() {
		boolean check = true;
		int sourceRadix = questionPanel.getSourceRadix();
		int resultRadix = questionPanel.getResultRadix();
		String sourceString = questionPanel.getSourceString();
		String resultString = "";
	
		mainPanel.removeAll();
		mainPanel.repaint();
		mainPanel.setBackground(Color.white);
		if (sourceString.equals("")) {
			new ErrorNotify("Input Missing!");
			check = false;
		} else {
			if (sourceRadix == resultRadix) {
				new ErrorNotify("Same Base Number!");
				check = false;
			} else {
				for (int index = sourceString.length() - 1; index >= 0; index--) {
					if (getNumber(sourceString.charAt(index)) >= sourceRadix) {
						new ErrorNotify("Input Unsatisfactory!");
						check = false;
						break;
					}
				}
			}
		}
		
		if (check) {
			
			int y = 0, result;
			
			if (sourceRadix != 10) {
				ConvertToDec convertToDec = new ConvertToDec(sourceString, sourceRadix);
				convertToDec.setLocation(0, 0);
				mainPanel.add(convertToDec);
				result = convertToDec.getResult();
				resultString = Integer.toString(result);
				y += 160;
			} else {
				result = Integer.parseInt(sourceString);
			}
			
			if (resultRadix != 10) {
				ConvertToOther convertToOther = new ConvertToOther(result, resultRadix);
				convertToOther.setLocation(0, y);
				resultString = convertToOther.getResult();
				mainPanel.add(convertToOther);
				y += convertToOther.getHeight();
			}
		
			Conclude conclude = new Conclude(sourceString, sourceRadix, resultString, resultRadix);
			conclude.setLocation(0, y);
			conclude.setConclude();
			mainPanel.add(conclude);
			
			mainPanel.revalidate();
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
