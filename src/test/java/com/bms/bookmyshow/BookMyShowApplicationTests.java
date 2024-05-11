package com.bms.bookmyshow;

import com.bms.bookmyshow.Controllers.UserController;
import com.bms.bookmyshow.Dtos.SignupRequestDto;
import com.bms.bookmyshow.Dtos.SignupResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyShowApplicationTests {
	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSignupFeature()
	{
		SignupRequestDto requestDto=new SignupRequestDto();
		requestDto.setName("Venkatesh");
		requestDto.setEmail("venkatesh@bms.com");
		requestDto.setPassword("venkatesh");

		SignupResponseDto responseDto=userController.signup(requestDto);

		System.out.println(responseDto);
	}

}
