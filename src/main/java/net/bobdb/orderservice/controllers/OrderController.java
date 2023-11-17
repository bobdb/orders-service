package net.bobdb.orderservice.controllers;

import net.bobdb.orderservice.dto.OrderLineItemDTO;
import net.bobdb.orderservice.dto.OrderRequest;
import net.bobdb.orderservice.models.Order;
import net.bobdb.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<String> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed";
    }


}
