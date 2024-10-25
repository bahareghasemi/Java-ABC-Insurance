package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddProduct;
import model.ProductLists;

/**
 * Servlet implementation class RegisterProduct
 */
@WebServlet("/AddAdminProduct")
public class AddAdminProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminProduct() {
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
        String category = request.getParameter("category");
        
        System.out.println("This is product name: " + productname);
        
        
        // Create a new Product object
        ProductLists product = new ProductLists();
        product.setProductName(productname);
        product.setModel(category);
        
        
        AddProduct newProduct = new AddProduct();
        RequestDispatcher rd = null;
        
		// Call the AddUser helper method to add the user to the database
        try {
			int rowsAffected = newProduct.doAddProduct(product);
			
		      if (rowsAffected > 0) {
		    	  System.out.println("Product added successfully");
		    	  rd = request.getRequestDispatcher("/adminDashboard.jsp");
	            } else {
	            	System.out.println("registration failed");
	            }
		      rd = request.getRequestDispatcher("/adminDashboard.jsp");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        rd.forward(request, response);
    }
	

}
