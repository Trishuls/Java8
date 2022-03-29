import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Comparable {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);

        System.out.println(list);
    }
}

class Movie implements java.lang.Comparable<Movie> {
    private double rating;
    private String movie;
    private int year;

    public Movie(String movie, double rating, int year) {
        this.rating = rating;
        this.movie = movie;
        this.year = year;
    }


    @Override
    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    public double getRating() {
        return rating;
    }

    public String getMovie() {
        return movie;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", movie='" + movie + '\'' +
                ", year=" + year +
                '}';
    }
}