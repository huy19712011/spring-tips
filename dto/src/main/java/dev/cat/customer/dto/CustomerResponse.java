package dev.cat.customer.dto;


import lombok.Builder;
import java.util.List;

@Builder
public record CustomerResponse(Long id,
                               String name,
                               String email,
                               List<OrderResponse> orders,
                               double totalExpenses) {
}
















