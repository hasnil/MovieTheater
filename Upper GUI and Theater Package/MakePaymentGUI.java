package theater;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MakePaymentGUI extends JPanel {
	
	private JPanel frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton returnHomeButton;

	
	public MakePaymentGUI(){
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment needed for your transaction:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(319, 11, 346, 72);
		frame.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("$20.00");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(453, 82, 75, 44);
		frame.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Please enter your credit card number:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(354, 155, 276, 46);
		frame.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Please enter your security code:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(374, 241, 235, 44);
		frame.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Submit Payment");
		btnNewButton.setBounds(409, 410, 166, 46);
		frame.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(387, 275, 209, 30);
		frame.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(364, 193, 245, 30);
		frame.add(textField_1);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 120, 43);
		frame.add(returnHomeButton);
		
		JLabel lblNewLabel_4 = new JLabel("Login Status: Not Logged In");
		lblNewLabel_4.setBounds(804, 17, 159, 30);
		frame.add(lblNewLabel_4);
		
		add(frame);
	}
	
	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}
}
