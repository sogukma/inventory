package rocks.process.integration.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;






@Entity
public class PickingList {

	@Id
	@GeneratedValue
	private Long pickingId;
	private String packingSlipId;
	private Long customerId;
	private String orderId;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	
	public PickingList(Customer customer, String orderId, String packingSlipId, String status)
	{
		this.customerId = customer.getCustomerId();
		this.orderId = orderId;
		this.packingSlipId = packingSlipId;
		this.status = status;
	}





	public Long getPickingId() {
		return pickingId;
	}

	public void setPickingListId(Long pickingId) {
		this.pickingId = pickingId;
	}

	public String getPackingSlipId() {
		return packingSlipId;
	}

	public void setPackingSlipId(String packingSlipId) {
		this.packingSlipId = packingSlipId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	
	
}
