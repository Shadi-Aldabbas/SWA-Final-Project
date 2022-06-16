package com.SWAFinalProject.userservice;

import com.SWAFinalProject.userservice.dto.TokenDto;
import com.SWAFinalProject.userservice.helpers.JwtHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class UserServiceApplication {


    public static void main(String[] args) {
        JwtHelper jwt = new JwtHelper();
        TokenDto user = new TokenDto();
        List<String> roles = new ArrayList<String>();
        roles.add("ADMIN");
        user.setUserId("1cd35cde-febd-41af-99bf-578c1f61f78c");
        user.setName("Shadi");
        user.setUserName("Shadi");
        user.setEmailAddress("saldabbas@miu.edu");
        user.setRoles(roles);
        var token = jwt.generateToken("hasimyilmaz", user);

        System.out.println(token);

        SpringApplication.run(UserServiceApplication.class, args);
    }

}
