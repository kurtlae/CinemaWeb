package group1.cinema.core;

import java.util.Comparator;

/**
 * Movie comparator class
 *
 * @author Emil Bertilsson
 */
public enum MovieComparator implements Comparator<Movie> {
    ;

    /**
     * Comparator
     */
    private Comparator<Movie> cmp;

    /**
     * Compares two movies
     * 
     * @param a Movie A
     * @param b Movie B
     */
    public int compare(Movie a, Movie b) {
        return cmp.compare(a, b);
    }

    /**
     * Movie comparator
     *
     * @param cmp Comparator
     */
    private MovieComparator(Comparator<Movie> cmp) {
        this.cmp = cmp;
    }

}
