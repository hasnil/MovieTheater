package Reservation;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;

public class PurchaseTicketsGUI extends JPanel{
	
	private JPanel frame;
	private JTextField enterVoucherTextField;
	private JButton returnHomeButton, makePaymentButton, applyVoucherButton;
	private JLabel loginLabel, totalPriceLabel, numOfTicketsLabel;

	public PurchaseTicketsGUI() {
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		buildGUI();
	}

	public void addButtonActionListener(JButton button, ActionListener actionListener) {
		button.addActionListener(actionListener);
	}

	private void buildGUI() {
		totalPriceLabel = new JLabel("Total Price:");
		totalPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalPriceLabel.setBounds(281, 98, 466, 45);
		frame.add(totalPriceLabel);

		numOfTicketsLabel = new JLabel("Number of Tickets: ");
		numOfTicketsLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numOfTicketsLabel.setBounds(281, 162, 399, 45);
		frame.add(numOfTicketsLabel);

		applyVoucherButton = new JButton("Apply Voucher");
		applyVoucherButton.setBounds(418, 338, 158, 45);
		frame.add(applyVoucherButton);

		enterVoucherTextField = new JTextField();
		enterVoucherTextField.setText("Enter Voucher ID here");
		enterVoucherTextField.setHorizontalAlignment(SwingConstants.CENTER);
		enterVoucherTextField.setBounds(366, 309, 262, 23);
		frame.add(enterVoucherTextField);
		enterVoucherTextField.setColumns(10);

		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(786, 25, 198, 23);
		frame.add(loginLabel);

		JLabel summaryLabel = new JLabel("Summary");
		summaryLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		summaryLabel.setBounds(439, 36, 116, 51);
		frame.add(summaryLabel);

		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(20, 25, 150, 36);
		frame.add(returnHomeButton);

		makePaymentButton = new JButton("Proceed to Make Payment");
		makePaymentButton.setBounds(386, 434, 219, 45);
		frame.add(makePaymentButton);

		JLabel vouchersLabel = new JLabel("Do you have any vouchers to use?");
		vouchersLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vouchersLabel.setBounds(351, 271, 292, 27);
		frame.add(vouchersLabel);

		add(frame);
	}

	public void setTotalPriceLabel(String s) {
		totalPriceLabel.setText(s);
	}
	public JLabel getTotalPriceLabel() { return totalPriceLabel; }
	public void setNumOfTicketsLabel(String s) {
		numOfTicketsLabel.setText(s);
	}
	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}
	public JButton getMakePaymentButton() { return makePaymentButton; }
	public JLabel getLoginLabel() {
		return loginLabel;
	}
	public JButton getApplyVoucherButton() {
		return applyVoucherButton;
	}
	public JTextField getEnterVoucherTextField() { return enterVoucherTextField; }
}
