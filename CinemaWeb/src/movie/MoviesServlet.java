package movie;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group1.cinema.core.*;
import group1.cinema.storage.Storage;

/**
 * Servlet implementation class FilmServlet
 */
@WebServlet("/Movies")
public class MoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	    Storage s = null;
	    List<Movie> listan = null;
	    
	    try {
            s = new Storage();
        } catch (ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("Error: "+ e1.getMessage());
            //e1.printStackTrace();
        }
	            
        try {
            listan = s.retrieveMovieCollection();
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        request.setAttribute("movie", listan);
        request.getRequestDispatcher("/WEB-INF/movies.jsp").forward(request, response);

//        response.setContentType("text/html");
//        response.getWriter().write("Size: " +listan.toString());
//        response.getWriter().append("Kurt provar Served at: ").append(request.getContextPath());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
