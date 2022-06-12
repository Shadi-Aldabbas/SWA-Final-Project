package com.SWAFinalProject.userservice.service;

import com.SWAFinalProject.userservice.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public List<User> findAll();

    public User findById(String id) throws Exception;


    public Object update(User user, String id) throws Exception;


    public void delete(String id) throws Exception;
}
