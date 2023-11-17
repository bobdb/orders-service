package net.bobdb.orderservice.services;

import net.bobdb.orderservice.dto.OrderLineItemDTO;
import net.bobdb.orderservice.dto.OrderRequest;
import net.bobdb.orderservice.models.Order;
import net.bobdb.orderservice.models.OrderLineItem;
import net.bobdb.orderservice.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrdersRepository ordersRepository;

    public List<String> getAllOrders() {
        List<Order> orderList =  ordersRepository.findAll();
        return orderList.stream().map(o->o.getOrdernumber()).toList();
    }

    public void placeOrder(OrderRequest orderRequest) {
        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemDTOList()
                                                            .stream()
                                                            .map(this::mapToObject)
                                                            .toList();
        Order order = new Order();
        order.setOrdernumber(UUID.randomUUID().toString());
        order.setOrderlineitemlist(orderLineItemList);

        ordersRepository.save(order);

    }

    private OrderLineItem mapToObject(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setSkucode(orderLineItemDTO.getSkucode());
        orderLineItem.setPrice(orderLineItemDTO.getPrice());
        orderLineItem.setQuantity(orderLineItem.getQuantity());
        return orderLineItem;
    }

}
