package pl.mbo.ordermanager.service;

import org.springframework.stereotype.Service;
import pl.mbo.ordermanager.model.Orders;
import pl.mbo.ordermanager.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderReppository;

    public OrderService(OrderRepository orderRepository) { this.orderReppository = orderRepository;}

    public boolean createOrder(Orders order) {
        Orders order1 = Orders.builder()
                .name(order.getName())
                .orderStatus(order.getOrderStatus())
                .build();

        orderReppository.save(order1);

        return false;
    }

    public List<Orders> findAllOrders() {
        return orderReppository.findAll();
    }
}
