package javabeans;

import java.util.HashMap;

public class command {
	private int id;
	private int userId;
	private HashMap<shoeus,Integer> shoeuscmd;
	private double totalPrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public HashMap<shoeus,Integer> getCommandShoeus() {
		return shoeuscmd;
	}
	public void addShoeus(shoeus shoeus, int qty) {
		shoeuscmd.put(shoeus, qty);
	}
	public void removeShoeus(shoeus shoeus, int qty) {
		shoeuscmd.remove(shoeus, qty);
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
