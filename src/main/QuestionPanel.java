package main;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class QuestionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox<Integer> comboBox1;
	private JComboBox<Integer> comboBox2;

	public QuestionPanel() {
		setLayout(new FlowLayout(FlowLayout.LEADING, 10, 0));
		setSize(900, 30);
		setBackground(Color.white);
		
		JLabel banner = new JLabel("Câu 2: ");
		banner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(banner);
		
		JLabel label1 = new JLabel("Chuyển số");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(label1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyListener() {
			
		    @Override
		    public void keyTyped(KeyEvent e) {

		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        int pos = textField.getCaretPosition();
		        textField.setText(textField.getText().toUpperCase());
		        textField.setCaretPosition(pos);
		    }
		});
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textField);
		textField.setColumns(10);
		
		JLabel label2 = new JLabel("từ");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(label2);
		
		Integer[] baseNumber = {2, 8, 10, 16};
		
		comboBox1 = new JComboBox<>(baseNumber);
		comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(comboBox1);
		
		JLabel label3 = new JLabel("sang");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(label3);
		
		comboBox2 = new JComboBox<>(baseNumber);
		comboBox2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(comboBox2);
	}
	
	public String getSourceString() {
		return textField.getText();
	}
	
	public int getSourceRadix() {
		return (int) comboBox1.getSelectedItem();
	}
	
	public int getResultRadix() {
		return (int) comboBox2.getSelectedItem();
	}

}
