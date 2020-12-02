package Theater;

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

public class BrowseTheaterGUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManageTheater manageTheater;
	private JList<String> list;
	private JButton confirmTheaterButton;
	private JButton returnHomeButton;
	private JPanel frame;
	private JLabel loginLabel;
	
	
	public BrowseTheaterGUI(boolean userStatus) {
		frame = new JPanel();
		frame.setBounds(0, 0, 1000, 650);
		frame.setBackground(new Color(176, 196, 222));
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome! Please Select from One of Our Theater Locations.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(149, 38, 845, 80);
		frame.add(lblNewLabel);
		
		list = new JList<String>();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(222, 152, 566, 298);
		frame.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<String> theaters = new DefaultListModel<String>();
		theaters.add(0, "Central Theater (4133 Tolmie St Vancouver British Columbia)");
		list.setModel(theaters);
		
		
		confirmTheaterButton = new JButton("Confirm Theater Selection");
		confirmTheaterButton.setBounds(400, 477, 223, 50);
		frame.add(confirmTheaterButton);
		
		returnHomeButton = new JButton("Return to Home");
		returnHomeButton.setBounds(24, 11, 135, 35);
		frame.add(returnHomeButton);
		
		loginLabel = new JLabel("Login Status: Not Logged In");
		loginLabel.setBackground(new Color(255, 222, 173));
		loginLabel.setBounds(824, 11, 160, 35);
		frame.add(loginLabel);
		
		if(userStatus == true) {
			loginLabel.setText("Login Status: Logged In");
        }
		add(frame);
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
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);	
	}
}
