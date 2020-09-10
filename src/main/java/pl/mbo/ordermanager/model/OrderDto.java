package pl.mbo.ordermanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String name;
    private OrderStatus orderStatus;
    private UserDto userDto;
    private Client client;

    public OrderDto (Orders orders) {
        this.id = orders.getId();
        this.name = orders.getName();
        this.orderStatus = orders.getOrderStatus();
        Client client = orders.getClient();
        if (client != null) {
            this.client = orders.getClient();
        }
        User user = orders.getUser();
        if (user != null) {
            this.userDto = UserDto.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .phone(user.getPhone())
                    .build();
        }

    }
}


