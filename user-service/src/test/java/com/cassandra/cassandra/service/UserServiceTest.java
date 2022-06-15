package com.cassandra.cassandra.service;

import com.SWAFinalProject.userservice.entity.User;
import com.SWAFinalProject.userservice.repository.UserRepository;
import com.SWAFinalProject.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @Test
    void findAllUser() {
        userService.findAll();
        verify(userRepository).findAll();
    }

    @Test
    void saveUser(User user) {
        userService.saveUser(user);
        verify(userRepository).save(user);
    }

    @Test
    void findById(UUID userId) {
        userService.findById(userId);
        verify(userRepository).findById(userId);
    }

    @Test
    void delete(UUID userId) {
        userService.delete(userId);
        verify(userRepository).delete(userService.findById(userId));
    }

}
