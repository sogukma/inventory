package rocks.process.integration.inventory.api;

import java.net.URI;
import java.util.UUID;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import rocks.process.integration.inventory.business.service.InventoryService;
import rocks.process.integration.inventory.domain.OrderMessage;
import rocks.process.integration.inventory.domain.PickingList;


@RestController
@RequestMapping(path = "/api")
public class InventoryEndpoint {
    @Autowired
    private InventoryService inventoryService;


    @PostMapping(path = "/inventory", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderMessage> requestInventory(@RequestBody OrderMessage orderMessage) {
        PickingList pickingList = null;
        String packingSlipId = UUID.randomUUID().toString();

        //wenn auf Lager vorhanden, kommissioniere sonst setze auftrag in queue
        try {
            String status = "";
        	if(Integer.parseInt(orderMessage.getStockAmount()) < 0)
        	{
        		status = "in queue";
        	}
        	else{ 
        		status = "picked";
        		orderMessage.setStatus("Picking Finished");
                orderMessage.setPackingSlipId(packingSlipId);
    		};
    		pickingList = inventoryService.processInventory(Long.parseLong(orderMessage.getCustomerId()), orderMessage.getOrderId(), packingSlipId, status );
        
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getConstraintViolations().iterator().next().getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

     
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{packingSlipId}")
                .buildAndExpand(pickingList.getPackingSlipId()).toUri();

        return ResponseEntity.created(location).body(orderMessage);
    }

   
}
