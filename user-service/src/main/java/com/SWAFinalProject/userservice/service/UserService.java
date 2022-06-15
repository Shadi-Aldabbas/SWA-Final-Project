package com.SWAFinalProject.userservice.service;

import com.SWAFinalProject.userservice.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpClient;
import java.util.List;
import java.util.UUID;

public interface UserService {
    public User saveUser(User user);

    public List<User> findAll();

    public User findById(UUID id);


    public void update(User user, UUID id, String token) throws JsonProcessingException;


    public void delete(UUID id);
}
