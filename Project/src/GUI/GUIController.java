package GUI;

import Payment.MakePaymentGUI;
import Payment.MakeTicketPaymentGUI;
import Registration.*;
import Registration.RegistrationGUI;
import Reservation.CancellationGUI;
import Reservation.PurchaseTicketsGUI;
import Reservation.Reservation;
import Reservation.ReservationGUI;
import Reservation.Session;
import Reservation.Ticket;
import Theater.*;
import mainController.MainController;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;


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
    private RegistrationGUI registrationGUI;
    private MakeTicketPaymentGUI makeTicketPaymentGUI;
    private LoginGUI loginGUI;
    private JLayeredPane layeredPane;
    private boolean userStatus;
    private MainController mainController;

	public GUIController(MainGUI mainGUI, ViewShowtimesGUI viewShowtimes, BrowseMoviesGUI browseMovies,
                         BrowseTheaterGUI browseTheater, CancellationGUI cancellation, ReservationGUI reservation,
                         PurchaseTicketsGUI purchaseTicketsGUI, MakePaymentGUI makePaymentGUI,
                         ManageAnnualFeeGUI manageAnnualFee, RegistrationGUI registrationGUI, LoginGUI loginGUI,
                         MakeTicketPaymentGUI makeTicketPaymentGUI) {

        this.mainGUI = mainGUI;
        this.viewShowtimes = viewShowtimes;
        this.browseMovies = browseMovies;
        this.browseTheater = browseTheater;
        this.cancellation = cancellation;
        this.reservation = reservation;
        this.purchaseTicketsGUI = purchaseTicketsGUI;
        this.makePaymentGUI = makePaymentGUI;
        this.manageAnnualFee = manageAnnualFee;
        this.registrationGUI = registrationGUI;
        this.loginGUI = loginGUI;
        this.makeTicketPaymentGUI = makeTicketPaymentGUI;
        this.mainGUI.getManageAnnualFeeButton().setEnabled(false);


        JFrame frame = new JFrame("Slab Cinemas Theater Application");
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
        layeredPane.add(makeTicketPaymentGUI, 11);
        makeTicketPaymentGUI.setBounds(0, 0, 1000, 650);
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
        loginGUI.getReturnHomeButton().addActionListener(new ReturnHomeListenerForLogin());
        makePaymentGUI.getReturnHomeButton().addActionListener(new ReturnHomeListener());
        makeTicketPaymentGUI.getReturnHomeButton().addActionListener(new ReturnHomeListener());
        manageAnnualFee.getReturnHomeButton().addActionListener(new ReturnHomeListener());
        purchaseTicketsGUI.getReturnHomeButton().addActionListener(new ReturnHomeListener());
        registrationGUI.getReturnHomeButton().addActionListener(new ReturnHomeListener());
        reservation.getReturnHomeButton().addActionListener(new ReturnHomeListener());
        viewShowtimes.getReturnHomeButton().addActionListener(new ReturnHomeListener());
        registrationGUI.addMakePaymentListener(new AnnualFeeMakePaymentButtonListener());
        browseTheater.addConfirmTheaterButtonListener(new TheaterConfirmedListener());
        browseMovies.addConfirmMovieButtonListener(new MovieConfirmedListener());
        viewShowtimes.getConfirmShowtimeButton().addActionListener(new ConfirmShowtimeButtonListener());
        reservation.addConfirmedButtonListener(new ConfirmSeatListener());
        cancellation.addCancellationButtonListener(new CancelReservationButton());
        makeTicketPaymentGUI.addSubmitButtonListener(new TicketPaymentSubmitButtonListener());
        manageAnnualFee.addMakePaymentListener(new AnnualFeeMakePaymentButtonListener());


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

            	if(mainController.getManageLogin().getUser().isExpired()) {
            		manageAnnualFee.setLblNewLabel("Your Annual $20 Fee is Overdue:");
            	}
            	else {
            		manageAnnualFee.setLblNewLabel("Your Annual $20 Fee is Due By:");
            		manageAnnualFee.setDateLabel(mainController.getManageLogin().getUser().getExpDate().toString());
            	}
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
//////////////////////////////////////////////////////////////////
 
        purchaseTicketsGUI.getApplyVoucherButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // TODO apply voucher for purchase ticket
            }
        });
        


        purchaseTicketsGUI.getMakePaymentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                purchaseTicketsGUI.setVisible(false);
                layeredPane.moveToFront(makeTicketPaymentGUI);
                makeTicketPaymentGUI.setAmount(purchaseTicketsGUI.getAmount());
                makeTicketPaymentGUI.setVisible(true);
            }
        });
