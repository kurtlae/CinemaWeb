package group1.cinema;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import group1.cinema.core.Cinema;
import group1.cinema.storage.Database;
import group1.cinema.storage.Storage;

/**
 * Tester class
 * 
 * @author Emil Bertilsson
 */
public class Tester {

    /**
     * Cinema object
     */
    private Cinema cinema;

    /**
     * Runs the tester
     */
    public void run() {
    }

    /**
     * Cinema tester
     * 
     * @param cinema Cinema instance
     */
    public Tester(Cinema cinema) {
        this.cinema = cinema;
    }

}
