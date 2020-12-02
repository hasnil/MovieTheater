package Theater;

import java.util.ArrayList;

public class Room {
	
	private int roomNumber;
	private int seatsPerRoom;
	private ArrayList<Seat> seats;
	
	public Room(int roomNum, int seatsPerRoom) {
		this.roomNumber = roomNum;
		this.setSeatsPerRoom(seatsPerRoom);
		this.seats = new ArrayList<Seat>();
		
		//Creating seats
		for (int r = 0; r < seatsPerRoom; r++) {
			addSeat(r);
		}
	}
	public Seat getSeatAt(int number) {
		
		for(Seat seat: seats) {
			if(seat.getSeatNumber() == number)
				return seat;
		}
		
		return null;
	}
	public void addSeat(int seatNum) {
		Seat seat = new Seat(seatNum);
		seats.add(seat);
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	
	public int getSeatsPerRoom() {
		return seatsPerRoom;
	}
	public void setSeatsPerRoom(int seatsPerRoom) {
		this.seatsPerRoom = seatsPerRoom;
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
