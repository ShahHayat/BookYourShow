package com.makhdoom.BookYourShow.services;

import com.makhdoom.BookYourShow.dtos.CreateCustomerRequestDTO;
import com.makhdoom.BookYourShow.exceptions.CustomerNotFoundException;
import com.makhdoom.BookYourShow.exceptions.EmailAlreadyExistsException;
import com.makhdoom.BookYourShow.models.Customer;
import com.makhdoom.BookYourShow.models.User;
import com.makhdoom.BookYourShow.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private UserService userService;

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer createCustomer(CreateCustomerRequestDTO request) {
        Optional<Customer> existingCustomer = customerRepository.findCustomerByEmail(request.getEmail());
        if (existingCustomer.isPresent()) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        User user = userService.createUser(request.getUsername(), request.getPassword());
        Customer customer = Customer.builder()
                .city(request.getCity())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .fullName(request.getFullName())
                .user(user)
                .build();

        return customerRepository.save(customer);
    }

    public Customer getCustomerInternal(Long userId) {
        return customerRepository.findById(userId).orElse(null);
    }
}
