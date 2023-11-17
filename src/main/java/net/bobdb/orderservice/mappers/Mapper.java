package net.bobdb.orderservice.mappers;

import net.bobdb.orderservice.dto.OrderLineItemDTO;
import net.bobdb.orderservice.models.OrderLineItem;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public OrderLineItem mapToObject(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setSkucode(orderLineItemDTO.getSkucode());
        orderLineItem.setPrice(orderLineItemDTO.getPrice());
        orderLineItem.setQuantity(orderLineItem.getQuantity());
        return orderLineItem;
    }
}
