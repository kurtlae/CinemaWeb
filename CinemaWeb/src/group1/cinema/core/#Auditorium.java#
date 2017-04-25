package group1.cinema.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

/**
 * Cinema auditorium class
 */
public class Auditorium extends StoredObject {

    /**
     * Table name
     */
    public static final String TABLE_NAME = "auditorium";

    /**
     * Seat table name
     */
    public static final String SEAT_TABLE_NAME = "auditorium_seat";

    /**
     * Auditorium seats
     */
    private final Set<Seat> seats = new HashSet<>();

    /**
     * Screening schedule
     */
    private final List<Screening> schedule = new ArrayList<>();

    /**
     * Seats lock object
     */
    private final Object seatsLock = new Object();

    /**
     * Schedule lock object
     */
    private final Object scheduleLock = new Object();

    /**
     * Auditorium name
     */
    private String name;

    /**
     * Returns true if the auditorium has scheduled the given screening
     * 
     * @param screening Screening
     * @return True if the auditorium has scheduled the screening, otherwise
     *         false
     */
    public boolean hasScreening(Screening screening) {
        return schedule.contains(screening);
    }

    /**
     * Searches for a given predicate within all the active screenings
     * 
     * @param predicate Filtering predicate
     * @return Matched results
     */
    public List<Screening> find(BiPredicate<Auditorium, Screening> predicate) {
        final List<Screening> result = new ArrayList<>();

        for (Screening screening : schedule) {
            if (predicate.test(this, screening)) {
                result.add(screening);
            }
        }

        return result;
    }

    /**
     * Attempts to schedule a screening in this auditorium, returns true on
     * success or false if the screening would overlap another screening
     * 
     * @param screening Screening to schedule
     * @return True on success, false if the screening overlaps another
     *         screening
     */
    public boolean scheduleScreening(Screening screening) {
        synchronized (scheduleLock) {
            if (schedule.contains(screening)) {
                return false;
            }

            boolean isOverlapping = false;

            for (Screening current : schedule) {
                if (screening.isOverlapping(current)) {
                    isOverlapping = true;
                }
            }

            if (!isOverlapping) {
                return schedule.add(screening);
            } else {
                return false;
            }
        }
    }

    /**
     * Attempts to cancels a screening in this auditorium, returns true on
     * success or false if the screening was not found
     * 
     * @param screening Target screening
     * @return True on success, false if the screening was not found
     */
    public boolean cancelScreening(Screening screening) {
        synchronized (scheduleLock) {
            return schedule.remove(screening);
        }
    }

    /**
     * Gets the auditorium seats
     * 
     * @return Auditorium seats
     */
    public Set<Seat> getSeats() {
        synchronized (seatsLock) {
            return new HashSet<>(seats);
        }
    }

    /**
     * Gets the auditorium schedule
     * 
     * @return Auditorium schedule
     */
    public List<Screening> getSchedule() {
        synchronized (scheduleLock) {
            return new ArrayList<>(schedule);
        }
    }

    /**
     * Gets the auditorium name
     * 
     * @return Auditorium name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the auditorium seats
     * 
     * @param seats Seats
     */
    public void setSeats(List<Seat> seats) {
        synchronized (seatsLock) {
            this.seats.clear();
            this.seats.addAll(seats);
        }
    }

    /**
     * Sets the auditorium schedule
     * 
     * @param schedule Auditorium schedule
     */
    public void setSchedule(List<Screening> schedule) {
        synchronized (scheduleLock) {
            this.schedule.clear();
            this.schedule.addAll(schedule);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Auditorium [id=" + getId() + ", seats=" + seats + ", schedule=" + schedule + ", name=" + name + "]";
    }

    /*
     * (non-Javadoc)
     * 
     * @see group1.cinema.core.StoredObject#StoredObject(int)
     */
    public Auditorium(int id) {
        super(id);
    }

    /**
     * Auditorium
     * 
     * @param name Auditorium names
     */
    public Auditorium(String name) {
        this.name = name;
    }

}
