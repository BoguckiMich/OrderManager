package pl.mbo.ordermanager.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String town;
    private String address;
    private String phone;

//    @OneToMany(mappedBy = "client")
//    private Set<Orders> setOrders;
}
