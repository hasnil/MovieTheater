package Reservation;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PurchaseTicketsGUI extends JPanel{
	
	private JPanel frame;
	private JTextField txtEnterVoucherId;
	private JButton returnHomeButton;
	private JButton makePaymentButton;
	private JLabel loginLabel;
	private JLabel summary;
	private JLabel summary2; 
	private JButton applyVoucherButton;
	private ManageReservations manageReservations;

	public PurchaseTicketsGUI() {
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		summary = new JLabel("Total Price:");
		summary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		summary.setBounds(281, 98, 466, 45);
		frame.add(summary);
		
		summary2 = new JLabel("Number of Tickets: ");
		summary2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		summary2.setBounds(281, 162, 399, 45);
		frame.add(summary2);
		
		applyVoucherButton = new JButton("Apply Voucher");
		applyVoucherButton.setBounds(418, 338, 158, 45);
		frame.add(applyVoucherButton);
		
		txtEnterVoucherId = new JTextField();
		txtEnterVoucherId.setText("Enter Voucher ID here");
		txtEnterVoucherId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterVoucherId.setBounds(366, 309, 262, 23);
		frame.add(txtEnterVoucherId);
		txtEnterVoucherId.setColumns(10);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(786, 25, 198, 23);
		frame.add(loginLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Summary");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(439, 36, 116, 51);
		frame.add(lblNewLabel_3);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(20, 25, 150, 36);
		frame.add(returnHomeButton);
		
		makePaymentButton = new JButton("Proceed to Make Payment");
		makePaymentButton.setBounds(386, 434, 219, 45);
		frame.add(makePaymentButton);
		
		JLabel lblNewLabel_4 = new JLabel("Do you have any vouchers to use?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(351, 271, 292, 27);
		frame.add(lblNewLabel_4);

		add(frame);
	}
	
	
	public JLabel getSummary() {
		return summary;
	}


	public void setSummary(String s) {
		summary.setText(s);
	}


	public JLabel getSummary2() {
		return summary2;
	}


	public void setSummary2(String s) {
		summary2.setText(s);
	}


	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}
	

	public JButton getMakePaymentButton() {
		return makePaymentButton;
	}

	public JLabel getLoginLabel() {
		return loginLabel;
	}


	public JButton getApplyVoucherButton() {
		return applyVoucherButton;
	}


	public void setApplyVoucherButton(JButton applyVoucherButton) {
		this.applyVoucherButton = applyVoucherButton;
	}
}
