package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.AddUserProduct;
import model.Product;

/**
 * Servlet implementation class RegisterProduct
 */
@WebServlet("/RegisterProduct")
public class RegisterProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterProduct() {
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
		
        String productname = request.getParameter("product-name");
        String serial_no = request.getParameter("serial-no");
        String category = request.getParameter("category");
        String purchaseDate = request.getParameter("purchase-date");
        
        System.out.println("This is product name: " + productname);
        
        // Get userId from session (assuming it's stored in the session)
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        
        // Create a new User object
        Product product = new Product();
        product.setProductName(productname);
        product.setUserID(userId);
        product.setSerialNo(serial_no);
        product.setCategory(category);
        product.setPurchaseDate(purchaseDate);
        
        
        AddUserProduct newProduct = new AddUserProduct();
        RequestDispatcher rd = null;
        
		// Call the AddUser helper method to add the user to the database
        try {
			int rowsAffected = newProduct.doAddUserProduct(product);
			
		      if (rowsAffected > 0) {
		    	  System.out.println("user added successfully");
		    	  rd = request.getRequestDispatcher("/userDashboard.jsp");
	            } else {
	            	System.out.println("registration failed");
	            }
		      rd = request.getRequestDispatcher("/userDashboard.jsp");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        rd.forward(request, response);
    }
	

}
