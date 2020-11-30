package Payment;

import java.awt.Color;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;

public class MakePaymentGUI extends JPanel {
	
	private JPanel frame;
	private JTextField securityCodeField;
	private JTextField cardNumberField;
	private JButton returnHomeButton;
	private JButton submitPaymentButton;
	private JLabel loginLabel;
	private MakePayment makePayment;
	private JLayeredPane layeredPane;
	private double amount;

	public MakePaymentGUI(MakePayment makePayment){
		setMakePayment(makePayment);
		
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
		
		submitPaymentButton = new JButton("Submit Payment");
		submitPaymentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				payWithCreditCard();
			}
		});
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

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean makePayment(double amount) {
//        int option = 0;
//        System.out.println("Select 1 to pay with credit card or 2 te pay with a voucher");
//        try {
////            option = Integer.parseInt(reader.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (option == 1) {
//            return payWithCreditCard(amount);
//        }
//        else if (option == 2) {
//            return payWithVoucher(amount);
//        }
//        else
//            System.out.println("ERROR");
    return false;
    }

    public boolean payWithCreditCard() {
        String cc = cardNumberField.getText();
        String cvv = securityCodeField.getText();
        boolean payment = makePayment.payWithCreditCard(cc, cvv, amount);
        if (payment) {
			displayMessage("Payment successful, receipt sent to your email");
			return true;
        }
        else {
        	displayMessage("Payment unsuccessful");
        	return false;
		}
    }



	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);
	}

    private boolean payWithVoucher(double amount) {
        int vouchNum = 0;
//        try {
//            System.out.println("Enter your voucher number");
////            vouchNum = Integer.parseInt(reader.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        double remainder = makePayment.payWithVoucher(vouchNum, amount);
//        if (remainder == 0)
//            return true;
//        else if (remainder == -1)
//            return false;
//        else
//            return payWithCreditCard(remainder);
		return false;
    }

    public void showMakePaymentGUI() {
		layeredPane.moveToFront(this);
		this.setVisible(true);
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public void setMakePayment(MakePayment makePayment) {
        this.makePayment = makePayment;
    }

}
