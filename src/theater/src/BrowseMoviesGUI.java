

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class BrowseMoviesGUI {

	private ManageTheater manageTheater;
	
	
	private JFrame frame;
	private JTextField searchTextField;	// Search
	private JTextField movieNameField;	// Movie name
	private JComboBox<String> showtimes;// Showtimes list
	private JButton listAllButton;		// List all movies
	private JList<String> moviesList;			// List
	private JButton selectButton;
	private JButton searchButton;
	private JLabel showtimesLabel;
	private JLabel searchLabel;
	private HashMap<String,String> showtimesAndMovies;
	
	
	public BrowseMoviesGUI() {
		build();
		frame.setVisible(true);
	}
	
	
	private void build() {
		
		frame = new JFrame("Browse Movies");
		frame.setBounds(100, 140, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		/*
		for(Movie m: manageTheater.getTheaterSystem().getMoviesList()) {
			for(ShowTime s : m.getShowTimes()) {
				showtimesAndMovies.put(s.toString(), m.getMovieName());
			}
		}
		

		Set<String> showtimes = showtimesAndMovies.keySet();
		String[] showtimesArray = showtimes.toArray(new String[showtimes.size()]);
		*/
		
		String[] showtimesArray = {"Tuesday December"};

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		this.showtimes = new JComboBox<>(showtimesArray);
		this.showtimes.setSelectedIndex(0);
		
		//JPanel panel = new JPanel();
		//panel.setBounds(15, 40, 300, 50);
		//frame.getContentPane().add(panel);
		
		//panel.add(this.showtimes);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(80, 90, 506, 39);
		frame.getContentPane().add(panel1);
		
		JButton searchMoviesButton = new JButton("Search By Name");
		panel1.add(searchMoviesButton);
		
		searchTextField = new JTextField("Type Movie Name");
		searchTextField.setColumns(12);
		this.searchTextField.addMouseListener(new MouseAdapter(){
	        @Override
	        public void mouseClicked(MouseEvent e){
	        	searchTextField.setText("");
	        }
	    });
		panel1.add(this.searchTextField);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(190, 46, 320, 39);
		frame.getContentPane().add(panel2);
		
		JLabel showtimesLabel = new JLabel("Select Showtime");
		panel2.add(showtimesLabel);
		panel2.add(this.showtimes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 190, 750, 200);
		frame.getContentPane().add(scrollPane);
		
		

		JPanel panel3 = new JPanel();
		panel3.setBounds(240, 130, 320, 39);
		frame.getContentPane().add(panel3);
		listAllButton = new JButton("List All Movies");
		panel3.add(listAllButton);
	
		
		JLabel welcome = new JLabel("Welcome! Please have a look at our movies.");
		welcome.setFont(new Font("WelcomeFont", Font.ROMAN_BASELINE, 20));
		welcome.setForeground(Color.MAGENTA);
		welcome.setOpaque(true);
		
		JPanel panel4 = new JPanel();
		panel4.setBounds(185, 5, 400, 50);
		panel4.add(welcome);
		frame.getContentPane().add(panel4);

		

		
		
		moviesList = new JList<String>();
		scrollPane.setViewportView(moviesList);
		moviesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public static void main(String[] args) {
		BrowseMoviesGUI browse = new BrowseMoviesGUI();
		
	}
}
