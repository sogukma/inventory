/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.integration.inventory.business.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import rocks.process.integration.inventory.domain.Customer;



@Component
public class CustomerServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    public Customer retrieveCustomerById(Long customerId) {
        return restTemplate.getForObject("https://camel.herokuapp.com/customer/"  + customerId, Customer.class);
    }


}
