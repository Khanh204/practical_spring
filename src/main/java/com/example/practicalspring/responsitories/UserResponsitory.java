package com.example.practicalspring.responsitories;

import com.example.practicalspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserResponsitory extends JpaRepository<User,Long> {
List<User>findAllByNameContaining(String name);
}
