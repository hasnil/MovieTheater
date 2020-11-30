package Theater;

import java.util.ArrayList;

public class Room {
	
	private int roomNumber;
	private int rows;
	private int columns;
	private ArrayList<Seat> seats;
	
	public Room(int roomNum, int rows, int columns) {
		this.roomNumber = roomNum;
		this.rows = rows;
		this.columns = columns;
		this.seats = new ArrayList<Seat>();
		char rowValue = 'A';
		
		//Creating seats
		for (int r = 0; r < rows; r++) {
			for (int c = 1; c <= columns; c++) {
				addSeat(c, rowValue);
			}
			rowValue++;
		}
	}
	
	public void addSeat(int seatNum, char seatRow) {
		Seat seat = new Seat(seatNum, seatRow);
		getSeats().add(seat);
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	
	@Override
	public String toString() {
		String out = "Room number: " + getRoomNumber() + " " + "Amount of seats: " + getSeats().size() + "\n";
		
		for (Seat seat : getSeats()) { 		      
			out += seat.toString() + "\n";
		}
	    
		return out;
	}

}
