package pl.mbo.ordermanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
