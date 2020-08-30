package pl.mbo.ordermanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.mbo.ordermanager.model.User;
import pl.mbo.ordermanager.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){boolean success = userService.addUser(user);}

    @GetMapping("")
    public List<User> getUserList(){ return userService.findAllUsers();}

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") Long id){
        return userService.findUserById(id);
    }
}
