package Theater;


import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;


public class BrowseMoviesGUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManageTheater manageTheater;
	private JComboBox<ShowTime> showtimesComboBox;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton listAllMoviesButton;
	private JLabel welcomeLabel;
	private JLabel searchByShowtimeLabel;
	private JTextField txtEnterNameHere;
	private JLabel searchName;
	private JButton searchButton;
	private JButton confirmSelectionButton ;
	private JLabel posterLabel;
	private String[] headers;
	private JButton returnHomeButton; 
	private JPanel panel;
	private JLabel loginLabel;


	public BrowseMoviesGUI(String[][] moviesWithAccess, boolean userStatus, ShowTime[] showtimes) {
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBackground(new Color(176, 196, 222));
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Please have a look at our movies!");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		welcomeLabel.setBounds(71, 48, 411, 48);
		panel.add(welcomeLabel);
		
		listAllMoviesButton = new JButton("List All Movies");
		listAllMoviesButton.setBounds(133, 111, 138, 35);
		panel.add(listAllMoviesButton);
		
		showtimesComboBox = new JComboBox<ShowTime>(showtimes);
		showtimesComboBox.setBounds(103, 192, 213, 22);
		panel.add(showtimesComboBox);
		
		searchByShowtimeLabel = new JLabel("Search by Showtime:");
		searchByShowtimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchByShowtimeLabel.setBounds(133, 157, 133, 35);
		panel.add(searchByShowtimeLabel);
		
		txtEnterNameHere = new JTextField();
		txtEnterNameHere.setText("Enter Name Here");
		txtEnterNameHere.setBounds(202, 269, 114, 20);
		panel.add(txtEnterNameHere);
		txtEnterNameHere.setColumns(10);	
		txtEnterNameHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterNameHere.setText("");
			}
		});
		
		searchName = new JLabel("Search by Movie Name:");
		searchName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchName.setBounds(133, 215, 172, 59);
		panel.add(searchName);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(103, 268, 89, 23);
		panel.add(searchButton);
		
		confirmSelectionButton = new JButton("Confirm Selection");
		confirmSelectionButton.setBackground(new Color(255, 218, 185));
		confirmSelectionButton.setBounds(133, 302, 138, 22);
		panel.add(confirmSelectionButton);
		
		posterLabel = new JLabel();
		posterLabel.setBounds(102, 335, 226, 265);
		panel.add(posterLabel);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(457, 11, 492, 589);
		panel.add(scrollPane);
        
        returnHomeButton = new JButton("Return to Home");
        returnHomeButton.setBounds(10, 8, 135, 35);
        panel.add(returnHomeButton);
        
        loginLabel = new JLabel("Login Status: Not Logged In");
        loginLabel.setBackground(new Color(255, 222, 173));
        loginLabel.setBounds(298, 8, 160, 35);
        panel.add(loginLabel);
        
        if(userStatus == true) {
        	loginLabel.setText("Login Status: Logged In");
        }
        
        headers = new String[] {"Movie Name", "Early Access"};
		
    	setUpTable(moviesWithAccess);
    	
    	add(panel);
	}

	
	
	public void addConfirmMovieButtonListener (ActionListener listenForConfirmMovieButton) {
		confirmSelectionButton.addActionListener(listenForConfirmMovieButton);
	}
	
	public void addSearchButtonListener (ActionListener listenForSearchButton) {
		searchButton.addActionListener(listenForSearchButton);
	}
	
	public void addListAllButtonListener(ActionListener listenForListAllButton) {
		listAllMoviesButton.addActionListener(listenForListAllButton);
	}
	
	public void addMovieRowListener(MouseAdapter listenForClick) {
		table.addMouseListener(listenForClick);
	}
	
	public void addReturnListener(ActionListener returnHome) {
		returnHomeButton.addActionListener(returnHome);
	}
	
	public JComboBox<ShowTime> getShowtimesComboBox() {
		return showtimesComboBox;
	}

	public JButton getListAllMoviesButton() {
		return listAllMoviesButton;
	}

	public JButton getSearchButton() {
		return searchButton;
	}
	
	public String getSearchString() {
		return txtEnterNameHere.getText();
	}

	public JButton getConfirmSelectionButton() {
		return confirmSelectionButton;
	}

	public void addComboBoxListener(ActionListener listenForComboBox) {
		showtimesComboBox.addActionListener(listenForComboBox);
	}
	
	
	public String getMovieNameSelection() {
		int selectedRow = table.getSelectedRow();
		String movieName = (String) table.getValueAt(selectedRow, 0);
		return movieName;
	}
	
	
	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}
	

	public JButton getReturnHomeButton() {
		return returnHomeButton;
	}

	public void setUpTable(String [][] moviesWithAccess) {
		table = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
		};
        table.setRowHeight(30);
        table.setModel(new DefaultTableModel(moviesWithAccess, headers));
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        
        scrollPane.setViewportView(table);
        table.setFocusable(false);
        
	}
	
	public void setPosterLabel(ImageIcon poster) {
		posterLabel.setIcon(poster);
	}
	
	
	public ManageTheater getManageTheater() {
		return manageTheater;
	}

	public void setManageTheater(ManageTheater manageTheater) {
		this.manageTheater = manageTheater;
	}

	public JTable getTable() {
		return table;
	}
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public void displayMessage(String string) {
		JOptionPane pane = new JOptionPane();
		JOptionPane.showMessageDialog(pane, string);	
	}
}

	