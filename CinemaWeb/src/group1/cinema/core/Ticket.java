package group1.cinema.core;

/**
 * Screening ticket class
 *
 * @author Emil Bertilsson
 */
public class Ticket {

    /**
     * Ticket ID number
     */
    private int uuid;

    /**
     * Ticket price
     */
    private int price;

    /**
     * Seat ID
     */
    private int seatId;

    /**
     * Referenced screening
     */
    private Screening screening;

    /**
     * Gets the ticket UUID
     * 
     * @return Ticket UUID
     */
    public int getUUID() {
        return uuid;
    }

    /**
     * Sets the ticket UUID
     * 
     * @param uuid New UUID
     */
    public void setUUID(int uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets the ticket price
     * 
     * @return Ticket price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the ticket price
     * 
     * @param price New price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets the seat ID
     * 
     * @return Ticket seat ID
     */
    public int getSeatId() {
        return seatId;
    }

    /**
     * Sets the seat ID
     * 
     * @param seatId New seat ID
     */
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    /**
     * Gets the ticket screening
     * 
     * @return Ticket screening
     */
    public Screening getScreening() {
        return screening;
    }

    /**
     * Sets the ticket screening
     * 
     * @param screening New screening
     */
    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    /**
     * Instantiates a new ticket with the given values
     *
     * @param price Price
     * @param seatId
     * @param screening Target screening
     */
    public Ticket(int price, int seatId, Screening screening) {
        this.price = price;
        this.seatId = seatId;
        this.screening = screening;
    }

}
