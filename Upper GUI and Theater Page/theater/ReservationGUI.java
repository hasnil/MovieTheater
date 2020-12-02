package theater;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReservationGUI extends JPanel{

	private JPanel frame;
	private JTextField txtEnterVoucherId;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn10;
	private JButton btn11;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JButton btn15;
	private JButton btn16;
	private JButton btn17;
	private JButton btn18;
	private JButton btn19;
	private JButton btn20;
	private JButton purchaseTicketsButton;
	private JButton returnHomeButton;
	private JLabel loginLabel;
	
	

	public ReservationGUI() {
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 122, 36);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBounds(786, 17, 188, 25);
		frame.add(loginLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please select your desired seats:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(363, 11, 260, 68);
		frame.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Movie Screen");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(32, 90, 905, 25);
		lblNewLabel_2.setOpaque(true);
		frame.add(lblNewLabel_2);
		
		btn1 = new JButton("Seat 1");
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(191, 161, 89, 68);
		frame.add(btn1);
		
		btn2 = new JButton("Seat 2");
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.setBounds(288, 161, 89, 68);
		frame.add(btn2);
		
		btn3 = new JButton("Seat 3");
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.setBounds(387, 161, 89, 68);
		frame.add(btn3);
		
		btn4 = new JButton("Seat 4");
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.setBounds(485, 161, 89, 68);
		frame.add(btn4);
		
		btn5 = new JButton("Seat 5");
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.setBounds(584, 161, 89, 68);
		frame.add(btn5);
		
		btn6 = new JButton("Seat 6");
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.setBounds(683, 161, 89, 68);
		frame.add(btn6);
		
		btn7 = new JButton("Seat 7");
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.setBounds(145, 240, 89, 68);
		frame.add(btn7);
		
		btn8 = new JButton("Seat 8");
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.setBounds(244, 240, 89, 68);
		frame.add(btn8);
		
		btn9 = new JButton("Seat 9");
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.setBounds(343, 240, 89, 68);
		frame.add(btn9);
		
		btn10 = new JButton("Seat 10");
		btn10.setBackground(Color.LIGHT_GRAY);
		btn10.setBounds(442, 240, 89, 68);
		frame.add(btn10);
		
		btn11 = new JButton("Seat 11");
		btn11.setBackground(Color.LIGHT_GRAY);
		btn11.setBounds(541, 240, 89, 68);
		frame.add(btn11);
		
		btn12 = new JButton("Seat 12");
		btn12.setBackground(Color.LIGHT_GRAY);
		btn12.setBounds(640, 240, 89, 68);
		frame.add(btn12);
		
		btn13 = new JButton("Seat 13");
		btn13.setBackground(Color.LIGHT_GRAY);
		btn13.setBounds(739, 240, 89, 68);
		frame.add(btn13);
		
		btn14 = new JButton("Seat 14");
		btn14.setBackground(Color.LIGHT_GRAY);
		btn14.setBounds(145, 319, 89, 68);
		frame.add(btn14);
		
		btn15 = new JButton("Seat 15");
		btn15.setBackground(Color.LIGHT_GRAY);
		btn15.setBounds(244, 319, 89, 68);
		frame.add(btn15);
		
		btn16 = new JButton("Seat 16");
		btn16.setBackground(Color.LIGHT_GRAY);
		btn16.setBounds(343, 319, 89, 68);
		frame.add(btn16);
		
		btn17 = new JButton("Seat 17");
		btn17.setBackground(Color.LIGHT_GRAY);
		btn17.setBounds(442, 319, 89, 68);
		frame.add(btn17);
		
		btn18 = new JButton("Seat 18");
		btn18.setBackground(Color.LIGHT_GRAY);
		btn18.setBounds(541, 319, 89, 68);
		frame.add(btn18);
		
		btn19 = new JButton("Seat 19");
		btn19.setBackground(Color.LIGHT_GRAY);
		btn19.setBounds(640, 319, 89, 68);
		frame.add(btn19);
		
		btn20 = new JButton("Seat 20");
		btn20.setBackground(Color.LIGHT_GRAY);
		btn20.setBounds(739, 319, 89, 68);
		frame.add(btn20);

		
		purchaseTicketsButton = new JButton("Purchase Tickets");
		purchaseTicketsButton.setBounds(407, 489, 170, 40);
		frame.add(purchaseTicketsButton);
		
		add(frame);
	}
	
	

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	public JButton getBtn6() {
		return btn6;
	}

	public void setBtn6(JButton btn6) {
		this.btn6 = btn6;
	}

	public JButton getBtn7() {
		return btn7;
	}

	public void setBtn7(JButton btn7) {
		this.btn7 = btn7;
	}

	public JButton getBtn8() {
		return btn8;
	}

	public void setBtn8(JButton btn8) {
		this.btn8 = btn8;
	}

	public JButton getBtn9() {
		return btn9;
	}

	public void setBtn9(JButton btn9) {
		this.btn9 = btn9;
	}

	public JButton getBtn10() {
		return btn10;
	}

	public void setBtn10(JButton btn10) {
		this.btn10 = btn10;
	}

	public JButton getBtn11() {
		return btn11;
	}

	public void setBtn11(JButton btn11) {
		this.btn11 = btn11;
	}

	public JButton getBtn12() {
		return btn12;
	}

	public void setBtn12(JButton btn12) {
		this.btn12 = btn12;
	}

	public JButton getBtn13() {
		return btn13;
	}

	public void setBtn13(JButton btn13) {
		this.btn13 = btn13;
	}

	public JButton getBtn14() {
		return btn14;
	}

	public void setBtn14(JButton btn14) {
		this.btn14 = btn14;
	}

	public JButton getBtn15() {
		return btn15;
	}

	public void setBtn15(JButton btn15) {
		this.btn15 = btn15;
	}

	public JButton getBtn16() {
		return btn16;
	}

	public void setBtn16(JButton btn16) {
		this.btn16 = btn16;
	}

	public JButton getBtn17() {
		return btn17;
	}

	public void setBtn17(JButton btn17) {
		this.btn17 = btn17;
	}

	public JButton getBtn18() {
		return btn18;
	}

	public void setBtn18(JButton btn18) {
		this.btn18 = btn18;
	}

	public JButton getBtn19() {
		return btn19;
	}

	public void setBtn19(JButton btn19) {
		this.btn19 = btn19;
	}

	public JButton getBtn20() {
		return btn20;
	}

	public void setBtn20(JButton btn20) {
		this.btn20 = btn20;
	}

	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}


	public JButton getPurchaseTicketsButton() {
		return purchaseTicketsButton;
	}
	
}
