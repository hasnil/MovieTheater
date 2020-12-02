package Theater;

public class Seat {
	
	private int seatNumber;
	private boolean occupied;
	
	public Seat(int seatNum) {
		this.seatNumber = seatNum;
	}
	
	public int getSeatNumber() {
		return seatNumber;
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
		return "Seat: " + getSeatNumber() + " status: " + status;
	}

}
