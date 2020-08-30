package pl.mbo.ordermanager.service;

import org.springframework.stereotype.Service;
import pl.mbo.ordermanager.model.Orders;
import pl.mbo.ordermanager.model.User;
import pl.mbo.ordermanager.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean createOrder(Orders order) {
        Orders order1 = Orders.builder()
                .name(order.getName())
                .orderStatus(order.getOrderStatus())
                .build();

        orderRepository.save(order1);

        return true;
    }

    public List<Orders> findAllOrders() {
        return orderRepository.findAll();
    }

    public Orders findById(Long id) {
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        return optionalOrders.orElse(null);
    }

    public boolean deleteOrder(Long id) {
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        if (optionalOrders.isPresent()) {
            orderRepository.deleteById(id);
        }
        return false;
    }

    public boolean updateOrder(Long id, User user) {
        //todo: czy user istnieje
        return orderRepository.findById(id).map(o -> {
            o.setUser(user);
            orderRepository.save(o);
            return true;
        }).orElse(false);
    }
}
