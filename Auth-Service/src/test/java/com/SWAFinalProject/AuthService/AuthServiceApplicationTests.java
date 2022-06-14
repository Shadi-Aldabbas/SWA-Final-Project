package com.SWAFinalProject.AuthService;

import com.SWAFinalProject.AuthService.repository.UserRepo;
import com.SWAFinalProject.AuthService.service.UaaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AuthServiceApplicationTests {

	@Autowired
	private UaaService uaaService;

	@Autowired
	private UserRepo userRepo;

	public void Login(){


	}

}
