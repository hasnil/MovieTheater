package theater;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ManageAnnualFeeGUI extends JPanel{
	

	private JPanel frame;
	private JButton returnHomeButton;


	public ManageAnnualFeeGUI(){
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Your Annual $20 Fee is Due By:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(366, 64, 252, 48);
		frame.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N/A (Fee already paid)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(197, 117, 589, 35);
		frame.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Proceed to Make Payment");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(366, 322, 252, 62);
		frame.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Would you like to pay now?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(339, 260, 305, 35);
		frame.add(lblNewLabel_2);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 108, 48);
		frame.add(returnHomeButton);
		
		JLabel lblNewLabel_3 = new JLabel("Login Status: Not Logged In");
		lblNewLabel_3.setBounds(779, 11, 169, 48);
		frame.add(lblNewLabel_3);
		
		add(frame);
	}
	
	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}



}
