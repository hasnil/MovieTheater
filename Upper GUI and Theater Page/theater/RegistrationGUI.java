package theater;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegistrationGUI extends JPanel{
	
	private JPanel frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton returnHomeButton;
	private JLabel loginLabel;
	


	public RegistrationGUI() {
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(356, 88, 271, 44);
		frame.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(402, 162, 180, 38);
		frame.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Please enter your information to register. Note that there is a $20 annual fee.");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(161, 21, 662, 67);
		frame.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Submit Registration");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(383, 493, 217, 44);
		frame.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(367, 124, 249, 27);
		frame.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(367, 199, 249, 27);
		frame.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(402, 245, 180, 38);
		frame.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(367, 282, 249, 27);
		frame.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(367, 357, 249, 27);
		frame.add(textField_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(402, 320, 180, 38);
		frame.add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(367, 432, 249, 27);
		frame.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("First Name");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(402, 395, 180, 38);
		frame.add(lblNewLabel_1_1_1_1);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 21, 140, 44);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(818, 21, 166, 44);
		frame.add(loginLabel);
		
		add(frame);
	}
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}

	
	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}
	
}

	
	
