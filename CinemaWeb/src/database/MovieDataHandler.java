package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book.Book;
import group1.cinema.core.Movie;

public class MovieDataHandler {

    static String user = "root";
    static String password = "root";
    static String dbUri = "jdbc:mysql://localhost:3306/CinemaWeb?useSSL=false";
 
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dbUri, user, password);
    }
        
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MovieDataHandler md = new MovieDataHandler();
        Connection conn = null;

        try {
            conn = md.getConnection();
            System.out.println("conn succeeded");
        } catch (SQLException e) {
            System.out.println("Errol " + e.getMessage());
        } finally {
            if (conn != null)
                conn.close();
        }
    }
    
    public List<Movie> getMovies() throws ClassNotFoundException, SQLException {
        List<Movie> movies = new ArrayList<Movie>();

        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT id, title FROM cinema");
                ResultSet rs = pstmt.executeQuery();) {
            
            while (rs.next()) {
                Movie m = new Movie(1);
                m.setId(rs.getInt("id"));
                m.getTitle();

                movies.add(m);
            }
            return movies;
        }
    }
}
