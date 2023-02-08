package models;

public class ProductCart {
	
	private int productId;
	private int userId;
	private int count;
	private String title;
	private String photo;
	private double price;
	
	
	public ProductCart(int productId, int userId, int count, String title, String photo, double price) {
		this.productId = productId;
		this.userId = userId;
		this.count = count;
		this.title = title;
		this.photo = photo;
		this.price = price;
	}
	
	public int getProductId() {
		return productId;
	}
	public int getUserId() {
		return userId;
	}
	public int getCount() {
		return count;
	}
	public String getTitle() {
		return title;
	}
	public String getPhoto() {
		return photo;
	}
	public double getPrice() {
		return price;
	}

}
