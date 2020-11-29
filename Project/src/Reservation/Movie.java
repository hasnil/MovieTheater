package Reservation;

import java.util.ArrayList;
import java.util.Date;

public class Movie {

    private String movieName;
    private ArrayList<ShowTime> showTimes;
    private Date releaseDate;

    public Movie(String movieName, Date releaseDate) {
        setMovieName(movieName);
        setReleaseDate(releaseDate);
        showTimes = new ArrayList<>();
    }

    public void addShowTime(ShowTime showTime) {
        showTimes.add(showTime);
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", showTimes=" + showTimes +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
