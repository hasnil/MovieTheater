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
			for (int c = 0; c < columns; c++) {
				addSeat(c, rowValue);
			}
			rowValue++;
		}
	}
	
	public void addSeat(int seatNum, char seatRow) {
		//TODO
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public ArrayList<Seat> getSeats() {
		return seats;
	}

}
