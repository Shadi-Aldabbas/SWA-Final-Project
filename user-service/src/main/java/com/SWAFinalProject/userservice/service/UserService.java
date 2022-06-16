package com.SWAFinalProject.userservice.service;

import com.SWAFinalProject.userservice.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public User saveUser(User user);

    public List<User> findAll();

    public User findById(UUID id);


    public User update(User user, UUID id);


    public void delete(UUID id);
}
