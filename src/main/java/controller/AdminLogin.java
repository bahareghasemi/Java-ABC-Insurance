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

import dbHelpers.Authenticator;
import dbHelpers.ReadUser;
import model.User;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		// get Login Details
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 
		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticateAdmin(username, password);
		if (result.equals("success")) {
			List<User> users = null;

			try {
				ReadUser readUserHelper = new ReadUser();

				// Fetch all users
				users = readUserHelper.doReadAllUsers();

				// Set the list of users in the request
				request.setAttribute("users", users);

			rd = request.getRequestDispatcher("/adminDashboard.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "Database error occurred.");
				rd = request.getRequestDispatcher("/adminLogin.jsp");
			} finally {
				
			}
		
		} else {
			String errorMsg = "<p>Admin Username or Password Incorrect!</p>";
		
			rd = request.getRequestDispatcher("/adminLogin.jsp");
			
			request.setAttribute("errorMsg", errorMsg);
		}
		rd.forward(request, response);
	}

}
