package models;

public class OrderProduct {
	
	int order_id;
	int status;
	int product_id;
	String email;
	String title;
	String login;
	int count;
	double price;
	
	public OrderProduct(int order_id, int status, int product_id, String title, String email, String login, int count, double price) {
		this.order_id = order_id;
		this.status = status;
		this.product_id = product_id;
		this.title = title;
		this.email = email;
		this.login = login;
		this.count = count;
		this.price = price;
	}

	public int getOrder_id() {
		return order_id;
	}

	public int getStatus() {
		return status;
	}
	public int getProduct_id() {
		return product_id;
	}

	public String getTitle() {
		return title;
	}

	public String getEmail() {
		return email;
	}
	
	public String getLogin() {
		return login;
	}

	public int getCount() {
		return count;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "OrderProduct [order_id=" + order_id + ", status=" + status + ", product_id=" + product_id + ", email="
				+ email + ", title=" + title + ", login=" + login + ", count=" + count + ", price=" + price + "]";
	}




	
	
	

}
