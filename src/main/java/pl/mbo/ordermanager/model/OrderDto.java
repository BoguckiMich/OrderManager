package pl.mbo.ordermanager.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String name;
    private OrderStatus orderStatus;
    private UserDto userDto;

    public OrderDto (Orders orders){
        this.id = orders.getId();
        this.name = orders.getName();
        this.orderStatus = orders.getOrderStatus();
        this.userDto = UserDto.builder()
                .firstName(orders.getUser().getFirstName())
                .lastName(orders.getUser().getLastName())
                .phone(orders.getUser().getPhone()).build();
    }
}


