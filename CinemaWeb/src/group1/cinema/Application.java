package group1.cinema;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import group1.cinema.core.Cinema;
import group1.cinema.storage.Database;
import group1.cinema.storage.Storage;

/**
 * Application main class
 *
 * @author Group 1
 */
public class Application {

    /**
     * Main method
     * 
     * @param args CLI Arguments
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    /**
     * Application instance main method
     */
    public void run() {
        Cinema cinema = Cinema.singleton();

        try {
            Database.connect();
            System.out.println("Connected to database successfully!");

            try {
                Storage.useConnection(Database.getConnection());
                cinema.setContent(
                        Storage.retrieveMovieCollection(),
                        Storage.retrieveAuditoriumCollection(true));

                cinema.loadScreenings();

                System.out.printf("Successfully loaded cinema content! %d movie entries, %d auditorium entries%n",
                        cinema.movieCount(), cinema.auditoriumCount());
            } catch (SQLSyntaxErrorException e) {
                System.err.println(Database.generateErrorMsg(e, "Could not load cinema content"));
            } catch (SQLException e) {
                System.err.println(Database.generateErrorMsg(e, "Could not load cinema content"));
            }

            Tester tester = new Tester(cinema);
            tester.run();
        } catch (SQLSyntaxErrorException e) {
            System.err.println(Database.generateErrorMsg(e, "Syntax error"));
        } catch (SQLException e) {
            System.err.println(Database.generateErrorMsg(e, "Could not connect to the database"));
            return;
        } finally {
            try {
                Database.close();
            } catch (SQLException e) {
                System.err.println(Database.generateErrorMsg(e, "Could not close the connection"));
            }
        }
    }

}
