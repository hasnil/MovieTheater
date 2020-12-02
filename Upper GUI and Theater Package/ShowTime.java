package theater;

import java.time.LocalDateTime;

public class ShowTime {

	private LocalDateTime time;
	
	public ShowTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	
	public LocalDateTime getTime() {
		return time;
	}



	public void setTime(LocalDateTime time) {
		this.time = time;
	}



	public String toString() {
		return time.toString();
	}
}
