package com.SWAFinalProject.userservice.service.impl;

import com.SWAFinalProject.userservice.exception.DataDuplicationException;
import com.SWAFinalProject.userservice.exception.NoContentFoundException;
import com.SWAFinalProject.userservice.repository.UserRepository;
import com.SWAFinalProject.userservice.service.UserService;
import com.SWAFinalProject.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    KafkaTemplate<String, List<String>> kafkaTemplate;

    private static final String TOPIC = "myTopicName";


    @Override
    public User findById(UUID id) {
//        TODO
//        String encodedPassword = passwordEncoder. (user.getPassword());
//        user.setPassword(encodedPassword);
        return userRepository.findById(id).orElseThrow(() -> {
            throw new NoContentFoundException("User Not Found sorry");
        });
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoContentFoundException("User(s) is Empty, No data Found");
        }
        return users;
    }

    @Override
    public User saveUser(User user) {
//        TODO
//        User existedUser = userRepository.findUserByEmailAddress(user.getEmailAddress());
//        if (Objects.nonNull(existedUser)) {
//            throw new DataDuplicationException("User with Email Address " + user.getEmailAddress() + "already exists");
//        }
        user.setUserId(UUID.randomUUID());
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User createdUser = userRepository.save(user);
        List<String> userIdAndEmail = new ArrayList<>();
        userIdAndEmail.add(user.getUserId().toString());
        userIdAndEmail.add(user.getEmailAddress());
        kafkaTemplate.send(TOPIC, userIdAndEmail);
        return createdUser;
    }


    @Override
    public Object update(User user, UUID id) {
//        TODO
//        User existedUser = userRepository.findUserByEmailAddress(user.getEmailAddress());
//        if (Objects.nonNull(existedUser)) {
//            throw new DataDuplicationException("User with Email Address " + user.getEmailAddress() + "already exists");
//        }
        User foundUser = userRepository.findById(id).map(u -> {
            u.setName(user.getName());
            u.setUserName(user.getUserName());
            u.setEmailAddress(user.getEmailAddress());
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            u.setRoles(user.getRoles());
            return userRepository.save(u);
        }).orElseThrow(() -> {
            throw new NoContentFoundException("User Not Found");
        });
        return foundUser;
    }

    @Override
    public void delete(UUID id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}

