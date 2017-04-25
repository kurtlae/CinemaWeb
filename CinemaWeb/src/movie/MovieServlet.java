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
@WebServlet("/Movie")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	    Storage s = null;
	    Movie film = null;
        String mid = request.getParameter("id");
        int mint = 0;
            mint = Integer.parseInt(mid);

    
	    try {
            s = new Storage();
        } catch (ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("Error: "+ e1.getMessage());
            //e1.printStackTrace();
        }
	
        try {
            film = s.retrieveMovie(mint);
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        request.setAttribute("movie", film);
        request.getRequestDispatcher("/WEB-INF/movie.jsp").forward(request, response);

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
