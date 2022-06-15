package com.finalproject.ansewerservice;

import com.finalproject.ansewerservice.dto.UserDto;
import com.finalproject.ansewerservice.helpers.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AnsewerServiceApplication {

	public static void main(String[] args) {


		JwtHelper jwt = new JwtHelper();
		UserDto user= new UserDto();
		List<String> roles= new ArrayList<>();
		roles.add("ADMIN");
		user.setUserId("1cd35cde-febd-41af-99bf-578c1f61f78c");
		user.setName("Shadi");
		user.setUserName("Shadi");
		user.setEmailAddress("saldabbas@miu.edu");
		user.setRoles(roles);
		var token= jwt.generateToken("hasimyilmaz",user);

		System.out.println(token);
		var test = jwt.getUserFromToken(token);
		System.out.println(test.getUserId());

		SpringApplication.run(AnsewerServiceApplication.class, args);
	}



}
