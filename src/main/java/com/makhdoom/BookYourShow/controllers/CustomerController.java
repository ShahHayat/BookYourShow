package com.makhdoom.BookYourShow.controllers;

import com.makhdoom.BookYourShow.dtos.CreateCustomerRequestDTO;
import com.makhdoom.BookYourShow.exceptions.InvalidCustomerException;
import com.makhdoom.BookYourShow.models.Customer;
import com.makhdoom.BookYourShow.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("")
    public Customer createCustomer(@RequestBody CreateCustomerRequestDTO request) {
        validate(request);
        return customerService.createCustomer(request);
    }

    private void validate(CreateCustomerRequestDTO request) {
        if (request.getEmail() == null) {
            throw new InvalidCustomerException();
        }
    }
}
