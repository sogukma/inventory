package rocks.process.integration.inventory.domain;

import java.util.Date;





public class Orders {

	private Long ordersId;
	private String status;
	private double totalCost;
	private String orderDate;
	public Long getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}
	private int amount;
	


	private Customer customer; 

	private Pretzel pretzel;
	
	
	public Pretzel getPretzel() {
		return pretzel;
	}
	public void setPretzel(Pretzel pretzel) {
		this.pretzel = pretzel;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public Long getOrderId() {
		return ordersId;
	}
	public void setOrderId(Long orderId) {
		this.ordersId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String string) {
		this.orderDate = string;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
