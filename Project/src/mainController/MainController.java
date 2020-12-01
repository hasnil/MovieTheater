package mainController;

import Database.DBController;
import Database.TheaterDBLoader;
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
		this.setManageTheater(manageTheater);
		this.manageReservations = manageReservations;
		this.databaseController = databaseController;
        databaseController.loadFromDB();
        
        manageLogin.setMainController(this);

	}
	
    public static void main(String[] args) {
    	
    	TheaterDBLoader theaterLoader = new TheaterDBLoader();
    	
        // Set up Manage Reservations and Reservation GUIs
        PaymentSystem paymentSystem = new PaymentSystem();
        MakePayment makePayment = new MakePayment(paymentSystem);
        MakePaymentGUI makePaymentGUI = new MakePaymentGUI(makePayment);
        makePayment.setMakePaymentGUI(makePaymentGUI);
        CancellationGUI cancel = new CancellationGUI(false);
        ReservationGUI reservation = new ReservationGUI();
        PurchaseTicketsGUI purchaseTicketsGUI = new PurchaseTicketsGUI();
        ReservationSystem reservationSystem = new ReservationSystem(makePaymentGUI, theaterLoader.loadSessions());
        ManageReservations manageReservations = new ManageReservations(reservationSystem, cancel, reservation, purchaseTicketsGUI);
        reservation.setManageReservations(manageReservations);
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
        RegistrationGUI registrationGUI = new RegistrationGUI();
        ManageRegistration manageRegistration = new ManageRegistration(registrationGUI, userSystem);
        manageAnnualFee.setManageRegistration(manageRegistration);
        ////////////////////////////////////////////////////////
        
        // Set up Manage Login and Login GUI
        ManageLogin manageLogin = new ManageLogin(userSystem);
        LoginGUI loginGUI = new LoginGUI();
        manageLogin.setLoginGUI(loginGUI);
        ///////////////////////////////////////////////////////
        
     // Set up MainGUI
        MainGUI mainGUI = new MainGUI();
     ////////////////////////////////////////////////////////

        
        
        DBController dbController = new DBController(userSystem, reservationSystem);
        
        
        // Set up Manage Theater and Theater GUIs
        ManageTheater manageTheater = new ManageTheater(false);
        TheaterSystem theaterSystem = new TheaterSystem(theaterLoader.loadMoviesFromDatabase(), new ArrayList<Theater>()
        		, theaterLoader.loadPostersFromDatabase());
        manageTheater.setTheaterSystem(theaterSystem);
        ViewShowtimesGUI viewShowtimes = new ViewShowtimesGUI(manageTheater.getUserStatus());
        BrowseTheaterGUI browseTheater = new BrowseTheaterGUI(manageTheater.getUserStatus());
        BrowseMoviesGUI browseMovies = new BrowseMoviesGUI(theaterSystem.getAllMoviesWithAccess(),
                manageTheater.getUserStatus(), manageTheater.getTheaterSystem().getShowTimesArray());
        browseMovies.setManageTheater(manageTheater);
        manageTheater.setShowtimesView(viewShowtimes);
        manageTheater.setTheaterView(browseTheater);
        manageTheater.setMovieView(browseMovies);
        ////////////////////////////////////////////////////

       

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
        		manageAnnualFee, guiController, manageTheater, manageReservations, dbController);
        
    }


	public ManageTheater getManageTheater() {
		return manageTheater;
	}


	public void setManageTheater(ManageTheater manageTheater) {
		this.manageTheater = manageTheater;
	}


	public GUIController getGUIController() {
		return guiController;
	}
}
