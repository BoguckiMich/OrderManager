package pl.mbo.ordermanager.service;

import org.springframework.stereotype.Service;
import pl.mbo.ordermanager.model.OrderDto;
import pl.mbo.ordermanager.model.Orders;
import pl.mbo.ordermanager.model.User;
import pl.mbo.ordermanager.model.UserDto;
import pl.mbo.ordermanager.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean createOrder(OrderDto orderDto) {
        Orders order = Orders.builder()
                .name(orderDto.getName())
                .orderStatus(orderDto.getOrderStatus())
                .build();

        orderRepository.save(order);

        return false;
    }

    public List<OrderDto> findAllOrders() {
         return (List<OrderDto>)orderRepository.findAll()
                .stream()
                .map(this::convertOrderToOrderDto)
                .collect(Collectors.toList());
    }
//    public List<OrderDto> findAllOrders() {
//        return orderRepository.findAll()
//                .stream()
//                .map(OrderDto::new)
//                .collect(Collectors.toList());
//    }

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

    private OrderDto convertOrderToOrderDto(Orders orders){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orders.getId());
        orderDto.setName(orders.getName());
        orderDto.setOrderStatus(orders.getOrderStatus());
        orderDto.setUserDto(UserDto.builder()
                .firstName(orders.getUser().getFirstName())
                .lastName(orders.getUser().getLastName())
                .phone(orders.getUser().getPhone()).build());
        return orderDto;
    }
}
