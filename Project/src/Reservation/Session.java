package Reservation;

import java.util.ArrayList;

import Theater.Room; 
import Theater.Movie;
import Theater.ShowTime;

public class Session {

	private Movie movie;
	private ShowTime showTime;
	private Room room;
	private ArrayList<Integer> selectedSeats;
	
	
	
	public Session(Movie movie, ShowTime showTime, Room room) {
		setMovie(movie);
		setShowTime(showTime);
		setRoom(room);
		selectedSeats = new ArrayList<Integer>();
		
	}





	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public ShowTime getShowTime() {
		return showTime;
	}
	public void setShowTime(ShowTime showTime) {
		this.showTime = showTime;
	}


	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}


	public ArrayList<Integer> getSelectedSeats() {
		return selectedSeats;
	}


	public void setSelectedSeats(ArrayList<Integer> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	
	
}
