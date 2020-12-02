package theater;

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

		Set<String> showtimes = showtimesAndMovies.keySet();
		String[] showtimesArray = showtimes.toArray(new String[showtimes.size()]);
		
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

	
	
}
