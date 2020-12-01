package Reservation;


import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CancellationGUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel frame;
	private boolean userType;
	private JTextField reservationId;
	private JButton returnHomeButton;
	private JLabel loginLabel;
	private JButton confirmCancellation;
	private ManageReservations manageReservations;
	
	
	public CancellationGUI(boolean userType){
		this.userType = userType;

		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);

		JLabel lblNewLabel = new JLabel("Please Note: Unregistered Users will Pay a 15% Administrative Penalty!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(238, 76, 517, 60);
		frame.add(lblNewLabel);
		
		reservationId = new JTextField();
		reservationId.setBounds(325, 268, 344, 34);
		frame.add(reservationId);
		reservationId.setColumns(10);
		
		confirmCancellation = new JButton("Confirm Cancellation");
		confirmCancellation.setBounds(415, 335, 163, 34);
		frame.add(confirmCancellation);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your reservation ID here:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(381, 224, 231, 33);
		frame.add(lblNewLabel_1);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 122, 34);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(810, 14, 174, 29);
		frame.add(loginLabel);
		if(userType == true) {
			loginLabel.setText("Login Status: Logged In");
		}
		add(frame);
	}

	public JTextField getReservationId() {
		return reservationId;
	}

	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}	
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}
	
	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);	
	}

	public void addCancellationButtonListener(ActionListener actionListener) {
		confirmCancellation.addActionListener(actionListener);
	}

	public ManageReservations getManageReservations() {
		return manageReservations;
	}


	public void setManageReservations(ManageReservations manageReservations) {
		this.manageReservations = manageReservations;
	}
}
