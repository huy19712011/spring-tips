package dev.cat.customer.mapper;

import dev.cat.customer.dto.CustomerResponse;
import dev.cat.customer.entity.Customer;
import dev.cat.customer.entity.Order;
import dev.cat.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class CustomerMapperTest {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerRepository customerRepository;


    @Test
    public void shouldMapToCustomerResponseCorrectly() {

        Customer customer = customerRepository.findById(1L).get();

        double actualTotalExpenses = customer.getOrders()
                .stream()
                .map(Order::getTotalPrice)
                .reduce(0.0, Double::sum);

        CustomerResponse response = customerMapper.mapToCustomerResponse(customer);

        Assertions.assertEquals(customer.getName(), response.name());
        Assertions.assertEquals(response.totalExpenses(), actualTotalExpenses);
    }

}