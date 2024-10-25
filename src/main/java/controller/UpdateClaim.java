package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ClaimChanges;
import dbHelpers.ReadAdmin;
import model.Claim;
/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/UpdateClaim")
public class UpdateClaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClaim() {
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
		int claimId = Integer.parseInt(request.getParameter("claimId"));
        String approvalDate = request.getParameter("approvalDate");
        String rejectionReason = request.getParameter("rejectionReason");
        String status = request.getParameter("status");
        ClaimChanges newClaim= new ClaimChanges();
        try {
            // Update the claim in the database
            newClaim.updateClaim(claimId, approvalDate, rejectionReason,status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ReadAdmin readClaimHelper = new ReadAdmin();
        List<Claim> claims;
		try {
			claims = readClaimHelper.doReadClaims();
			request.setAttribute("claims", claims);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        request.getRequestDispatcher("claimsList.jsp").forward(request, response);
    }

}
