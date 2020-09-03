package pl.mbo.ordermanager.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private OrderStatus orderStatus;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
