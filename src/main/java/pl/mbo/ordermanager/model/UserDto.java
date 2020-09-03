package pl.mbo.ordermanager.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean can_create_order;
    private Boolean can_assign_order;

//    public UserDto(User user){
//        this.id = user.getId();
//        this.firstName = user.getFirstName();
//        this.lastName =user.getLastName();
//        this.phone=user.getPhone();
//    }
}
