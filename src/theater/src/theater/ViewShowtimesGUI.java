package theater;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class ViewShowtimesGUI extends JFrame{
	
	private ManageTheater manageTheater;
	private JList<ShowTime> showtimesList;
	private JList<String> showtimesAndMovieList;
	private JButton confirmShowtimeButton;
	private JButton viewAllShowtimesButton;
	private JButton viewSelectedShowtimesButton;
	private JLabel infoLabel;
	private JButton returnHomeButton;
	private JLabel lblNewLabel_1;
	
	
	public ViewShowtimesGUI(boolean userStatus) {
		
		getContentPane().setBackground(new Color(176, 196, 222));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Here are our current showtimes!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(297, 11, 399, 80);
		getContentPane().add(lblNewLabel);
		
		showtimesList = new JList<ShowTime>();
		showtimesList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		showtimesList.setBounds(214, 121, 566, 298);
		getContentPane().add(showtimesList);
		showtimesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		showtimesAndMovieList = new JList<String>();
		showtimesAndMovieList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		showtimesAndMovieList.setBounds(214, 121, 566, 298);
		getContentPane().add(showtimesAndMovieList);

		
		confirmShowtimeButton = new JButton("Confirm Movie Showtime Selection");
		confirmShowtimeButton.setBounds(528, 441, 252, 50);
		getContentPane().add(confirmShowtimeButton);
		
		viewAllShowtimesButton = new JButton("View All Showtimes");
		viewAllShowtimesButton.setBounds(418, 525, 160, 44);
		getContentPane().add(viewAllShowtimesButton);
		
		infoLabel = new JLabel("", SwingConstants.CENTER);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		infoLabel.setBounds(357, 88, 289, 22);
		getContentPane().add(infoLabel);
		
		viewSelectedShowtimesButton = new JButton("View Your Selected Movie's Showtimes");
		viewSelectedShowtimesButton.setBounds(214, 441, 304, 50);
		getContentPane().add(viewSelectedShowtimesButton);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 135, 35);
		getContentPane().add(returnHomeButton);
		
		lblNewLabel_1 = new JLabel("Login Status: Not Logged In");
		lblNewLabel_1.setBackground(new Color(255, 222, 173));
		lblNewLabel_1.setBounds(810, 11, 160, 35);
		getContentPane().add(lblNewLabel_1);
		
		if(userStatus == true) {
			lblNewLabel_1.setText("Login Status: Logged In");
        }
		
		initializeFrame();
	}
	
	
	private void initializeFrame() {
		this.setTitle("View Showtimes");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 140, 1000, 650);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	public void setShowtimesList(DefaultListModel<ShowTime> listModel) {
		showtimesList.removeAll();
		showtimesAndMovieList.setVisible(false);
		showtimesList.setVisible(true);
		 
		showtimesList.setModel(listModel);
	}
	
	
	public void setShowtimesAndMoviesList(DefaultListModel<String> listModel) {
		showtimesAndMovieList.removeAll();
		showtimesList.setVisible(false);
		showtimesAndMovieList.setVisible(true);
		 
		showtimesAndMovieList.setModel(listModel);
	}
	
	public JButton getConfirmShowtimeButton() {
		return confirmShowtimeButton;
	}


	public JButton getViewSelectedShowtimesButton() {
		return viewSelectedShowtimesButton;
	}
	
	public JButton getViewAllShowtimesButton() {
		return viewAllShowtimesButton;
	}
	

	public void addConfirmShowtimeButtonListener (ActionListener listenForConfirmShowtimeButton) {
		confirmShowtimeButton.addActionListener(listenForConfirmShowtimeButton);
	}
	
	public void addAllShowtimesButtonListener (ActionListener listenForAllShowtimesButton) {
		viewAllShowtimesButton.addActionListener(listenForAllShowtimesButton);
	}
	
	public void addSelectedShowtimesButtonListener (ActionListener listenForSelectedShowtimesButton) {
		viewSelectedShowtimesButton.addActionListener(listenForSelectedShowtimesButton);
	}
	
	
	public void addReturnListener(ActionListener returnHome) {
		returnHomeButton.addActionListener(returnHome);
	}
	
	
	
	public ManageTheater getManageTheater() {
		return manageTheater;
	}


	public void setManageTheater(ManageTheater manageTheater) {
		this.manageTheater = manageTheater;
	}
	
	public ShowTime getShowtimesListSelection() {
		return showtimesList.getSelectedValue();
	}
	

	public void setInfoLabelText(String message) {
		infoLabel.setText(message);
	}


	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);	
	}

}
