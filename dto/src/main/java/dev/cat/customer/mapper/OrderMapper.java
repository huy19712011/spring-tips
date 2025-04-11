package dev.cat.customer.mapper;

import dev.cat.customer.dto.OrderResponse;
import dev.cat.customer.entity.Order;
import dev.cat.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderResponse mapToOrderResponse(Order order);

}








