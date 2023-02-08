package models;

import java.sql.Date;

public class Order {
	
	int id;
	int user_id;
	String login;
	Date date;
	int status;
	double total;
	
	
	public Order(int id, int user_id, String login, Date date, int status,double total) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.login = login;
		this.date = date;
		this.status = status;
		this.total = total;
	}
	
	public int getId() {
		return id;
	}
	public int getUser_id() {
		return user_id;
	}
	
	public String getLogin() {
		return login;
	}
	public Date getDate() {
		return date;
	}
	public int getStatus() {
		return status;
	}
	
	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", login=" + login + ", date=" + date + ", status=" + status
				+ ", total=" + total + "]";
	}




}
