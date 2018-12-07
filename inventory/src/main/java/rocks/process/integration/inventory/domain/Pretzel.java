package rocks.process.integration.inventory.domain;

import java.util.List;


public class Pretzel {

	private Long pretzelId;
	private String name;

	private int stockAmount;
	private double price;
	

	private List<Orders> orders;


	public void setPretzelId(Long pretzelId) {
		this.pretzelId = pretzelId;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Long getPretzelId() {
		return pretzelId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getStockAmount() {
		return stockAmount;
	}
	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