//////////////////////////////////////////////////////////////////////////



    }



    class TicketPaymentSubmitButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
            String cc = makeTicketPaymentGUI.getCardNumberField().getText();
            String cvv = makeTicketPaymentGUI.getSecurityCodeField().getText();
            boolean payment = makeTicketPaymentGUI.getMakePayment().payWithCreditCard(cc, cvv, makePaymentGUI.getAmount());
            if (payment) {
            	makeTicketPaymentGUI.displayMessage("Payment successful");

            	// blocks off appropriate seats
            	Movie movie = viewShowtimes.getManageTheater().getTheaterSystem().getSelectedMovie();
    			ShowTime showTime = viewShowtimes.getManageTheater().getTheaterSystem().getSelectedShowTime();
    			int roomNumber = showTime.getRoomNumber();

    			Session currentSession = reservation.getManageReservations().getReservationSystem().searchForSession(movie, showTime, roomNumber);
    			reservation.getManageReservations().setCurrentSession(currentSession);

    			ArrayList<Integer> seats = currentSession.getSelectedSeats();

    			ArrayList<Integer> selectedSeats = reservation.getSeatsBeingSelected();


    			for(int s: selectedSeats) {

					seats.add(s);

				}
    		
    			// Reservation creation
    			String userName = "Regular User";
    			
    			if (mainController.getManageLogin().getUser() != null) {
    				userName = mainController.getManageLogin().getUser().getUserName();
    			}
    			
    			reservation.getManageReservations().getReservationSystem().generateReservation(userName, currentSession);
    			
    			//Clear seats selected
    			reservation.getSeatsBeingSelected().clear();
    			
    			makeTicketPaymentGUI.displayMessage(reservation.toString());
            }
            else {
            	makeTicketPaymentGUI.displayMessage("Payment unsuccessful");
            }
        }
    }



    class CancelReservationButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int reservationId = 0;
            ArrayList<Integer> seatNumbersToRemove = null;
            Session sessionToRemoveSeatsFrom = null;
            ArrayList<Ticket> tickets = null;

            try {
            	// releases seats after cancellation
                reservationId = cancellation.getReservationId();

                TheaterSystem theaterSystem = browseMovies.getManageTheater().getTheaterSystem();

                tickets = cancellation.getManageReservations().getReservationSystem().searchForReservation(reservationId).getTickets();
                sessionToRemoveSeatsFrom = reservation.getManageReservations().getReservationSystem().searchForSession(theaterSystem.searchMovieByName(tickets.get(0).getMovieName())
                		, new ShowTime(tickets.get(0).getShowTime()), tickets.get(0).getRoom());

                seatNumbersToRemove = new ArrayList<Integer>();
                for(Ticket t: tickets) {
                	seatNumbersToRemove.add(t.getSeat());
                }

            } catch (NumberFormatException e) {
                cancellation.displayMessage("Enter a valid reservation ID");
            }
            if (reservationId != 0) {
                String message = cancellation.getManageReservations().getReservationSystem().cancelReservation(reservationId);
                cancellation.displayMessage(message);

                if(message.equals("Reservation doesn't exist") || message.equals( "Movie starts in less than 3 days, can't cancel anymore")) {

                }
                else {
                	for(Ticket t: tickets) {
                		int index = sessionToRemoveSeatsFrom.getSelectedSeats().indexOf(t.getRoom());
                		sessionToRemoveSeatsFrom.getSelectedSeats().remove(index);
                	}
                }
            }
        }
    }


    class ReturnHomeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            viewShowtimes.setVisible(false);
            browseMovies.setVisible(false);
            browseTheater.setVisible(false);
            cancellation.setVisible(false);
            reservation.setVisible(false);
            purchaseTicketsGUI.setVisible(false);
            makePaymentGUI.setVisible(false);
            makeTicketPaymentGUI.setVisible(false);
            manageAnnualFee.setVisible(false);
            registrationGUI.setVisible(false);
            loginGUI.setVisible(false);
            layeredPane.moveToFront(mainGUI);
            mainGUI.setVisible(true);
        }
    }
    
    class ConfirmShowtimeButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(viewShowtimes.getShowtimesListSelection() != null) {
				Movie movie = viewShowtimes.getManageTheater().getTheaterSystem().getSelectedMovie();
				
				ShowTime showTime = viewShowtimes.getShowtimesListSelection();
				int roomNumber = showTime.getRoomNumber();
				
				Session currentSession = reservation.getManageReservations().getReservationSystem().searchForSession(movie, showTime, roomNumber);
				
				ArrayList<Integer> seats = currentSession.getSelectedSeats();
				
				
				//s is seats numbers
				for(int s: seats) {
					reservation.getSeatBtn(s).setEnabled(false);
					reservation.getSeatBtn(s).setBackground(Color.BLUE);
				}
				
				
				viewShowtimes.setVisible(false);
				layeredPane.moveToFront(reservation);
				reservation.setVisible(true);
			}
		}
    	
    }

    
    
    class ConfirmSeatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Movie movie = viewShowtimes.getManageTheater().getTheaterSystem().getSelectedMovie();
			ShowTime showTime = viewShowtimes.getManageTheater().getTheaterSystem().getSelectedShowTime();
			int roomNumber = showTime.getRoomNumber();
			
			Session currentSession = reservation.getManageReservations().getReservationSystem().searchForSession(movie, showTime, roomNumber);
			reservation.getManageReservations().setCurrentSession(currentSession);
			
			ArrayList<Integer> seats = currentSession.getSelectedSeats();
			
			ArrayList<Integer> selectedSeats = reservation.getSeatsBeingSelected();
			
			if(selectedSeats.size() > 2 && movie.isEarlyAccess() == true) {
				viewShowtimes.displayMessage("Sorry, only 10% of seats may be reserved prior to public announcement.");
				return;
			}
			
			else if(selectedSeats.size() > 0) {
				
				
				reservation.setVisible(false);
				layeredPane.moveToFront(purchaseTicketsGUI);
				purchaseTicketsGUI.setNumOfTicketsLabel("Number of Tickets: " + selectedSeats.size());
				purchaseTicketsGUI.setTotalPriceLabel("Total Price: $" + 12 * selectedSeats.size() + ".00");
				purchaseTicketsGUI.setAmount(12 * selectedSeats.size());
				purchaseTicketsGUI.setVisible(true);	

			}
		}
    	
    }
    

    class AnnualFeeMakePaymentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            manageAnnualFee.setVisible(false);
            registrationGUI.setVisible(false);
            makePaymentGUI.setAmount(20);
            layeredPane.moveToFront(makePaymentGUI);
            makePaymentGUI.setVisible(true);
        }
    }

    class ReturnHomeListenerForLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(loginGUI.isLoginSuccessful() == true) {
                loginGUI.setVisible(false);
                setUserStatus(true);
                browseMovies.getManageTheater().setUserStatus(true);

                browseMovies.getLoginLabel().setText("Login Status: Logged In");
                browseTheater.getLoginLabel().setText("Login Status: Logged In");
                cancellation.getLoginLabel().setText("Login Status: Logged In");
                makePaymentGUI.getLoginLabel().setText("Login Status: Logged In");
                makeTicketPaymentGUI.getLoginLabel().setText("Login Status: Logged In");
                mainGUI.getManageAnnualFeeButton().setEnabled(true);
                manageAnnualFee.getLoginLabel().setText("Login Status: Logged In");
                purchaseTicketsGUI.getLoginLabel().setText("Login Status: Logged In");
                registrationGUI.getLoginLabel().setText("Login Status: Logged In");
                reservation.getLoginLabel().setText("Login Status: Logged In");
                viewShowtimes.getLoginLabel().setText("Login Status: Logged In");
                mainGUI.getRegisterButton().setEnabled(false);
                layeredPane.moveToFront(mainGUI);
                mainGUI.setVisible(true);
            }
            else {
                loginGUI.setVisible(false);
                layeredPane.moveToFront(mainGUI);
                mainGUI.setVisible(true);
            }
        }
    }

    class TheaterConfirmedListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String theaterName = browseTheater.getTheaterNameSelection();
            if(theaterName != null) {
                browseTheater.setVisible(false);
                layeredPane.moveToFront(mainGUI);
                mainGUI.setVisible(true);
                browseMovies.getWelcomeLabel().setText("Please have a look at our movies!");
                browseMovies.getTable().setVisible(true);
                browseMovies.getConfirmSelectionButton().setEnabled(true);
                browseMovies.getSearchButton().setEnabled(true);
                browseMovies.getListAllMoviesButton().setEnabled(true);
                browseMovies.getShowtimesComboBox().setEnabled(true);
            }
        }

    }

    class MovieConfirmedListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String movieName = browseMovies.getMovieNameSelection();
            if(movieName != null) {

                if(userStatus == false && browseMovies.getMovieAccessSelection() == true) {
                    return;
                }

                browseMovies.setVisible(false);
                layeredPane.moveToFront(reservation);
                viewShowtimes.setVisible(true);
                viewShowtimes.getViewAllShowtimesButton().setEnabled(false);
                viewShowtimes.getViewSelectedShowtimesButton().setEnabled(true);
                viewShowtimes.getConfirmShowtimeButton().setEnabled(true);
                viewShowtimes.getInfoLabel().setText("");
                DefaultListModel<String> listModel = new DefaultListModel<String>();
                viewShowtimes.setShowtimesAndMoviesList(listModel);
            }
        }

    }
    

	public void setUserStatus(boolean b) {
		this.userStatus = b;
	}

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
