package rocks.process.integration.inventory.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rocks.process.integration.inventory.business.client.CustomerServiceClient;
import rocks.process.integration.inventory.domain.Customer;
import rocks.process.integration.inventory.domain.PickingList;
import rocks.process.integration.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CustomerServiceClient customerService;



    public PickingList processInventory(Long customerId, String orderId, String packingSlipId, String status) throws Exception {

    	Customer customer = customerService.retrieveCustomerById(customerId);
      
       PickingList pickingList = new PickingList(customer, orderId, packingSlipId, status);

       
        inventoryRepository.save(pickingList);
        return pickingList;
    }
}