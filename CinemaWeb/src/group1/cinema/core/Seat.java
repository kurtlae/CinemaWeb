package group1.cinema.core;

/**
 * Auditorium seat class
 */
public class Seat {

    /**
     * Seat row
     */
    private int row;

    /**
     * Seat column
     */
    private int col;

    /**
     * Seat availability
     */
    private boolean available = true;

    /**
     * Gets the row of the seat
     * 
     * @return Seat row
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column of the seat
     * 
     * @return Seat column
     */
    public int getCol() {
        return col;
    }

    /**
     * Returns true if this seat is available, otherwise false
     * 
     * @return True if this seat is available, otherwise false
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the seat availability
     * 
     * @param available Seat availability
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Seat
     *
     * @param row Seat row
     * @param col Seat column
     */
    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
    }

}
