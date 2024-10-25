package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.AddClaim;
import model.Claim;

/**
 * Servlet implementation class SubmitClaim
 */
@WebServlet("/SubmitClaim")
public class SubmitClaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitClaim() {
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

        String product_name = request.getParameter("product_name");
        int regId = Integer.parseInt(request.getParameter("reg_Id"));
        String description = request.getParameter("issue");

        
        System.out.println("This is product name: " + product_name);
	        
	        LocalDate dateOfClaim = LocalDate.now();
	        String status = "pending";
	        LocalDate approvalDate = null;
	        String rejectionReason = null;
	        HttpSession session = request.getSession();
	        int userId = (int) session.getAttribute("userId");

	        Claim newClaim = new Claim();
	        
	        newClaim.setProductId(regId);
	        newClaim.setUser(userId);
	        newClaim.setDateOfClaim(dateOfClaim);
	        newClaim.setDescription(description);
	        newClaim.setStatus(status);
	        newClaim.setApprovalDate(approvalDate);
	        newClaim.setRejectionReason(rejectionReason);

	        AddClaim ac = new AddClaim();

	        try {
	            ac.addClaim(newClaim);
	            System.out.println("Claim added successfully");
	            response.sendRedirect("userDashboard.jsp");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle database error
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        }
	    }
		
	

}
