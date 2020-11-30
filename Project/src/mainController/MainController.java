package mainController;

import Database.DBController;
import GUI.GUIController;
import GUI.MainGUI;
import Payment.MakePayment;
import Payment.MakePaymentGUI;
import Payment.PaymentSystem;
import Registration.*;
import Reservation.*;
import Theater.BrowseMoviesGUI;
import Theater.BrowseTheaterGUI;
import Theater.ManageTheater;
import Theater.Movie;
import Theater.Theater;
import Theater.TheaterSystem;
import Theater.ViewShowtimesGUI;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainController {
	
	private MakePayment makePayment;
	private ManageLogin manageLogin;
	private ManageRegistration manageRegistration;
	private ManageAnnualFee manageAnnualFee;
	private GUIController guiController;
	private ManageTheater manageTheater;
	private ManageReservations manageReservations;
	private DBController databaseController;
	
	
	
	public MainController(MakePayment makePayment, ManageLogin manageLogin, ManageRegistration manageRegistration, ManageAnnualFee manageAnnualFee,
			GUIController guiController, ManageTheater manageTheater, ManageReservations manageReservations, DBController databaseController) {
		
		this.makePayment = makePayment;
		this.manageLogin = manageLogin;
		this.manageRegistration = manageRegistration;
		this.manageAnnualFee = manageAnnualFee;
		this.guiController = guiController;
		this.manageTheater = manageTheater;
		this.manageReservations = manageReservations;
		this.databaseController = databaseController;
        databaseController.loadFromDB();
	}
	

    /*
    public void setMainGui(MainGUI mainGui) {
        this.mainGui = mainGui;
    }

    public void setRegistrationGUI(RegistrationGUI registrationGUI) {
        this.registrationGUI = registrationGUI;
    }

    public void setLoginGUI(LoginGUI loginGUI) {
        this.loginGUI = loginGUI;
    }

    public void setMakePaymentGUI(MakePaymentGUI makePaymentGUI) {
        this.makePaymentGUI = makePaymentGUI;
    }

    public void setReservationGUI(ReservationGUI reservationGUI) {
        this.reservationGUI = reservationGUI;
    }
     */
	
    public static void main(String[] args) {
    	   
       
    	// Set up Manage Theater and Theater GUIs
        ManageTheater manageTheater = new ManageTheater(false);
        ArrayList<Movie> movies = new ArrayList<Movie>(); //load from database
        Movie testMovie = new Movie("Star Wars: Episode III – Revenge of the Sith", null, LocalDateTime.of(2020, 12, 28, 0, 0));
        Movie testMove2 = new Movie("Pirates of the Caribbean: The Curse of the Black Pearl", null, LocalDateTime.of(2020, 11, 28, 0, 0));
        movies.add(testMovie);
        movies.add(testMove2);
        ArrayList<Theater> theaters = new ArrayList<Theater>(); // load from database
        ArrayList<String> moviePosters = new ArrayList<String>(); // load from database
        moviePosters.add("https://upload.wikimedia.org/wikipedia/en/9/93/Star_Wars_Episode_III_Revenge_of_the_Sith_poster.jpg");
        moviePosters.add("https://upload.wikimedia.org/wikipedia/en/8/89/Pirates_of_the_Caribbean_-_The_Curse_of_the_Black_Pearl.png");
        TheaterSystem theaterSystem = new TheaterSystem(movies, theaters, moviePosters);
        manageTheater.setTheaterSystem(theaterSystem);
        ViewShowtimesGUI viewShowtimes = new ViewShowtimesGUI(manageTheater.getUserStatus());
        BrowseTheaterGUI browseTheater = new BrowseTheaterGUI(manageTheater.getUserStatus());
        BrowseMoviesGUI browseMovies = new BrowseMoviesGUI(theaterSystem.getAllMoviesWithAccess(),
                manageTheater.getUserStatus(), manageTheater.getTheaterSystem().getShowTimesArray());
        manageTheater.setShowtimesView(viewShowtimes);
        manageTheater.setTheaterView(browseTheater);
        manageTheater.setMovieView(browseMovies);
        ////////////////////////////////////////////////////
        
        
        
        // Set up Manage Reservations and Reservation GUIs
        PaymentSystem paymentSystem = new PaymentSystem();
        MakePayment makePayment = new MakePayment(paymentSystem);
        MakePaymentGUI makePaymentGUI = new MakePaymentGUI(makePayment);
        CancellationGUI cancel = new CancellationGUI(false);
        ReservationGUI reservation = new ReservationGUI();
        PurchaseTicketsGUI purchaseTicketsGUI = new PurchaseTicketsGUI();
        ReservationSystem reservationSystem = new ReservationSystem(makePaymentGUI);
        ManageReservations manageReservations = new ManageReservations(reservationSystem, cancel, reservation, purchaseTicketsGUI);
        ///////////////////////////////////////////////////////
        
        
        
        
        // Set up Make Payment and Payment GUI
        makePayment.setMakePaymentGUI(makePaymentGUI);
        //////////////////////////////////////////////////////
     
       
        // Set up Manage Annual Fee and Manage Annual Fee GUI
        ManageAnnualFee manageAnnualFee = new ManageAnnualFee(makePaymentGUI);
        ManageAnnualFeeGUI manageAnnualFeeGUI = new ManageAnnualFeeGUI();
        manageAnnualFeeGUI.setManageAnnualFeeGUI(manageAnnualFeeGUI);
        manageAnnualFee.setManageAnnualFeeGUI(manageAnnualFeeGUI);
        manageAnnualFee.setMakePayment(makePayment);
        makePayment.setManageAnnualFee(manageAnnualFee);
        UserSystem userSystem = new UserSystem(makePaymentGUI);
        manageAnnualFee.setUserSystem(userSystem);
        /////////////////////////////////////////////////////////
        
        
        
        // Set up Manage Registration and RegistrationGUI
        ManageRegistration manageRegistration = new ManageRegistration(userSystem);
        RegistrationGUI registrationGUI = new RegistrationGUI(manageRegistration);
        manageAnnualFee.setManageRegistration(manageRegistration);
        ////////////////////////////////////////////////////////
        
        
        // Set up Manage Login and Login GUI
        ManageLogin manageLogin = new ManageLogin(userSystem);
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setManageLogin(manageLogin);
        manageLogin.setLoginGUI(loginGUI);
        ///////////////////////////////////////////////////////
 
        
        
     // Set up MainGUI
        MainGUI mainGUI = new MainGUI();
     ////////////////////////////////////////////////////////

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
        
        // Set up GUIControllerr
        GUIController guiController = new GUIController(mainGUI, viewShowtimes, browseMovies, browseTheater, cancel, reservation,
                purchaseTicketsGUI, makePaymentGUI, manageAnnualFeeGUI, registrationGUI, loginGUI);
        //////////////////////////////
        
        MainController mainController = new MainController(makePayment, manageLogin, manageRegistration, 
        		manageAnnualFee, guiController, manageTheater, manageReservations, new DBController(userSystem, reservationSystem));
        
    }
}
