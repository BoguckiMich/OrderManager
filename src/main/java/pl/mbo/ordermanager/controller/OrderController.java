package pl.mbo.ordermanager.controller;

import org.springframework.web.bind.annotation.*;
import pl.mbo.ordermanager.model.Orders;
import pl.mbo.ordermanager.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(path="/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody Orders order){
        boolean success = orderService.createOrder(order);
    }

    @GetMapping("")
    public List<Orders> getOrders(){return orderService.findAllOrders();}
}
