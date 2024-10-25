package model;

public class Product {

	private int productId;
	    private String productName;
	    @SuppressWarnings("unused")
		private String category;
	    private String model;
	    private int claimLeft;
	    private int UserID;
	    private String serialNo;
	    private String purchaseDate;

		
		  public Product(int productId, String productName, String category, String model
				  , String serialNo, String purchaseDate) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.category = category;
			this.model = model;
			this.serialNo = serialNo;
			this.purchaseDate = purchaseDate;
		}
		  public Product() {
				// TODO Auto-generated constructor stub
			}
			

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public String getCategory() {
		return model;
	}
	
	public void setCategory(String model) {
		this.model = model;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public int getClaimsLeft() {
		return claimLeft;
	}

	public void setClaimsLeft(int claimsLeft) {
		this.claimLeft = claimsLeft;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}

}
