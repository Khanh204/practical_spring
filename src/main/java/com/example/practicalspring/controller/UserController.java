package com.example.practicalspring.controller;

import com.example.practicalspring.entities.User;
import com.example.practicalspring.service.UserService;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
@Autowired
private UserService userService;
@GetMapping()
public List<User> getAllUser(){
return userService.getAll();
}
@PostMapping()
public User createUSer(@RequestBody User user){
    return userService.createUser(user);
}
@PutMapping("/{id}")
public User updateUser (@PathVariable Long id, @RequestBody User user){
return  userService.updateUser(id,user);
}
@DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
    userService.deleteUser(id);
}
@GetMapping("/search")
public  List<User>search( String name){
    return userService.searchUser(name);
    }
}
