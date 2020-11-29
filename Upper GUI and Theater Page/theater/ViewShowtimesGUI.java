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
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class ViewShowtimesGUI extends JPanel{
	
	private JPanel frame;
	private ManageTheater manageTheater;
	private JList<ShowTime> showtimesList;
	private JList<String> showtimesAndMovieList;
	private JButton confirmShowtimeButton;
	private JButton viewAllShowtimesButton;
	private JButton viewSelectedShowtimesButton;
	private JLabel infoLabel;
	private JButton returnHomeButton;
	private JLabel loginLabel;
	

	public ViewShowtimesGUI(boolean userStatus) {
		
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Here are our current showtimes!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(297, 11, 399, 80);
		frame.add(lblNewLabel);
		
		showtimesList = new JList<ShowTime>();
		showtimesList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		showtimesList.setBounds(214, 121, 566, 298);
		frame.add(showtimesList);
		showtimesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		showtimesAndMovieList = new JList<String>();
		showtimesAndMovieList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		showtimesAndMovieList.setBounds(214, 121, 566, 298);
		frame.add(showtimesAndMovieList);

		
		confirmShowtimeButton = new JButton("Confirm Movie Showtime Selection");
		confirmShowtimeButton.setBounds(528, 441, 252, 50);
		frame.add(confirmShowtimeButton);
		
		viewAllShowtimesButton = new JButton("View All Showtimes");
		viewAllShowtimesButton.setBounds(418, 525, 160, 44);
		frame.add(viewAllShowtimesButton);
		
		infoLabel = new JLabel("", SwingConstants.CENTER);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		infoLabel.setBounds(214, 88, 566, 22);
		frame.add(infoLabel);
		
		viewSelectedShowtimesButton = new JButton("View Your Selected Movie's Showtimes");
		viewSelectedShowtimesButton.setBounds(214, 441, 304, 50);
		frame.add(viewSelectedShowtimesButton);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(10, 11, 135, 35);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBackground(new Color(255, 222, 173));
		loginLabel.setBounds(810, 11, 160, 35);
		frame.add(loginLabel);
		
		if(userStatus == true) {
			loginLabel.setText("Login Status: Logged In");
        }
		
		add(frame);
	}
	
	
	public JLabel getInfoLabel() {
		return infoLabel;
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

}
