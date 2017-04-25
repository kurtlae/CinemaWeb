package auditorium.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group1.cinema.core.Auditorium;
import group1.cinema.storage.Database;
import group1.cinema.storage.Storage;

/**
 * Servlet implementation class getAuditoriumServlet
 */
@WebServlet("/GetAuditoriums")
public class GetAuditoriumsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAuditoriumsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    //Storage st = new Storage();
	    String tmp ="";
	    try {
            Storage.useConnection(Database.getConnection());
	        List<Auditorium> auditLista = Storage.retrieveAuditoriumCollection(false);
	        for(Auditorium a : auditLista){
	            tmp+=a.getName() +" : ";
	            
	            request.setAttribute("auditoriums", auditLista);
	            request.getRequestDispatcher("/WEB-INF/auditoriums/auditoriums.jsp").forward(request, response);

	        }
	        
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            response.getWriter().println("Error "+e.getMessage());
            //e.printStackTrace();
        }
	    
	    
		response.getWriter().append(tmp +  "   Mats Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
