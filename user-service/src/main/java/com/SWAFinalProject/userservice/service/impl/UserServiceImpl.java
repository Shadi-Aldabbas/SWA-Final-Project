package com.SWAFinalProject.userservice.service.impl;
import com.SWAFinalProject.userservice.model.User;
import com.SWAFinalProject.userservice.repository.UserRepository;
import com.SWAFinalProject.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) throws Exception {
        return userRepository.findById(id).orElseThrow(()-> new Exception("No content Found!"));
    }

    public Object update(User user, String id) throws Exception {
        User foundUser = userRepository.findById(id).map(u -> {
            u.setName(user.getName());
            u.setUserName(user.getUserName());
            u.setEmailAddress(user.getEmailAddress());
            u.setPassword(user.getPassword());
            u.setRole(user.getRole());
            return userRepository.save(u);
        }).orElseThrow(() -> new Exception("No Content Found"));
        return foundUser;
    }

    public void delete(String id) throws Exception {
        User user = findById(id);
        userRepository.delete(user);
    }
}
