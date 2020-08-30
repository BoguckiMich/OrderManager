package pl.mbo.ordermanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean can_create_order;
    private Boolean can_assign_order;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Orders> ordersSet;
}
