package com.smtech.user_service;

import com.smtech.user_service.entity.User;
import com.smtech.user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserServiceApplicationTests {

	public static final int NUMBER_OF_USERS = 10;

	@Autowired
	private  UserRepository userRepository;



    @Test
	void contextLoads() {
	}

	@Test
	void addUsersToDB(){
		for(int i = 1; i<= NUMBER_OF_USERS; i++){
			User user= User.builder()
					.name("User "+i)
					.surname("Surname "+i)
					.email("user"+i+"@example.com")
					.address("Address "+i)
					.alerting(i % 2 == 0)
					.emergencyAlertingThreshold(1000.0+i)
					.build();

			userRepository.save(user);

		}
		log.info("Users added to database");
	}


}
