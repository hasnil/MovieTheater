package Theater;

import java.time.LocalDateTime;

public class ShowTime {

	private LocalDateTime time;
	private int roomNumber;
	private String showTime;
    private String movieName;
	
	public ShowTime(LocalDateTime time) {
		this.time = time;
		
	}
	public ShowTime(String showTime, String movieName) {
        setShowTime(showTime);
        setMovieName(movieName);
    }
	
	
	public int getRoomNumber() {
		return roomNumber;
	}



	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}



	public LocalDateTime getTime() {
		return time;
	}



	public void setTime(LocalDateTime time) {
		this.time = time;
	}


	@Override
    public String toString() {
		return time.toString();
    }
	
	
	public String printToString() {
        return "showTime: " + showTime + "\n";
	}
	
	
	public String getShowTime() {
		return showTime;
	}
	
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
}
