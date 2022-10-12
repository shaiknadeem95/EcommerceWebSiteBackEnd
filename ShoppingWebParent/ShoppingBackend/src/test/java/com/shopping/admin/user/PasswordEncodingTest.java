package com.shopping.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodingTest {

	@Test
	public void testEncodedPasswords()
	{
		BCryptPasswordEncoder bCryptEncoder=new BCryptPasswordEncoder();
		String passwordForTest="nadeem20";
		String encriptedPassword=bCryptEncoder.encode(passwordForTest);
		System.out.println(encriptedPassword);
		boolean isMatch=bCryptEncoder.matches(passwordForTest, encriptedPassword);
		assertThat(isMatch).isTrue();
	}
}
