package Theater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class ManageTheater {

	private TheaterSystem theaterSystem;
	private BrowseTheaterGUI theaterView;
	private BrowseMoviesGUI movieView;
	private ViewShowtimesGUI showtimesView;
	private boolean theaterSelected = false;
	private boolean movieSelected = false;
	private boolean showtimeSelected = false;
	private boolean userStatus;  //true is logged in, false is regular
	
	
	public ManageTheater(boolean userStatus) {
		this.userStatus = userStatus;
	}
	
	
	class ViewSelectedShowtimesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			showtimesView.setInfoLabelText("These are the showtimes for your currently selected movie:");
			
			ArrayList<ShowTime> showtimesList = theaterSystem.getShowTimesList();
			DefaultListModel<ShowTime> listModel = new DefaultListModel<ShowTime>();
			
			for (ShowTime s: showtimesList) {
				for(ShowTime s2: theaterSystem.getSelectedMovie().getShowTimes()) {
					if(s.getTime().compareTo(s2.getTime()) == 0) {
						listModel.addElement(s);
					}
				}
			}
			
			try {
				showtimesView.setShowtimesList(listModel);
			}catch (Exception ex) {
				showtimesView.displayMessage("Something went wrong! Please retry.");
			}
		}
	}
	
	
	class ConfirmShowtimeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ShowTime selectedShowtime = showtimesView.getShowtimesListSelection();
			
			if(selectedShowtime != null) {
				showtimeSelected = true;
				theaterSystem.setSelectedShowTime(selectedShowtime);
				showtimesView.displayMessage("Your showtime selection was successful. Please proceed to seat reservation.");	
			}
		}
	}
	
	
	class ListAllShowtimesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			showtimesView.setInfoLabelText("These are the showtimes for all movies:");
			String[] showTimesAndMovieList = theaterSystem.getShowTimesAndMoviesList();
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			
			for (String s: showTimesAndMovieList) {
				listModel.addElement(s);
			}
			
			try {
				showtimesView.setShowtimesAndMoviesList(listModel);
			}catch (Exception ex) {
				showtimesView.displayMessage("Something went wrong! Please retry.");
			}
		}
	}
	
	
	class ConfirmTheaterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String theaterName = theaterView.getTheaterNameSelection();
			if(theaterName != null) {
				theaterSelected = true;
				Theater selectedTheater = null;
				
				for(Theater t: theaterSystem.getTheatersList()) {
					if(t.getName().equals(theaterName)) {
						selectedTheater = t;
					}
				}
				theaterSystem.setSelectedTheater(selectedTheater);
				theaterView.displayMessage("Your theater selection was successful.");
			}
		}
	}
	
	
	class ConfirmMovieListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String movieName = movieView.getMovieNameSelection();
			if(movieName != null) {
				
				if(theaterSystem.searchMovieByName(movieName).isEarlyAccess() == true && userStatus == false) {
					movieView.displayMessage("Sorry, only registered users may select that movie right now! Please consider registering.");
					return;
				}
						
				
				movieSelected = true;
				Movie selectedMovie = null;
				
				for(Movie m: theaterSystem.getMoviesList()) {
					if(m.getMovieName().equals(movieName)) {
						selectedMovie = m;
					}
				}
				theaterSystem.setSelectedMovie(selectedMovie);
				
				movieView.displayMessage("Your movie selection was successful.");
		}
		}
	}
	
	
	
	class SearchMovieListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String movieName = movieView.getSearchString();
			String[][] moviesWithAccess = theaterSystem.getMoviesWithAccess(movieName);
			
			try {
				movieView.setUpTable(moviesWithAccess);
				movieView.addMovieRowListener(new MovieRowClickListener());
			}catch (Exception ex) {
				movieView.displayMessage("Something went wrong! Please retry.");
			}
		}
	}

	
	class ListAllMoviesButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Movie> moviesArr = theaterSystem.getMoviesList();
			int size = moviesArr.size();
			
			String [][] moviesWithAccess = new String[size][2];
			
			
			for(int i = 0; i < size; i++) {
				moviesWithAccess[i][0] = moviesArr.get(i).getMovieName();
				
				if(moviesArr.get(i).isEarlyAccess() == true) {
					moviesWithAccess[i][1] = "Y";
				}
				else {
					moviesWithAccess[i][1] = "N";
				}			
			}
			
			try {
				movieView.setUpTable(moviesWithAccess);
				movieView.addMovieRowListener(new MovieRowClickListener());
			}catch (Exception ex) {
				movieView.displayMessage("Something went wrong! Please retry.");
			}
		}
	}
	

	class MovieRowClickListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			String movieName = movieView.getMovieNameSelection();
			String path = theaterSystem.getMatchingPosterURL(movieName);
			URL urlAddress = null;
			try {
				urlAddress = new URL(path);
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			}
			BufferedImage moviePoster = null;
			try {
				moviePoster = ImageIO.read(urlAddress);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			movieView.setPosterLabel(new ImageIcon(moviePoster));
		}
	}
	
	
	class BrowseMoviesComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ShowTime selectedShowtime = (ShowTime) movieView.getShowtimesComboBox().getSelectedItem();
			ArrayList<Movie> moviesArr = new ArrayList<Movie>();
			
			
			for(Movie m : theaterSystem.getMoviesList()) {
				for(ShowTime s: m.getShowTimes()) {
					if(s.getTime().compareTo(selectedShowtime.getTime()) == 0) {
						moviesArr.add(m);
					}
				}
			}			
			
			int size = moviesArr.size();
			
			String [][] moviesWithAccess = new String[size][2];
			
			
			for(int i = 0; i < size; i++) {
				moviesWithAccess[i][0] = moviesArr.get(i).getMovieName();
				
				if(moviesArr.get(i).isEarlyAccess() == true) {
					moviesWithAccess[i][1] = "Y";
				}
				else {
					moviesWithAccess[i][1] = "N";
				}			
			}
			
			try {
				movieView.setUpTable(moviesWithAccess);
				movieView.addMovieRowListener(new MovieRowClickListener());
			}catch (Exception ex) {
				movieView.displayMessage("Something went wrong! Please retry.");
			}
		}
	}
	
	public TheaterSystem getTheaterSystem() {
		return theaterSystem;
	}
	public void setTheaterSystem(TheaterSystem theaterSystem) {
		this.theaterSystem = theaterSystem;
	}
	public BrowseTheaterGUI getTheaterView() {
		return theaterView;
	}
	public void setTheaterView(BrowseTheaterGUI theaterView) {
		this.theaterView = theaterView;
		theaterView.addConfirmTheaterButtonListener(new ConfirmTheaterListener());
		//theaterView.addReturnListener(new TheatersReturnHomeListener());	
	}
	public BrowseMoviesGUI getMovieView() {
		return movieView;
	}
	
	
	public void setMovieView(BrowseMoviesGUI movieView) {
		this.movieView = movieView;
		movieView.addConfirmMovieButtonListener(new ConfirmMovieListener());
		movieView.addSearchButtonListener(new SearchMovieListener());
		movieView.addListAllButtonListener(new ListAllMoviesButtonListener());
		movieView.addMovieRowListener(new MovieRowClickListener());
		movieView.addComboBoxListener(new BrowseMoviesComboBoxListener());
		//movieView.addReturnListener(new MoviesReturnHomeListener());
		if(theaterSelected == false) {
			movieView.getWelcomeLabel().setText("You must select a theater to see movies.");
			movieView.getTable().setVisible(false);
			movieView.getConfirmSelectionButton().setEnabled(false);
			movieView.getSearchButton().setEnabled(false);
			movieView.getListAllMoviesButton().setEnabled(false);
			movieView.getShowtimesComboBox().setEnabled(false);
		}
	}
	
	
	public ViewShowtimesGUI getShowtimesView() {
		return showtimesView;
	}
	
	public void setShowtimesView(ViewShowtimesGUI showtimesView) {
		this.showtimesView = showtimesView;
		showtimesView.addAllShowtimesButtonListener(new ListAllShowtimesListener());
		showtimesView.addConfirmShowtimeButtonListener(new ConfirmShowtimeListener());
		showtimesView.addSelectedShowtimesButtonListener(new ViewSelectedShowtimesListener());
		//showtimesView.addReturnListener(new ShowtimesReturnHomeListener());
		if(theaterSelected == false) {
			showtimesView.getInfoLabel().setText("You must select a movie to see specific showtimes.");
			showtimesView.getConfirmShowtimeButton().setEnabled(false);
			showtimesView.getViewSelectedShowtimesButton().setEnabled(false);
		}		
		
	}
	public boolean isTheaterSelected() {
		return theaterSelected;
	}
	public void setTheaterSelected(boolean theaterSelected) {
		this.theaterSelected = theaterSelected;
	}
	public boolean isMovieSelected() {
		return movieSelected;
	}
	public void setMovieSelected(boolean movieSelected) {
		this.movieSelected = movieSelected;
	}
	public boolean isShowtimeSelected() {
		return showtimeSelected;
	}
	public void setShowtimeSelected(boolean showtimeSelected) {
		this.showtimeSelected = showtimeSelected;
	}
	
	
	public boolean getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}
	
}
