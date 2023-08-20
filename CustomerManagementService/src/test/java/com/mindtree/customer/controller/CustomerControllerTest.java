package com.mindtree.customer.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindtree.customer.entity.Customer;
import com.mindtree.customer.service.CustomerService;
import org.junit.runner.RunWith;


@SpringBootTest(classes = {CustomerControllerTest.class})
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest 
{
	
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void testRegisterCustomer() throws Exception {
        Customer customer = new Customer(); // Create a sample customer

        when(customerService.saveCustomer(any(Customer.class))).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.registerCustomer(customer);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());

        verify(customerService, times(1)).saveCustomer(any(Customer.class));
    }

    @Test
    public void testUpdateCustomer() throws JsonProcessingException {
        int customerId = 1;
        Customer customer = new Customer(); // Create a sample customer

        when(customerService.updateCustomer(any(Customer.class), eq(customerId))).thenReturn(customer);

        ResponseEntity<?> response = customerController.updateCustomer(customer, customerId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());

        verify(customerService, times(1)).updateCustomer(any(Customer.class), eq(customerId));
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 1;

        ResponseEntity<String> response = customerController.deleteCustomer(customerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Customer deleted successfully", response.getBody());

        verify(customerService, times(1)).deleteCustomerById(customerId);
    }
}

