package com.SWAFinalProject.AuthService.runner;

import java.util.Arrays;
import java.util.UUID;

import com.SWAFinalProject.AuthService.entity.User;
import com.SWAFinalProject.AuthService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;



    @Override
    public void run(String... args) throws Exception {



        User admin = new User();
        admin.setEmail("admin@admin.com");
        admin.setPassword("1");
        admin.setRoles("ADMIN");
        admin.setId(UUID.randomUUID());
        User normal = new User();
        normal.setEmail("normal@normal.com");
        normal.setId(UUID.randomUUID());
        normal.setRoles("NORMAL");
        normal.setPassword("1");

        userRepo.saveAll(Arrays.asList(
                admin,normal
        ));

        System.out.println("----------All User Data saved into Database----------------------");
        System.out.println("----------email for admin:admin@admin.com pass:1----------------------");
        System.out.println("----------email for normal user:normal@normal.com pass:1----------------------");
    }
}
