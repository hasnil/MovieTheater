package Payment;

import java.awt.Color;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;

public class MakeTicketPaymentGUI extends JPanel {
	
	private JPanel frame;
	private JTextField securityCodeField;
	private JTextField cardNumberField;
	private JButton returnHomeButton;
	private JButton submitPaymentButton;
	private JLabel loginLabel;
	private MakePayment makePayment;
	private JLayeredPane layeredPane;
	private double amount;

	public MakeTicketPaymentGUI(MakePayment makePayment){
		setMakePayment(makePayment);
		
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		JLabel informationLabel = new JLabel("Payment needed for your transaction:");
		informationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		informationLabel.setBounds(319, 11, 346, 72);
		frame.add(informationLabel);
		
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
		
		submitPaymentButton = new JButton("Submit Payment");
		submitPaymentButton.setBounds(409, 410, 166, 46);
		frame.add(submitPaymentButton);
		
		securityCodeField = new JTextField();
		securityCodeField.setBounds(387, 275, 209, 30);
		frame.add(securityCodeField);
		securityCodeField.setColumns(10);
		
		cardNumberField = new JTextField();
		cardNumberField.setColumns(10);
		cardNumberField.setBounds(364, 193, 245, 30);
		frame.add(cardNumberField);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 150, 43);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(804, 17, 159, 30);
		frame.add(loginLabel);
		
		add(frame);
	}

	public double getAmount() {
		return amount;
	}

	public JTextField getSecurityCodeField() {
		return securityCodeField;
	}

	public JTextField getCardNumberField() {
		return cardNumberField;
	}

	public JButton getSubmitPaymentButton() {
		return submitPaymentButton;
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

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public void setMakePayment(MakePayment makePayment) {
        this.makePayment = makePayment;
    }
	
	public MakePayment getMakePayment() {
		return makePayment;
	}

	public void setAmount(double amount) {
		this.amount = amount;
		amountLabel.setText("$" + amount + "0");
	}

	public void addSubmitButtonListener(ActionListener actionListener) {
		submitPaymentButton.addActionListener(actionListener);
	}
}
