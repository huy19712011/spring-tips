package dev.cat.customer.service;

import dev.cat.customer.dto.CustomerResponse;
import dev.cat.customer.entity.Customer;
import dev.cat.customer.mapper.CustomerMapper;
import dev.cat.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerResponse> findAll() {

        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::mapToCustomerResponse)
                .toList();
    }

    public CustomerResponse findById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new RuntimeException();  // for the simplicity sake! Handle exceptions properly in real world
        }

        return customerMapper
                .mapToCustomerResponse(customer.get());
    }

}





