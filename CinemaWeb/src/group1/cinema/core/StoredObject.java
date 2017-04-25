package group1.cinema.core;

/**
 * Stored object class
 * 
 * @author Emil Bertilsson
 */
public abstract class StoredObject {

    /**
     * Item ID
     */
    private int id;

    /**
     * Gets the stored object's ID
     *
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the stored object's ID
     *
     * @param id ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Empty constructor
     */
    public StoredObject() {
    }

    /**
     * Empty constructor where ID is provided, only used to create empty objects
     * and retrieve data later
     * 
     * @param id ID
     */
    public StoredObject(int id) {
        this.id = id;
    }

}
