package Theater;

public class Seat {
	
	private int seatNumber;
	private char seatRow;
	private boolean occupied;
	
	public Seat(int seatNum, char seatRow) {
		this.seatNumber = seatNum;
		this.seatRow = seatRow;
	}
	
	public int getSeatNumber() {
		return seatNumber;
	}
	
	public char getSeatRow() {
		return seatRow;
	}
	
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	@Override
	public String toString() {
		String status = "AVAILABLE";
		if (isOccupied())
			status = "OCCUPIED";
		return "Seat: " + getSeatRow() + getSeatNumber() + " status: " + status;
	}

}
