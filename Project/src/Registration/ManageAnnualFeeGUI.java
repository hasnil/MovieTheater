package Registration;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ManageAnnualFeeGUI extends JPanel{
	

	private JPanel frame;
	private JButton returnHomeButton;
	private JLabel loginLabel;
	private ManageAnnualFeeGUI manageAnnualFeeGUI;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel dateLabel ;


	public ManageAnnualFeeGUI(){
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);

		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(366, 64, 252, 48);
		frame.add(lblNewLabel);
		
		dateLabel = new JLabel("");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateLabel.setBounds(197, 117, 589, 35);
		frame.add(dateLabel);
		
		btnNewButton = new JButton("Proceed to Make Payment");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(366, 322, 252, 62);
		frame.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Would you like to pay now?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(339, 260, 305, 35);
		frame.add(lblNewLabel_2);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 150, 48);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(779, 11, 169, 48);
		frame.add(loginLabel);
		
		add(frame);
	}
	
	public void setDateLabel(String s) {
		dateLabel.setText(s);
	}

	public void setLblNewLabel(String s) {
		lblNewLabel.setText(s);
	}

	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public ManageAnnualFeeGUI getManageAnnualFeeGUI() {
		return manageAnnualFeeGUI;
	}

	public void setManageAnnualFeeGUI (ManageAnnualFeeGUI manageAnnualFeeGUI) {
		this.manageAnnualFeeGUI = manageAnnualFeeGUI;
	}
	
	public void addMakePaymentListener(ActionListener a) {
		btnNewButton.addActionListener(a);
	}


}
