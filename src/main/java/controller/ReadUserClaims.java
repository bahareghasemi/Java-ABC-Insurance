package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.ReadUser;
import model.Claim;

/**
 * Servlet implementation class ReadUserClaims
 */
@WebServlet("/ReadUserClaims")
public class ReadUserClaims extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadUserClaims() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Get userId from session 
	    HttpSession session = request.getSession();
	    int userId = (int) session.getAttribute("userId");
	    
		RequestDispatcher rd = null;
	    
	    ReadUser ru = new ReadUser();
		try {
			List<Claim> claims = ru.doReadUserClaims(userId);
		    request.setAttribute("claims", claims);
	        
	        String url = "/claimlist.jsp";
			
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
	        
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	}

}
