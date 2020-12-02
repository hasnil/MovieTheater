package theater;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class BrowseTheaterGUI extends JFrame{
	
	private ManageTheater manageTheater;
	private JList<String> list;
	private JButton confirmTheaterButton;
	private JButton returnHomeButton;
	private JLabel lblNewLabel_1;
	
	
	public BrowseTheaterGUI(boolean userStatus) {
		getContentPane().setBackground(new Color(176, 196, 222));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome! Please Select from One of Our Theater Locations.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(149, 38, 845, 80);
		getContentPane().add(lblNewLabel);
		
		list = new JList<String>();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(222, 152, 566, 298);
		getContentPane().add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<String> theaters = new DefaultListModel<String>();
		theaters.add(0, "Central Theater (4133 Tolmie St Vancouver British Columbia)");
		list.setModel(theaters);
		
		
		confirmTheaterButton = new JButton("Confirm Theater Selection");
		confirmTheaterButton.setBounds(400, 477, 223, 50);
		getContentPane().add(confirmTheaterButton);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(24, 11, 135, 35);
		getContentPane().add(returnHomeButton);
		
		lblNewLabel_1 = new JLabel("Login Status: Not Logged In");
		lblNewLabel_1.setBackground(new Color(255, 222, 173));
		lblNewLabel_1.setBounds(824, 11, 160, 35);
		getContentPane().add(lblNewLabel_1);
		
		if(userStatus == true) {
			lblNewLabel_1.setText("Login Status: Logged In");
        }
		
		initializeFrame();
	}
	
	
	private void initializeFrame() {
		this.setTitle("Browse Theaters");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 140, 1000, 650);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void addConfirmTheaterButtonListener (ActionListener listenForConfirmTheaterButton) {
		confirmTheaterButton.addActionListener(listenForConfirmTheaterButton);
	}
	
	
	public void addReturnListener(ActionListener returnHome) {
		returnHomeButton.addActionListener(returnHome);
	}
	
	
	public String getTheaterNameSelection() {
		return list.getSelectedValue();
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);	
	}
}
