package dev.cat.customer.mapper;
import dev.cat.customer.dto.CustomerResponse;
import dev.cat.customer.entity.Customer;
import dev.cat.customer.entity.Order;
import org.mapstruct.Mapper;

import java.util.Objects;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        componentModel = "spring")
public abstract class CustomerMapper {


    public CustomerResponse mapToCustomerResponse(Customer customer) {

        CustomerResponse.CustomerResponseBuilder response =
                CustomerResponse.builder()
                        .id(customer.getId()).name(customer.getName())
                        .email(customer.getEmail());


            response.orders(customer.getOrders()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(OrderMapper.INSTANCE::mapToOrderResponse)
                    .toList());

            response.totalExpenses(customer
                    .getOrders()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(Order::getTotalPrice)
                    .reduce(0.0, Double::sum));

        return response.build();
    }
}
