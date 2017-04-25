package group1.cinema.core;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Movie screening class
 */
public class Screening extends StoredObject {

    /**
     * Table name
     */
    public static final String TABLE_NAME = "screening";

    /**
     * Booked seats
     */
    private final Set<Seat> seats = new HashSet<>();

    /**
     * The movie that is played at the screening
     */
    private Movie activeMovie;

    /**
     * Screening entry price
     */
    private int price;

    /**
     * Time that the screening will begin
     */
    private ZonedDateTime startTime;

    /**
     * Time that the screening will end
     */
    private ZonedDateTime endTime;

    /**
     * Seats lock
     */
    private final Object seatsLock = new Object();

    /**
     * Attempts to book a seat in the screening, returns true on success, false
     * if the seat is already booked or throws an exception if the seat was not
     * found
     * 
     * @param row Target row
     * @param col Target column
     * @return True if the seat was succesfully booked, false if the seat was
     *         already booked
     * @throws RuntimeException Thrown if the seat was not found
     */
    public boolean bookSeat(int row, int col) throws RuntimeException {
        synchronized (seatsLock) {
            for (Seat seat : seats) {
                if (seat.getRow() == row && seat.getCol() == col) {
                    if (seat.isAvailable()) {
                        seat.setAvailable(false);
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            throw new RuntimeException("Seat not found");
        }
    }

    /**
     * Attempts to cancel a booked seat in the screening, returns false if the
     * seat is not booked
     * or throws an exception if the seat was not found
     * 
     * @param row Target row
     * @param col Target column
     * @return True if the booked seat was succesfully canceled, false if the
     *         seat was not booked
     * @throws RuntimeException Thrown if the seat was not found
     */
    public boolean cancelSeat(int row, int col) throws RuntimeException {
        synchronized (seatsLock) {
            for (Seat seat : seats) {
                if (seat.getRow() == row && seat.getCol() == col) {
                    if (!seat.isAvailable()) {
                        seat.setAvailable(true);
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            throw new RuntimeException("Seat not found");
        }
    }

    /**
     * Tests if a screening overlaps with this screening
     * 
     * @param screening Screening to test
     * 
     * @return True if the screening overlaps with this screening, otherwise
     *         false
     */
    public boolean isOverlapping(Screening screening) {
        return ((getStartTime().compareTo(screening.getStartTime()) >= 0
                && getStartTime().compareTo(screening.getEndTime()) <= 0)
                || (getEndTime().compareTo(screening.getStartTime()) >= 0
                        && getEndTime().compareTo(screening.getEndTime()) <= 0)
                || (getStartTime().isBefore(screening.getStartTime())
                        && this.getEndTime().isAfter(screening.getEndTime())));
    }

    /**
     * Gets the screening seats
     * 
     * @return Screening seats
     */
    public Set<Seat> getSeats() {
        synchronized (seatsLock) {
            return new HashSet<>(seats);
        }
    }

    /**
     * Gets the active movie of the screening
     * 
     * @return Active movie
     */
    public Movie getActiveMovie() {
        return activeMovie;
    }

    /**
     * Gets the price of the screening
     * 
     * @return Screening price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the screening
     * 
     * @param price New price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets the start time of the screening
     * 
     * @return Start time
     */
    public ZonedDateTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the screening
     * 
     * @param startTime New start time
     */
    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time of the screening
     * 
     * @return End time
     */
    public ZonedDateTime getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of the screening
     * 
     * @param endTime New end time
     */
    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Checks if a seat is avilable, returns true if available, false if the
     * seat is unavailable or an exception if the seat was not found
     * 
     * @param row Target row
     * @param col Target column
     * @return True if the seat is available, otherwise false
     * @throws RuntimeException Thrown if the seat was not found
     */
    public boolean isSeatAvailable(int row, int col) throws RuntimeException {
        boolean isInScreening = false;
        boolean isAvailable = false;

        synchronized (seatsLock) {
            for (Seat seat : seats) {
                if (seat.getRow() == row && seat.getCol() == col) {
                    isInScreening = true;
                    isAvailable = seat.isAvailable();
                }
            }
        }

        if (!isInScreening) {
            throw new RuntimeException("Seat not found");
        }

        return isAvailable;
    }

    /**
     * Checks if there are seats available, returns true if there are available
     * seats, false if there are no available seats
     * 
     * @return True if there are available seats, otherwise false
     */
    public boolean hasAvailableSeats() {
        synchronized (seatsLock) {
            for (Seat seat : seats) {
                if (seat.isAvailable()) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Screening [id=" + getId() + ", seats=" + seats + ", activeMovie=" + activeMovie + ", price=" + price
                + ", startTime="
                + startTime + ", endTime=" + endTime + "]";
    }

    /*
     * (non-Javadoc)
     * 
     * @see group1.cinema.core.StoredObject#StoredObject(int)
     */
    public Screening(int id) {
        super(id);
    }

    /**
     * Screening
     * 
     * @param id ID
     * @param movie Active movie
     * @param price Price
     * @param startTime Start time
     * @param endTime End time
     */
    public Screening(Movie movie, int price, ZonedDateTime startTime, ZonedDateTime endTime) {
        this.activeMovie = movie;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
