package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbHelpers.ReadUser;
import model.User;
import model.Claim;
import model.Product;

@WebServlet("/userDetails")
public class UserDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadUser readUserHelper = new ReadUser();
        List<User> users = null;
        List<Product> products = null;
        List<Claim> claims = null;

        try {
            // Fetch all users
            users = readUserHelper.doReadAllUsers();
            System.out.println("Number of users fetched: " + (users != null ? users.size() : 0));
            
            // Check if a specific user is selected
            String userIdParam = request.getParameter("userId");
            if (userIdParam != null) {
                int userId = Integer.parseInt(userIdParam);
                
                // Fetch and set user details
                User selectedUser = readUserHelper.doReadUserInfoById(userId);
                products = readUserHelper.doReadUserProducts(selectedUser.getUsername());
                claims = readUserHelper.doReadUserClaims(userId);

                request.setAttribute("products", products);
                request.setAttribute("claims", claims);
            }

            // Set the list of users in the request
            request.setAttribute("users", users);

            // Forward the request to the JSP page
            request.getRequestDispatcher("/adminUserDetails.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error occurred", e);
        }
    }
}
