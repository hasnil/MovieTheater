package Reservation;

import java.awt.Color; 

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ReservationGUI extends JPanel {

//public class ReservationGUI extends JFrame {
	
	private JPanel frame;
	private JTextField txtEnterVoucherId;
	
	private ArrayList<JButton> seatBtns;
	private ArrayList<Integer> seatsBeingSelected;
	
	private JButton purchaseTicketsButton;
	private JButton returnHomeButton;
	private JButton deSelectAll;
	private JLabel loginLabel;
	
	private ManageReservations manageReservations;
	

	public ReservationGUI() {
		
		ArrayList<JButton> seatBtns = new ArrayList<JButton>();
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 122, 36);
		frame.add(returnHomeButton);
		
		
		deSelectAll = new JButton("Deselect All");
		deSelectAll.setBounds(10, 200, 122, 36);
		frame.add(deSelectAll);
		
		
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
		
		int xstart = 190;
		int ystart = 160;
		
		for (int i = 1; i <= 20; i++ ) {
			JButton seatButton = new JButton("Seat " + i);
			seatButton.setBackground(Color.LIGHT_GRAY);

			int xloc = xstart + ((i-1) % 5) * 100;
			int yloc = ystart + ((i-1) / 5) * 80;
			
			
			
			seatButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent evt) {
	               int seatNumber = Integer.parseInt(seatButton.getText().split(" ")[1]);
	               seatButton.setBackground(Color.YELLOW);
	               seatsBeingSelected.add(seatNumber);
	               
	            }
	        });

			deSelectAll.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent evt) {
	            	
	            	for(int s: seatsBeingSelected) {
	            		getSeatBtn(s).setBackground(Color.LIGHT_GRAY);
	            	}
	            	
	            	seatsBeingSelected.clear();
	            	
	               
	               
	            }
	        });
			
			seatButton.setBounds(xloc, yloc, 89, 68);
			frame.add(seatButton);
			seatBtns.add(seatButton);
			
		}
		
		purchaseTicketsButton = new JButton("Purchase Tickets");
		purchaseTicketsButton.setBounds(407, 489, 170, 40);
		frame.add(purchaseTicketsButton);
		
		add(frame);
	}
	
	
	public void addConfirmedButtonListener(ActionListener e) {
			purchaseTicketsButton.addActionListener(e);
		
		
	}
	
	
	
	public JButton getSeatBtn(int seatNum) {
		return seatBtns.get(seatNum-1);
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
	
	
	public ManageReservations getManageReservations() {
		return manageReservations;
	}


	public void setManageReservations(ManageReservations manageReservations) {
		this.manageReservations = manageReservations;
	}


	public ArrayList<Integer> getSeatsBeingSelected() {
		return seatsBeingSelected;
	}


	public void setSeatsBeingSelected(ArrayList<Integer> seatsBeingSelected) {
		this.seatsBeingSelected = seatsBeingSelected;
	}
	
//	public static void main(String[] args) {
//		ReservationGUI res = new ReservationGUI();
//		res.setVisible(true);
//	}
	
}
