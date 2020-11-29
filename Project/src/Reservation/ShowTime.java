package Reservation;

public class ShowTime {

    private String showTime;
    private String movieName;

    public ShowTime(String showTime, String movieName) {
        setShowTime(showTime);
        setMovieName(movieName);
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "ShowTime{" +
                "showTime=" + showTime +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
