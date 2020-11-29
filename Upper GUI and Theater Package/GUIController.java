package theater;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;


public class GUIController {
	
	private MainGUI mainGUI;
	private ViewShowtimesGUI viewShowtimes;
	private BrowseMoviesGUI browseMovies;
	private BrowseTheaterGUI browseTheater;
	private CancellationGUI cancellation;
	private ReservationGUI reservation;
	private PurchaseTicketsGUI purchaseTicketsGUI;
	private MakePaymentGUI makePaymentGUI;
	private ManageAnnualFeeGUI manageAnnualFee;
	private RegistrationGUI registratonGUI;
	private LoginGUI loginGUI;
	private JLayeredPane layeredPane;
	
	
	public GUIController(MainGUI mainGUI, ViewShowtimesGUI viewShowtimes, BrowseMoviesGUI browseMovies,
			BrowseTheaterGUI browseTheater, CancellationGUI cancellation, ReservationGUI reservation,
			PurchaseTicketsGUI purchaseTicketsGUI, MakePaymentGUI makePaymentGUI, 
			ManageAnnualFeeGUI manageAnnualFee, RegistrationGUI registrationGUI, LoginGUI loginGUI) {
		
		this.mainGUI = mainGUI;
		this.viewShowtimes = viewShowtimes;
		this.browseMovies = browseMovies;
		this.browseTheater = browseTheater;
		this.cancellation = cancellation;
		this.reservation = reservation;
		this.purchaseTicketsGUI = purchaseTicketsGUI;	
		this.makePaymentGUI = makePaymentGUI;
		this.manageAnnualFee = manageAnnualFee;
		this.registratonGUI = registrationGUI;
		this.loginGUI = loginGUI;
		
		
		JFrame frame = new JFrame("Movie Theater Application");
		frame.setBounds(100, 140, 1000, 650);
		
		layeredPane = new JLayeredPane();
		layeredPane.add(mainGUI, 0);
		mainGUI.setBounds(0, 0, 1000, 650);
		layeredPane.add(cancellation, 1);
		cancellation.setBounds(0, 0, 1000, 650);
		layeredPane.add(browseMovies, 2);
		browseMovies.setBounds(0, 0, 1000, 650);
		layeredPane.add(browseTheater, 3);
		browseTheater.setBounds(0, 0, 1000, 650);
		layeredPane.add(loginGUI, 4);
		loginGUI.setBounds(0, 0, 1000, 650);
		layeredPane.add(makePaymentGUI, 5);
		makePaymentGUI.setBounds(0, 0, 1000, 650);
		layeredPane.add(manageAnnualFee, 6);
		manageAnnualFee.setBounds(0, 0, 1000, 650);
		layeredPane.add(purchaseTicketsGUI, 7);
		purchaseTicketsGUI.setBounds(0, 0, 1000, 650);
		layeredPane.add(registrationGUI, 8);
		registrationGUI.setBounds(0, 0, 1000, 650);
		layeredPane.add(reservation, 9);
		reservation.setBounds(0, 0, 1000, 650);
		layeredPane.add(viewShowtimes, 10);
		viewShowtimes.setBounds(0, 0, 1000, 650);
		layeredPane.setVisible(true);
		

		frame.setContentPane(layeredPane);		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		layeredPane.moveToFront(mainGUI);
		mainGUI.setVisible(true);
		
		
		browseMovies.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		browseTheater.addReturnListener(new ReturnHomeListener());
		cancellation.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		loginGUI.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		makePaymentGUI.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		manageAnnualFee.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		purchaseTicketsGUI.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		registrationGUI.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		reservation.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		viewShowtimes.getReturnHomeButton().addActionListener(new ReturnHomeListener());
		
		
		mainGUI.getBrowseTheaterButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		        mainGUI.setVisible(false);
		        layeredPane.moveToFront(browseTheater);
		        browseTheater.setVisible(true);
		    }
		});
		
		mainGUI.getCancelReservationButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	mainGUI.setVisible(false);
		        layeredPane.moveToFront(cancellation);
		        cancellation.setVisible(true);
		    }
		});
		
		mainGUI.getBrowseMoviesButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	mainGUI.setVisible(false);
		        layeredPane.moveToFront(browseMovies);
		        browseMovies.setVisible(true);
		    }
		});
		
		mainGUI.getManageAnnualFeeButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	mainGUI.setVisible(false);
		        layeredPane.moveToFront(manageAnnualFee);
		        manageAnnualFee.setVisible(true);
		    }
		});
		
		mainGUI.getRegisterButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	mainGUI.setVisible(false);
		        layeredPane.moveToFront(registrationGUI);
		        registrationGUI.setVisible(true);
		    }
		});
		
		mainGUI.getShowtimesButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	mainGUI.setVisible(false);
		        layeredPane.moveToFront(viewShowtimes);
		        viewShowtimes.setVisible(true);
		    }
		});
		
		mainGUI.getLoginButton().addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	mainGUI.setVisible(false);
		        layeredPane.moveToFront(loginGUI);
		        loginGUI.setVisible(true);
		    }
		});

	}
	
	
	class ReturnHomeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			viewShowtimes.setVisible(false);
			browseMovies.setVisible(false);;
			browseTheater.setVisible(false);;
			cancellation.setVisible(false);;
			reservation.setVisible(false);;
			purchaseTicketsGUI.setVisible(false);;	
			makePaymentGUI.setVisible(false);;
			manageAnnualFee.setVisible(false);;
			registratonGUI.setVisible(false);;
			loginGUI.setVisible(false);
			layeredPane.moveToFront(mainGUI);
			mainGUI.setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		ManageTheater manageTheater = new ManageTheater(true);

		ArrayList<Movie> movies = new ArrayList<Movie>();
		ArrayList<Theater> theaters = new ArrayList<Theater>();
		ArrayList<String> moviePosters = new ArrayList<String>();
		TheaterSystem theaterSystem = new TheaterSystem(movies, theaters, moviePosters);
		manageTheater.setTheaterSystem(theaterSystem);
		
		ViewShowtimesGUI viewShowtimes = new ViewShowtimesGUI(manageTheater.getUserStatus());
		BrowseTheaterGUI browseTheater = new BrowseTheaterGUI(manageTheater.getUserStatus());
		
		String[][] moviesWithAccess = new String[][] {
    		{"Pirates of the Carribbean", "✓"},
    		{null, null},
    		{null, null},
    		{null, null},
    	};
    	
    	
		BrowseMoviesGUI browseMovies = new BrowseMoviesGUI(moviesWithAccess, 
				manageTheater.getUserStatus(),
				manageTheater.getTheaterSystem().getShowTimesArray());
		
		
		
		manageTheater.setShowtimesView(viewShowtimes);
		manageTheater.setTheaterView(browseTheater);
		manageTheater.setMovieView(browseMovies);
		
		
		MainGUI mainGUI = new MainGUI();
		CancellationGUI cancel = new CancellationGUI(false);
		ReservationGUI reservation = new ReservationGUI();
		LoginGUI loginGUI = new LoginGUI();
		MakePaymentGUI makePaymentGUI = new MakePaymentGUI();
		ManageAnnualFeeGUI manageAnnualFeeGUI = new ManageAnnualFeeGUI();
		RegistrationGUI registrationGUI = new RegistrationGUI();
		PurchaseTicketsGUI purchaseTicketsGUI = new PurchaseTicketsGUI();
		
		
		cancel.setLayout(null);
		mainGUI.setLayout(null);
		browseMovies.setLayout(null);
		browseTheater.setLayout(null);
		loginGUI.setLayout(null);
		makePaymentGUI.setLayout(null);
		manageAnnualFeeGUI.setLayout(null);
		purchaseTicketsGUI.setLayout(null);
		registrationGUI.setLayout(null);
		reservation.setLayout(null);
		viewShowtimes.setLayout(null);
		
		
		mainGUI.setVisible(false);
		cancel.setVisible(false);
		browseMovies.setVisible(false);
		browseTheater.setVisible(false);
		loginGUI.setVisible(false);
		makePaymentGUI.setVisible(false);
		manageAnnualFeeGUI.setVisible(false);
		purchaseTicketsGUI.setVisible(false);
		registrationGUI.setVisible(false);
		reservation.setVisible(false);
		viewShowtimes.setVisible(false);
		
		
		
		GUIController guiController = new GUIController(mainGUI, viewShowtimes, browseMovies,
				browseTheater, cancel, reservation, purchaseTicketsGUI, makePaymentGUI, 
				manageAnnualFeeGUI, registrationGUI, loginGUI);
		
	}

}
