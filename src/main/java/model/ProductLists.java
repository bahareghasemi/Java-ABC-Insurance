package model;

public class ProductLists {
	
	private int productId;
    private String productName;
    private String model;
    
	
	  public ProductLists(int productId, String productName, String model) {
		super();
		this.setProductId(productId);
		this.setProductName(productName);
		this.setModel(model);
	}
	  public ProductLists() {
			// TODO Auto-generated constructor stub
		}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}


}
