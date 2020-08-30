package pl.mbo.ordermanager.controller;

import org.springframework.web.bind.annotation.*;
import pl.mbo.ordermanager.model.Orders;
import pl.mbo.ordermanager.model.User;
import pl.mbo.ordermanager.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(path="/order")
//@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable(name = "id") Long id){return orderService.findById(id);}

    //todo: deletemapping bez remove
    @GetMapping("/remove/{id}")
    public void removeOrderById(@PathVariable(name = "id") Long id) {boolean success = orderService.deleteOrder(id);}

    //todo: bez upadte, samo id
//    @PatchMapping("/update/{id}")
//    public void updateOrder(@PathVariable(name = "id") Long id,@RequestBody User user){
//        boolean success = orderService.updateOrder(id, user);
//    }
}
