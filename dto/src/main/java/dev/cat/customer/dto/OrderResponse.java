package dev.cat.customer.dto;

import lombok.Builder;

@Builder
public record OrderResponse(Long id,
                            double totalPrice) {

}






















