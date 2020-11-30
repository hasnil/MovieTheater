package Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TheaterSystem {

	private ArrayList<Movie> moviesList;
	private ArrayList<Theater> theatersList;
	private ArrayList<String> posterURLs;
	private ManageTheater manageTheater;
	private Movie selectedMovie;
	private ShowTime selectedShowTime;
	private Theater selectedTheater;
	
	
	public TheaterSystem(ArrayList<Movie> moviesList, ArrayList<Theater> theatersList, ArrayList<String> posterURLs) {
		this.moviesList = moviesList;
		this.theatersList = theatersList;
		this.posterURLs = posterURLs;
	}
	
	public ArrayList<Movie> getMoviesList() {
		return moviesList;
	}

	public void setMoviesList(ArrayList<Movie> moviesList) {
		this.moviesList = moviesList;
	}

	public ArrayList<Theater> getTheatersList() {
		return theatersList;
	}

	public void setTheatersList(ArrayList<Theater> theatersList) {
		this.theatersList = theatersList;
	}

	public ManageTheater getManageTheater() {
		return manageTheater;
	}

	public void setManageTheater(ManageTheater manageTheater) {
		this.manageTheater = manageTheater;
	}
	
	public Movie searchMovieByName(String name) {
		for(Movie m : moviesList) {
			if(m.getMovieName().equals(name)) {
				return m;
			}
		}
		return null;
	}
	
	public String getMatchingPosterURL(String movieName) {
		int index = 0;
		
		for(int i = 0; i < moviesList.size(); i++) {
			if(moviesList.get(i).getMovieName().equals(movieName)) {
				index = i;
				break;
			}
		}
		return posterURLs.get(index);
	}

	public String[] getShowTimesAndMoviesList(){
		
		HashMap<String,String> showtimesAndMovies = new HashMap<String,String>();
		
		for(Movie m: moviesList) {
			for(ShowTime s : m.getShowTimes()) {
				showtimesAndMovies.put(s.toString(), m.getMovieName());
			}
		}
		
		ArrayList<String> stringList = new ArrayList<String>();
		Set<String> showtimes = showtimesAndMovies.keySet();
		
		for(String s: showtimes) {
			stringList.add(showtimesAndMovies.get(s) + s);
		}
		String[] showtimesArray = new String[stringList.size()];
		
		for(int i = 0; i < showtimesArray.length; i++) {
			showtimesArray[i] = stringList.get(i);
		}
		
		return showtimesArray;
	}
	
	public ArrayList<ShowTime> getShowTimesList(){
		
		ArrayList<ShowTime> showtimes = new ArrayList<ShowTime>();
		
		for(Movie m: moviesList) {
			for(ShowTime s : m.getShowTimes()) {
				showtimes.add(s);
			}
		}
		return showtimes;
	}
	
	
	public ShowTime[] getShowTimesArray(){
		
		ArrayList<ShowTime> showtimesList = new ArrayList<ShowTime>();
		
		for(Movie m: moviesList) {
			if(m.getShowTimes() == null) {
				break;
			}
			for(ShowTime s : m.getShowTimes()) {
				showtimesList.add(s);
			}
		}
		
		ShowTime[] showtimes = new ShowTime[showtimesList.size()];
		
		for(int i = 0; i < showtimes.length; i++) {
			showtimes[i] = showtimesList.get(i);
		}
		return showtimes;
	}

	public Theater getSelectedTheater() {
		return selectedTheater;
	}

	public void setSelectedTheater(Theater selectedTheater) {
		this.selectedTheater = selectedTheater;
	}
	
	public Movie getSelectedMovie() {
		return selectedMovie;
	}

	public void setSelectedMovie(Movie selectedMovie) {
		this.selectedMovie = selectedMovie;
	}

	public ShowTime getSelectedShowTime() {
		return selectedShowTime;
	}

	public void setSelectedShowTime(ShowTime selectedShowTime) {
		this.selectedShowTime = selectedShowTime;
	}
	
	public String[][] getMoviesWithAccess(String movieName){
		ArrayList<Movie> moviesArr = getMoviesList();
		ArrayList<Movie> filteredMovies = new ArrayList<Movie>();
		
		
		for(Movie m : moviesArr) {
			if(m.getMovieName().contains(movieName)) {
				filteredMovies.add(m);
			}
		}
		
		String [][] moviesWithAccess = new String[filteredMovies.size()][2];
		
		
		for(int i = 0; i < filteredMovies.size(); i++) {
			moviesWithAccess[i][0] = filteredMovies.get(i).getMovieName();
			
			if(filteredMovies.get(i).isEarlyAccess() == true) {
				moviesWithAccess[i][1] = "Y";
			}
			else {
				moviesWithAccess[i][1] = "N";
			}			
		}
		
		return moviesWithAccess;
	}
	
	public String[][] getAllMoviesWithAccess(){
		ArrayList<Movie> moviesArr = getMoviesList();
		
		String [][] moviesWithAccess = new String[moviesArr.size()][2];
		
		
		for(int i = 0; i < moviesArr.size(); i++) {
			moviesWithAccess[i][0] = moviesArr.get(i).getMovieName();
			
			if(moviesArr.get(i).isEarlyAccess() == true) {
				moviesWithAccess[i][1] = "Y";
			}
			else {
				moviesWithAccess[i][1] = "N";
			}			
		}
		
		return moviesWithAccess;
	}

	
	
}
