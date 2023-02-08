package models;

public class Product {
	
	private int id;
	private String title;
	private String info;
	private String photo;
	private double price;
	
	/**
	 * @param id - id продукта
	 * @param title - наименование продукта
	 * @param info - информация о продукте
	 * @param photo - имя файла с фотографией продукта
	 * @param prise - цена продукта
	 */
	public Product(int id, String title, String info, String photo, double price) {
		this.id = id;
		this.title = title;
		this.info = info;
		this.photo = photo;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getInfo() {
		return info;
	}

	public String getPhoto() {
		return photo;
	}

	public double getPrice() {
		return price;
	}
/*
	@Override
	public String toString() {
		return title + " стоит "+ price;
	}
*/

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", info=" + info + ", photo=" + photo + ", price=" + price
				+ "]";
	}
	
	
	
	

}
