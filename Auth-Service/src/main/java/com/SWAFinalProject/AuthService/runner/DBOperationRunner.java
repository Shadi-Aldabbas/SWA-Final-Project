package com.SWAFinalProject.AuthService.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.SWAFinalProject.AuthService.entity.User;
import com.SWAFinalProject.AuthService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {



        User admin = new User();
        admin.setEmailAddress("admin@admin.com");
        String encodedPassword = passwordEncoder.encode("1");
        admin.setPassword(encodedPassword);
        List<String> adminRole = new ArrayList<>();
        adminRole.add("ADMIN");
        admin.setRoles(adminRole);
        admin.setUserId(UUID.randomUUID());


        User normal = new User();
        normal.setEmailAddress("normal@normal.com");
        normal.setUserId(UUID.randomUUID());
        List<String> normalRole = new ArrayList<>();
        normalRole.add("NORMAL");
        normal.setRoles(normalRole);
        normal.setPassword(encodedPassword);

        userRepo.saveAll(Arrays.asList(
                admin,normal
        ));

        System.out.println("----------All User Data saved into Database----------------------");
        System.out.println("----------email for admin:admin@admin.com pass:1----------------------");
        System.out.println("----------email for normal user:normal@normal.com pass:1----------------------");
    }
}
