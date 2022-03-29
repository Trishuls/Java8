import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
}

class Movies implements java.lang.Comparable<Movies> {
    private double rating;
    private String movie;
    private int year;

    public Movies(String movie, double rating, int year) {
        this.rating = rating;
        this.movie = movie;
        this.year = year;
    }


    @Override
    public int compareTo(Movies m) {
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

class RatingComparator implements Comparator<Movies>{

    @Override
    public int compare(Movies o1, Movies o2) {
        if (o1.getRating() > o2.getRating())
            return 1;
        if (o1.getRating() < o2.getRating())
            return -1;
        else
            return 0;
    }
}

class NameComparator implements Comparator<Movies>{

    @Override
    public int compare(Movies o1, Movies o2) {
        return o1.getMovie().compareTo(o2.getMovie());
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Movies> list = new ArrayList<>();
        list.add(new Movies("Force Awakens", 8.3, 2015));
        list.add(new Movies("Star Wars", 8.7, 1977));
        list.add(new Movies("Empire Strikes Back", 8.8, 1980));
        list.add(new Movies("Return of the Jedi", 8.4, 1983));

        Collections.sort(list,new NameComparator());

        System.out.println(list);

        Collections.sort(list,new RatingComparator());
        System.out.println(list);
    }
}