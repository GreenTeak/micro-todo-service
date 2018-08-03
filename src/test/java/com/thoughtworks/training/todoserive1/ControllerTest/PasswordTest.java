package com.thoughtworks.training.todoserive1.ControllerTest;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    @Test
    public void shouldEncryPassword(){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();


        String encodedpassword = encoder.encode("password");

        encoder.matches("password",encodedpassword);
    }
}
