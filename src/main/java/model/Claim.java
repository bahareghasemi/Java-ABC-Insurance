package model;

import java.time.LocalDate;

public class Claim {
	
	 private int claimId;
	    private int ProductId;
	    private String productName;
	    private LocalDate dateOfClaim;
	    private String description;
	    private String status;
	    private LocalDate approvalDate;
	    private String rejectionReason;
		private int UserID;

	public Claim() {
		// TODO Auto-generated constructor stub
	}
	
	   // Constructor with parameters
    public Claim(int claimId, int userId, int ProductId, String product_name, LocalDate dateOfClaim, String description, String status, LocalDate approvalDate, String rejectionReason) {
        this.claimId = claimId;
        this.ProductId= ProductId;
        this.productName = product_name;
        this.dateOfClaim = dateOfClaim;
        this.description = description;
        this.status = status;
        this.approvalDate = approvalDate;
        this.rejectionReason = rejectionReason;
    }

    // Getters and setters for all attributes
    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public int getUser() {
        return UserID;
    }

    public void setUser(int user) {
        this.UserID = user;
    }

    public LocalDate getDateOfClaim() {
        return dateOfClaim;
    }

    public void setDateOfClaim(LocalDate dateOfClaim) {
        this.dateOfClaim = dateOfClaim;
    }
    
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	
    

}
