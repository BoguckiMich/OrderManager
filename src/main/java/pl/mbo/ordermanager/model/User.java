package pl.mbo.ordermanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean can_create_order;
    private Boolean can_assign_order;
    private String password;
    private String mail;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Orders> orders;

}
