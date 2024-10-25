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

import dbHelpers.Authenticator;
import dbHelpers.ReadUser;
import model.User;
import model.Product;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get User Login Details
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				RequestDispatcher rd = null;
		 
				Authenticator authenticator = new Authenticator();
				String result = authenticator.authenticateUser(username, password);
				if (result==null) return;
				if (result.equals("success")) {
					ReadUser ru = new ReadUser();
					try {
						User currentUser = ru.doReadUserInfo(username);
						int userId = currentUser.getUserId();
						System.out.println(userId);
				        HttpSession session = request.getSession();
			            session.setAttribute("userId", userId);
			            session.setAttribute("username", username);
			            
						List<Product> registeredProducts = ru.doReadUserProducts(username);
						request.setAttribute("registeredProducts", registeredProducts);
				        				        
					} catch (SQLException e) {
					e.printStackTrace();
					}
					rd = request.getRequestDispatcher("/userDashboard.jsp");
				
				} else {
					String errorMsg = "<p>Username or Password Incorrect!</p>";
					rd = request.getRequestDispatcher("/user.jsp");
					request.setAttribute("errorMsg", errorMsg);
				}
				rd.forward(request, response);
			}
}
