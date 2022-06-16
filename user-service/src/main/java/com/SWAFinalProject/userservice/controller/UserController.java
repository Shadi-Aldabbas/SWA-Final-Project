package com.SWAFinalProject.userservice.controller;

import com.SWAFinalProject.userservice.helpers.JwtHelper;
import com.SWAFinalProject.userservice.entity.User;
import com.SWAFinalProject.userservice.exception.NoContentFoundException;
import com.SWAFinalProject.userservice.exception.UnAuthorizedException;
import com.SWAFinalProject.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    JwtHelper jwt = new JwtHelper();


    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) throws Exception {
        return new ResponseEntity<>(
                userService.findById(id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody User user, @RequestHeader("Authorization") String token) throws Exception {
        if (jwt.validateToken(token) && jwt.getUserFromToken(token).getUserId() != null) {
            var allowedUser = userService.findById(id);
            if (allowedUser.getUserId() == null) {
                throw new NoContentFoundException("User Not Found!");
            }
            return new ResponseEntity<>(userService.update(user, id), HttpStatus.CREATED);

        }
        throw new UnAuthorizedException("User Not allowed for this operation!");

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id, @RequestHeader("Authorization") String token) throws Exception {
        if (jwt.validateToken(token) && jwt.getUserFromToken(token).getUserId() != null) {
            var allowedUser = userService.findById(id);
            if (allowedUser.getUserId() == null) {
                throw new NoContentFoundException("User Not Found!");
            }
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        throw new UnAuthorizedException("User Not allowed for this operation!");

    }

}


