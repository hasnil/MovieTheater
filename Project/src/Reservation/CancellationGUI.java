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

	private JPanel frame;
	private JTextField reservationIdTextField;
	private JButton returnHomeButton, confirmCancellationButton;
	private JLabel loginLabel;
	private boolean userType;
	private JButton confirmCancellation;
	//private ManageReservations manageReservations;
	
	
	public CancellationGUI(boolean userType){
		this.userType = userType;
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		buildGUI();
	}

	private void buildGUI() {
		JLabel infoLabel = new JLabel("Please Note: Unregistered Users will Pay a 15% Administrative Penalty!");
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		infoLabel.setBounds(238, 76, 517, 60);
		frame.add(infoLabel);

		reservationIdTextField = new JTextField();
		reservationIdTextField.setBounds(325, 268, 344, 34);
		frame.add(reservationIdTextField);
		reservationIdTextField.setColumns(10);

		confirmCancellationButton = new JButton("Confirm Cancellation");
		confirmCancellationButton.setBounds(415, 335, 163, 34);
		frame.add(confirmCancellationButton);

		JLabel reservationIdLabel = new JLabel("Enter your reservation ID here:");
		reservationIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reservationIdLabel.setBounds(381, 224, 231, 33);
		frame.add(reservationIdLabel);

		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 122, 34);
		frame.add(returnHomeButton);

		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(810, 14, 174, 29);
		frame.add(loginLabel);
		if(userType) {
			loginLabel.setText("Login Status: Logged In");
		}
		add(frame);
	}

	public void addButtonActionListener(JButton button, ActionListener actionListener) {
		button.addActionListener(actionListener);
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);
	}

	public JTextField getReservationIdTextField() {
		return reservationIdTextField;
	}
	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}
	public JLabel getLoginLabel() {
		return loginLabel;
	}
	public JButton getConfirmCancellationButton() {
		return confirmCancellationButton;
	}

	// public ManageReservations getManageReservations() {
	// 	return manageReservations;
	// }


	// public void setManageReservations(ManageReservations manageReservations) {
	// 	this.manageReservations = manageReservations;
	// }
}
