package group1.cinema.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Cinema class
 *
 * @author Emil Bertilsson
 */
public class Cinema {

    /**
     * Date formatter
     */
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    /**
     * Cinema singleton instance
     */
    private static Cinema instance;

    /**
     * Available movies
     */
    private transient final Set<Movie> movies = new HashSet<>();

    /**
     * Cinema auditoriums
     */
    private final Set<Auditorium> auditoriums = new HashSet<>();

    /**
     * Movie list lock
     */
    private final Object moviesLock = new Object();

    /**
     * Auditorium list lock
     */
    private final Object auditoriumsLock = new Object();

    /**
     * Creates or gets the singleton instance of the cinema
     * 
     * @return Cinema singleton
     */
    public static Cinema singleton() {
        if (instance == null) {
            instance = new Cinema();
        }

        return instance;
    }

    /**
     * Searches for a given predicate within all the active screenings
     * 
     * @param predicate Filtering predicate
     * @return Matched results
     */
    public List<CinemaSearchResult> find(BiPredicate<Auditorium, Screening> predicate) {
        final List<CinemaSearchResult> result = new ArrayList<>();

        for (Auditorium auditorium : auditoriums) {
            if (predicate.test(auditorium, null)) {
                result.add(new CinemaSearchResult(auditorium, null));
            } else {
                final List<Screening> screenings = auditorium.find(predicate);

                for (Screening screening : screenings) {
                    result.add(new CinemaSearchResult(auditorium, screening));
                }
            }
        }

        return result;
    }
    
    

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Cinema [movies=" + movies + ", auditoriums=" + auditoriums + "]";
    }

    /**
     * Searches for a given predicate within all the stored movies
     * 
     * @param predicate Filtering predicate
     * @return Matched results
     */
    public List<Movie> findMovies(Predicate<Movie> predicate) {
        return movies.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
    
    public List<Movie> getAllMovies() {
        return movies.stream().collect(Collectors.toList());
    }

    /**
     * Finds a single movie within the stored movies
     * 
     * @param id Movie ID
     * @return Found movie or null if the movie was not found
     */
    public Movie findMovie(int id) {
        return findMovies(movie -> movie.getId() == id).get(0);
    }

    /**
     * Finds a single auditorium within the stored auditoriums
     * 
     * @param id Auditorium ID
     * @return Found auditorium or null if the auditorium was not found
     */
    public Auditorium findAuditorium(int id) {
        Auditorium aud = null;

        for (Auditorium aud2 : getAuditoriums()) {
            if (aud2.getId() == id) {
                aud = aud2;
            }
        }

        return aud;
    }

    /**
     * Creates a ticket for the given screening
     * 
     * @param auditorium Target auditorium
     * @param screening Target screening
     * @param row Target row
     * @param col Target column
     * @return Created ticket
     */
    public Ticket createTicket(Auditorium auditorium, Screening screening, int row, int col) {
        return null;
    }

    /**
     * Attempts to schedule a screening in the given auditorium, returns true on
     * success, false if the screening would overlap another screening or throws
     * an exception if the auditorium is not found
     * 
     * @param auditorium Target auditorium
     * @param screening Screening to schedule
     * @return True on success, false if the screening overlaps another
     *         screening
     */
    public boolean scheduleScreening(Auditorium auditorium, Screening screening) {
        if (!auditoriums.contains(auditorium)) {
            throw new RuntimeException("Auditorium not found");
        }

        return auditorium.scheduleScreening(screening);
    }

    /**
     * Attempts to cancels a screening in this auditorium, returns true on
     * success, false if the screening was not found or throws an exception if
     * the auditorium is not found
     * 
     * @param auditorium Target auditorium
     * @param screening Target screening
     * @return True on success, false if the screening was not found
     */
    public boolean cancelScreening(Auditorium auditorium, Screening screening) {
        if (!auditoriums.contains(auditorium)) {
            throw new RuntimeException("Auditorium not found");
        }

        return auditorium.cancelScreening(screening);
    }

    /**
     * Attempts to move a screening from a given auditorium to a given
     * auditorium. Returns true on success, false if the screening would overlap
     * another screening or throws an exception if the auditorium or screening
     * is not found
     * 
     * @param screening Target screening
     * @param source Source auditorium
     * @param target Target auditorium
     * @return True on success, false if the screening could not be moved
     */
    public boolean moveScreening(Screening screening, Auditorium source, Auditorium target) {
        boolean success = true;

        // Tests if the screening could be canceled
        if ((success = source.cancelScreening(screening))) {
            success = target.scheduleScreening(screening);
        }

        return success;
    }

    /**
     * Loads the cinema content; the available movies and auditoriums
     * 
     * @param movies Movies
     * @param auditoriums Auditoriums
     */
    public void setContent(List<Movie> movies, List<Auditorium> auditoriums) {
        setMovies(movies);
        setAuditoriums(auditoriums);
    }

    /**
     * Loads the screenings to the cinema
     */
    public void loadScreenings() {
        // TODO Implement
    }

    /**
     * Gets the amount of movies in the cinema object
     * 
     * @return Movie count
     */
    public int movieCount() {
        return movies.size();
    }

    /**
     * Gets the amount of auditoriums in the cinema object
     * 
     * @return Auditorium count
     */
    public int auditoriumCount() {
        return auditoriums.size();
    }

    /**
     * Gets this cinema's movie list
     *
     * @return Movie list
     */
    public Set<Movie> getMovies() {
        synchronized (moviesLock) {
            return movies;
        }
    }

    /**
     * Gets this cinema's auditoriums
     *
     * @return Auditoriums
     */
    public Set<Auditorium> getAuditoriums() {
        synchronized (auditoriumsLock) {
            return auditoriums;
        }
    }

    /**
     * Sets the movie supply
     * 
     * @param movies Movie supply
     */
    public void setMovies(List<Movie> movies) {
        synchronized (moviesLock) {
            this.movies.clear();
            this.movies.addAll(movies);
        }
    }

    /**
     * Sets the cinema auditoriums
     * 
     * @param auditoriums Auditoriums
     */
    public void setAuditoriums(List<Auditorium> auditoriums) {
        synchronized (moviesLock) {
            this.auditoriums.clear();
            this.auditoriums.addAll(auditoriums);
        }
    }

    /**
     * Prevents instantiation outside class
     */
    public Cinema() {
    }

}
