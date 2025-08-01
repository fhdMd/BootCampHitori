package com.example.kickoff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@Configuration
public class Config {
    @Bean
    public Argon2PasswordEncoder encoder(){
        return new Argon2PasswordEncoder(16, 32, 1, 60000, 10);
    }
}
