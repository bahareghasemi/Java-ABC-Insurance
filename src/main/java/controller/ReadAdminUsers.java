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

import dbHelpers.ReadAdmin;
import model.User;

/**
 * Servlet implementation class UserDashboard
 */
@WebServlet("/ReadAdminUsers")
public class ReadAdminUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadAdminUsers() {
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
	    
		RequestDispatcher rd = null;
	    
	    ReadAdmin ru = new ReadAdmin();
		try {
			List<User> users = ru.doReadAllUsers();
			request.setAttribute("users", users);
			session.setAttribute("users",users);
			String url = "/userList.jsp";
			
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
	        
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
