package com.example.practicalspring.service;

import com.example.practicalspring.entities.User;
import com.example.practicalspring.responsitories.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
@Autowired
    private UserResponsitory userResponsitory;
public List<User> getAll(){
return userResponsitory.findAll();
}
public User createUser(User user){
return userResponsitory.save(user);
}
public User updateUser(Long id,User user){
return userResponsitory.findById(id)
        .map(u->{
                u.setName(user.getName());
                u.setAge(user.getAge());
                u.setSalary(user.getSalary());
                return userResponsitory.save(u);
        })
        .orElseGet(()-> {
            user.setId(id);
            return userResponsitory.save(user);
        });

}
public void deleteUser(Long id){
userResponsitory.deleteById(id);
}
public List<User> searchUser(String name){
return userResponsitory.findAllByNameContaining(name);
}
}
